from flask import render_template, request, redirect, session, flash
from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user,show
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)
mydb = 'black_belt'


#   Main Page
@app.route('/')
def index():
    return render_template('index.html')

#   User Dashboard with all shows
@app.route('/shows')
def users():
    # if 'user_id' in session:
        return render_template("user_dashboard.html",shows=show.Show.get_all(), shows2 = show.Show.get_user_with_shows())
    # return redirect ('/')

#   Show Creation Page
@app.route('/shows/new')
def new():
    if 'id' in session:
        return render_template("create.html")
    return redirect('/')

#   Show Post Method

@app.route('/shows/create',methods=['POST'])
def create_show():
    if not show.Show.validate_show(request.form):
        return redirect('/shows/new')
    print(request.form)
    show.Show.save(request.form)
    return redirect('/shows')



#   User Login / Registration
@app.route('/user/register',methods=['POST'])
def register():
    if user.User.validate_user(request.form):
        hash_pw = bcrypt.generate_password_hash(request.form['password'])
        data = {
            'first_name' : request.form['first_name'],
            'last_name' : request.form['last_name'],
            'email' : request.form['email'],
            'password' : hash_pw

        }
        print(request.form)
        user_id = user.User.save(data)
        session["user_id"] = user_id
        session['name'] = request.form['first_name']
    return redirect('/shows')

@app.route('/user/login',methods=['POST'])
def login():
    this_user = user.User.get_by_email(request.form)
    print(this_user)
    if this_user:
        if bcrypt.check_password_hash(this_user.password, request.form['password']):
            session["id"] = this_user.id
            session['name'] = this_user.first_name
            print(this_user.id)
            print(this_user.first_name)
            return redirect('/shows')
    flash("Invalid Credentials", 'LogError')
    return redirect('/')



#   Like/Unlike button/counter

@app.route('/like')
def likes():
    
    return redirect('/like/int')

@app.route('/like/<int:id>' , methods = ['POST'])
def like(id):
    id=str(show.Show.get(id))
    if 'count' not in session:
            session['count'] = 0
    else:
            session['count'] = session['count']
    if 'visits' not in session:
            session["visits"] = 1
    else:
            session["visits"] = session["visits"] + 1

    return redirect('/shows')

@app.route('/edit/<int:id>')
def edit(id):
    data ={ 
        "id":id
    }
    return render_template("show_edit.html",show=show.Show.get(data))



@app.route('/show/<int:id>')
def show(id):
    data ={ 
        "id":id
    }
    return render_template("show.html",show=show.Show.get(data))


@app.route('/show/update',methods=['POST'])
def update():
    if not show.Show.validate_show(request.form):
        show.Show.update(request.form)
        return redirect('/shows')
    return redirect('/edit<int:id>')

@app.route('/delete/<int:id>')
def delete(id):
    data ={
        'id': id
    }
    show.Show.delete(data)
    return redirect('/shows')

# @app.route('/user/account')
# def account():
#     return render_template('manage_show.html')

@app.route('/logout')
def logout():
    if 'user_id' in session:
        session.pop('loggedin', None)
        session.pop('name', None)
        return redirect('/')
    return redirect ('/')