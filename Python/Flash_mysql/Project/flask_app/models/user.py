from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import show
from flask import flash, request
from flask_bcrypt import Bcrypt
import re


bcrypt = Bcrypt(app)
mydb = 'black_belt'

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.shows = []

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL(mydb).query_db(query)
        users = []
        for u in results:
            users.append( cls(u) )
        print(results)
        return users

    @classmethod
    def save(cls, data):
        query = "INSERT INTO users (first_name,last_name,email,password) VALUES (%(first_name)s,%(last_name)s,%(email)s,%(password)s);"
        
        # comes back as the new row id
        result = connectToMySQL(mydb).query_db(query,data)
        print(result)
        return result

    @classmethod
    def get(cls,data):
        query  = "SELECT * FROM users WHERE id = %(id)s";
        result = connectToMySQL(mydb).query_db(query,data)
        return cls(result[0])
    
    @staticmethod
    def validate_user(user):
        is_valid = True # we assume this is true
        if len(user['first_name']) < 2:
            flash("Name must be at least 2 characters." , "RegError")
            is_valid = False
        if len(user['last_name']) < 2:
            flash("Name must be at least 2 characters." , "RegError")
            is_valid = False
        if len(user['email']) < 3:
            flash("Invalid email.", "RegError")
            is_valid = False
        elif not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!" , "LogError")
            is_valid = False
        if len(user['password']) < 8:
            flash("Password must be at least 8 characters.", "RegError")
            is_valid = False
        if user['cpassword'] != user['password']:
            flash("Passwords must match.", "RegError")
            is_valid = False
        # this_user = user.get_by_email(request)
        # if this_user:
        #     is_valid = False
        #     flash('Email already exists.')
        # return is_valid
    
    @staticmethod
    def validate_login( user ):
        is_valid = True
        # test whether a field matches the pattern
        if not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!" , "LogError")
            is_valid = False
        if len(user['password']) == 0:
            flash("Invalid password!" , "LogError")
            is_valid = False
        return is_valid

    @classmethod
    def get_by_email(cls,data):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        result = connectToMySQL(mydb).query_db(query,data)
        # Didn't find a matching user
        if len(result) < 1:
            return False
        return cls(result[0])
    


