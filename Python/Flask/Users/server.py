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
    
    return render_template('create.html')

@app.route('/create/new', methods=['POST'])
def create():
    Post.save(request.form)
    return redirect('/display')


#Show Users

@app.route('/user/<id>')
def view_user(id):
    print(id)
    id=Post.get_id(id)

    return render_template('read_one.html', id=id )

#Edit Users

@app.route('/user/edit/<int:id>')
def edit(id):
    
    id ={ 
        "id":id
    }
    return render_template("edit.html",id=Post.get_id(id))

@app.route('/user/update', methods = ['POST'])
def update():
    Post.update(request.form)
    return redirect('/display')

#delete users

@app.route('/delete/<int:id>')
def delete(id):
    id=Post.get_id(id)
    Post.destroy(id)
    return redirect('/display')


if __name__ == "__main__":
    app.run(debug=True)