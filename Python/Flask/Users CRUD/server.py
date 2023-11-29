from flask import Flask, render_template, request, redirect
from users import Post


app = Flask(__name__)
app.secret_key = 'root'

@app.route('/')
def index():

    return redirect('/display')



#Route for displaying all users 

@app.route('/display')
def display_all_users():
    return render_template('read_all.html', users = Post.get_all ())


#Route to create a new user

@app.route('/create')
def create_user():
    Post.save(request.form)
    return render_template('create.html')

@app.route('/create/new', methods=['POST'])
def create():
    return redirect('/display')


if __name__ == "__main__":
    app.run(debug=True)