from flask import Flask, render_template, json, request, redirect, session, jsonify, url_for
from flaskext.mysql import MySQL
from werkzeug import generate_password_hash, check_password_hash
from werkzeug.wsgi import LimitedStream
import datetime
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
app.config['UPLOAD_FOLDER'] = 'static/Uploads'  # needs to be declared, investigate further


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/showHome')
def showHome():
    return render_template('index.html')

@app.route("/showFeed")
def showFeed():
    return render_template('feed.html')


@app.route("/showDashboard")
def showDashboard():
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
            cursor.callproc('sp_getFeed', (_user, ))
            result = cursor.fetchall()

            posts_dict = []
            for post in result:
                post_dict = {
                    'PostId': post[0],
                    'Title': post[1],
                    'Description': post[2],
                    'FilePath': post[3],
                    'CreateDate': post[4].strftime('%m/%d/%y'),
                    'OwnerId': post[5]
                }

                # print(type(post[4]))
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
            _desc = _description[:999]
            _user = session.get('user')
            if request.form.get('newfilePath') is None:
                _filePath = ''
            else:
                _filePath = request.form.get('newfilePath')

            if request.form.get('private') is None:
                _private = 0
            else:
                _private = 1

            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.callproc(
                'sp_createPost',
                (_title, _desc, _user, _filePath, _private))
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


@app.route('/addPost', methods=['POST'])
def addPost():
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
                'sp_addPost',
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


@app.route('/getPost')#, methods=['POST'])
def getPost():
    try:
        if session.get('user'):
            _user = session.get('user')

            _total_records = 0

            con = mysql.connect()
            cursor = con.cursor()
            cursor.callproc('sp_GetPostByUser',
                            (_user, _total_records))
            posts = cursor.fetchall()

            cursor.close()

            cursor = con.cursor()
            cursor.execute('SELECT @_sp_GetPostByUser_3')


            outParam = cursor.fetchall()

            response = []
            posts_dict = []

            for post in posts:
                post_dict = {
                    'Id': post[0],
                    'Title': post[1],
                    'Description': post[2],
                    'Date': post[4].strftime('%m/%d/%y'),
                    'FilePath': post[5]
                }
                _desc = post_dict['Description'][:320]
                post_dict['Description'] = _desc
                posts_dict.append(post_dict)

            response.append(posts_dict)
            response.append({'total': outParam[0][0]})

            return json.dumps(response)
        else:
            return render_template('error.html', error='Unauthorized Access')
    except Exception as e:
        return render_template('error.html', error=str(e))


@app.route('/getPostById', methods=['POST'])
def getPostById():
    try:
        if session.get('user'):
            _id = request.form['id']
            _user = session.get('user')

            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.callproc('sp_GetPostById', (_id, _user))
            result = cursor.fetchall()

            post = []
            post.append({
                'Id': result[0][0],
                'Title': result[0][1],
                'Description': result[0][2],
                'FilePath': result[0][3],
                'Private': result[0][4]
            })

            return json.dumps(post)
        else:
            return render_template('error.html', error='Unauthorized Access')
    except Exception as e:
        return render_template('error.html', error=str(e))


@app.route('/updatePost', methods=['POST'])
def updatePost():
    try:
        if session.get('user'):
            _user = session.get('user')
            _title = request.form['title']
            _description = request.form['description']
            _post_id = request.form['id']
            _filePath = request.form['updatedfilePath']
            _isPrivate = request.form['isPrivate']
            print(type(_filePath))
            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.callproc(
                'sp_updatePost',
                (_title, _description, _post_id, _user, _filePath, _isPrivate))
            data = cursor.fetchall()

            if len(data) is 0:
                conn.commit()
                return json.dumps({'status': 'OK'})
            else:
                return json.dumps({'status': 'ERROR'})
    except Exception as e:
        return json.dumps({'status': 'Unauthorized access'})
    finally:
        cursor.close()
        conn.close()


@app.route('/deletePost', methods=['POST'])
def deletePost():
    try:
        if session.get('user'):
            _id = request.form['id']
            _user = session.get('user')

            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.callproc('sp_deletePost', (_id, _user))
            result = cursor.fetchall()

            if len(result) is 0:
                conn.commit()
                return json.dumps({'status': 'OK'})
            else:
                return json.dumps({'status': 'An Error occured'})
        else:
            return render_template('error.html', error='Unauthorized Access')
    except Exception as e:
        return json.dumps({'status': str(e)})
    finally:
        cursor.close()
        conn.close()


if __name__ == '__main__':
    app.run(debug=True, port=5004)