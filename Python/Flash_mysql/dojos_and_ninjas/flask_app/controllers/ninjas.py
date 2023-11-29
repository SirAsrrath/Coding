from flask import  render_template, request, redirect
from flask_app import app 

from flask_app.models.users import Ninja
from flask_app.models.users import Dojo

@app.route('/')
def index():
    return redirect('/dojos')

#main site

@app.route('/dojos')
def dojos():
    
    return render_template("dojos.html", dojos=Dojo.get_dojos())

#Ninja Creation

@app.route('/ninjas')
def new():
    return render_template("ninjas.html", dojos=Dojo.get_dojos())

@app.route('/ninjas/create',methods=['POST'])
def create():
    
    Ninja.save(request.form)
    print(request.form)
    return redirect('/ninjas')

#Ninja Edit

@app.route('/ninjas/edit/<int:id>')
def edit(id):
    data ={ 
        "id":id
    }
    return render_template("edit_ninja.html",ninja=Ninja.get_ninja_id(data))

#Show all the ninjas in a specific dojo

@app.route('/dojos/<int:id>')
def show(id):
    data ={ 
        "id":id
    }
    
    
    return render_template("show_dojo.html",dojo=Dojo.get_dojo_id(data), ninjas=Ninja.get_ninjas(data))

#Update ninja 


@app.route('/ninjas/update',methods=['POST'])
def update():
    Ninja.update(request.form)
    return redirect('/dojos')

@app.route('/ninjas/delete/<int:id>')
def destroy(id):
    data ={
        'id': id
    }
    Ninja.destroy(data)
    return redirect('/dojos/<int:id>')

#Create Dojo

@app.route('/dojos/create',methods=['POST'])
def create_dojo():
    print(request.form)
    Dojo.save(request.form)
    return redirect('/dojos')