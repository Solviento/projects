from flask import Flask, render_template, json, request
from flaskext.mysql import MySQL
from werkzeug import generate_password_hash, check_password_hash

mysql = MySQL()
app = Flask(__name__)

# MySQL configurations
app.config['MYSQL_DATABASE_USER'] = 'solviento'
app.config['MYSQL_DATABASE_PASSWORD'] = 'browni'
app.config['MYSQL_DATABASE_DB'] = 'blog_schema'
app.config['MYSQL_DATABASE_HOST'] = 'localhost'
mysql.init_app(app)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/showHome')
def showHome():
    return render_template('index.html')

@app.route('/publish', methods=['POST', 'GET'])
def publish():
    try:
        # _title = request.form.get('postTitle')
        _title = request.form['postTitle']
        _text = request.form['postText']
        # print(_title)
        # print(_text)
        if _title and _text:
            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.callproc('sp_savePostDemo', (_title, _text))
            data = cursor.fetchall()

            if len(data) is 0:
                conn.commit()
                return json.dumps({'message': 'Post saved successfully!'})
            else:
                return json.dumps({'error':str(data[0])})
        else:
            return json.dumps({'html':'<span>Enter the required fields</span>'})
    except Exception as e:
        return json.dumps({'error':str(e)})
    finally:
        cursor.close() 
        conn.close()

# TODO: create attach image function, work on retrieving post data and displaying it on home html

if __name__ == '__main__':
    app.run(port=5004)