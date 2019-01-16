from flask import Flask, render_template, json, request
from flaskext.mysql import MySQL
from werkzeug import generate_password_hash, check_password_hash

mysql = MySQL()
app = Flask(__name__)

# MySQL configurations
app.config['MYSQL_DATABASE_USER'] = 'solviento'
app.config['MYSQL_DATABASE_PASSWORD'] = 'browni'
app.config['MYSQL_DATABASE_DB'] = 'bucketlist'
app.config['MYSQL_DATABASE_HOST'] = 'localhost'
mysql.init_app(app)

@app.route('/')
def main():
    return render_template('index.html')

@app.route('/showSignUp')
def showSignUp():
    return render_template('signup.html')

@app.route('/showHome')
def showHome():
    return render_template('index.html')

@app.route('/signUp',methods=['POST','GET'])
def publish():
    try:
        _name = request.form['inputName']
        _email = request.form['inputEmail']
        _password = request.form['inputPassword']
        if _name and _email and _password:
            conn = mysql.connect()
            cursor = conn.cursor()
            _hashed_password = generate_password_hash(_password)
            # # print(type(_hashed_password))
            # _hashed_password2 = _hashed_password[0:45] #str(_hashed_password) + "heloooo"
            # print(_hashed_password2)
            # CANNOT USE HASHED_PASSWORD INSIDE STORED PROCEDURE CALL
            cursor.callproc('sp_createUser', (_name, _email, _hashed_password))
            print("1")
            data = cursor.fetchall()

            if len(data) is 0:
                conn.commit()
                return json.dumps({'message': 'Post saved successfully!'})
            else:
                print(data)
                return json.dumps({'error':str(data[0])})
        else:
            return json.dumps({'html':'<span>Enter the required fields</span>'})
    except Exception as e:
        return json.dumps({'error':str(e)})
    finally:
        cursor.close() 
        conn.close()

if __name__ == "__main__":
    app.run(port=5004)
