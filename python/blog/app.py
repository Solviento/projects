from flask import Flask, render_template, json, request, redirect, session, jsonify, url_for
from flaskext.mysql import MySQL
from werkzeug import generate_password_hash, check_password_hash
from werkzeug.wsgi import LimitedStream
import uuid
import os

mysql = MySQL()
app = Flask(__name__)
app.secret_key = 'secret key!'

# MySQL configurations
app.config['MYSQL_DATABASE_USER'] = 'solviento'
app.config['MYSQL_DATABASE_PASSWORD'] = 'browni'
app.config['MYSQL_DATABASE_DB'] = 'blog'
app.config['MYSQL_DATABASE_HOST'] = 'localhost'
app.config['TEMPLATES_AUTO_RELOAD'] = True
app.config['SEND_FILE_MAX_AGE_DEFAULT'] = 0
mysql.init_app(app)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/showHome')
def showHome():
    return render_template('index.html')

@app.route("/showFeed")
def showFeed():
    print("feed")
    return render_template('feed.html')


@app.route("/showDashboard")
def showDashboard():
    print("dashboard")
    return render_template('dashboard.html')


@app.route('/logout')
def logout():
    session.pop('user', None)
    return redirect('/')


@app.route('/showSignin')
def showSignin():
    if session.get('user'):
        return render_template('feed.html')
    else:
        return render_template('signin.html')


@app.route('/showRegister')
def showSignUp():
    return render_template('signup.html')


@app.route('/register', methods=['POST', 'GET'])
def register():
    try:
        _username = request.form['regUsername']
        _email = request.form['regEmail']
        _password = request.form['regPassword']
        if _username and _email and _password:
            conn = mysql.connect()
            cursor = conn.cursor()
            _hashed_pw = generate_password_hash(_password)
            # print(_username, _email, _hashed_pw)
            cursor.callproc('sp_createUser', (_username, _email, _hashed_pw))
            data = cursor.fetchall()
            # print("data", data)
            if len(data) is 0:
                print("user created")
                conn.commit()
                return redirect('/showDashboard')
                # return json.dumps({'message': 'User created!'})
            else:
                print("user not created")
                return json.dumps({'error': str(data[0])})
        else:
            print("error")
            return json.dumps({
                'html': '<span>Enter the required fields</span>'
            })
    except Exception as e:
        print("exception error ", e)
        return json.dumps({'error': str(e)})
    finally:
        cursor.close()
        conn.close()

@app.route('/validateLogin', methods=['POST'])
def validateLogin():
    try:
        _username = request.form['inputUsername']
        _password = request.form['inputPassword']
        # connect to mysql
        con = mysql.connect()
        cursor = con.cursor()
        cursor.callproc('sp_validateLogin', (_username, ))
        data = cursor.fetchall()
        if len(data) > 0:
            if check_password_hash(str(data[0][3]), _password):
                session['user'] = data[0][0]
                print("good to go")
                return redirect('/showFeed')
            else:
                print("incorrect password")
                return render_template('error.html', error='Wrong Password.')
        else:
            print("no data returned")
            return render_template('error.html', error='Wrong Email address.')
    except Exception as e:
        print("Exception error: " + str(e))
        return render_template('error.html', error=str(e))
    finally:
        cursor.close()
        con.close()


@app.route('/getAllPosts')
def getAllPosts():
    try:
        if session.get('user'):
            _user = session.get('user')
            conn = mysql.connect()
            cursor = conn.cursor()
            print(_user)
            cursor.callproc('sp_getFeed', (_user, ))
            result = cursor.fetchall()

            posts_dict = []
            for post in result:
                post_dict = {
                    'PostId': post[0],
                    'Title': post[1],
                    'Description': post[2],
                    'FilePath': post[3]
                }
                if (post[3] is None):
                    post['FilePath'] = 'static/Uploads/missing.jpg'
                posts_dict.append(post_dict)

            return json.dumps(posts_dict)
        else:
            return render_template('error.html', error='Unauthorized Access')
    except Exception as e:
        return render_template('error.html', error=str(e))


@app.route('/createPost', methods=['POST'])
def createPost():
    try:
        if session.get('user'):
            _title = request.form['inputTitle']
            _description = request.form['inputDescription']
            _user = session.get('user')
            if request.form.get('filePath') is None:
                _filePath = ''
            else:
                _filePath = request.form.get('filePath')

            if request.form.get('private') is None:
                _private = 0
            else:
                _private = 1

            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.callproc(
                'sp_createPost',
                (_title, _description, _user, _filePath, _private))
            data = cursor.fetchall()

            if len(data) is 0:
                conn.commit()
                return redirect('/showDashboard')
            else:
                return render_template(
                    'error.html', error='An error occurred!')
        else:
            return render_template('error.html', error='Unauthorized Access')
    except Exception as e:
        return render_template('error.html', error=str(e))
    finally:
        cursor.close()
        conn.close()


@app.route('/upload', methods=['GET', 'POST'])
def upload():
    # file upload handler code will be here
    if request.method == 'POST':
        file = request.files['file']
        extension = os.path.splitext(file.filename)[1]
        f_name = str(uuid.uuid4()) + extension
        file.save(os.path.join(app.config['UPLOAD_FOLDER'], f_name))
        return json.dumps({'filename': f_name})


if __name__ == '__main__':
    app.run(debug=True, port=5004)