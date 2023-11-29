from flask import render_template, redirect, request, session
from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user

mydb = 'login_and_registration'
app.secret_key = "123456789"



@app.route('/')
def index():
    return render_template('index.html')

@app.route('/user/create',methods=['POST'])
def create():
    if request.form['which_form'] == 'register':
        if not user.User.validate_user(request.form):
            return redirect('/')
        print(request.form)
        user.User.save(request.form)
        return redirect('/')
    elif request.form['which_form'] == 'login':
        if not user.User.validate_login(request.form):
            return redirect('/')
        
        if request.method == 'POST' and 'email' in request.form and 'password' in request.form:
            
            email = request.form['email']
            password = request.form['password']
            query = ('SELECT * FROM users WHERE email = % s AND password = % s', (email, password))
            login = connectToMySQL(mydb).query_db(query,data)
            connectToMySQL(mydb).
            
            if login:
                session['loggedin'] = True
                session['userid'] = user['userid']
                session['name'] = user['name']
                session['email'] = user['email']
                return render_template('login.html')
            else:
                return redirect('/login')
    return redirect('/login')

@app.route('/logout')
def logout():
    session.pop('loggedin', None)
    session.pop('name', None)
    return redirect('/')