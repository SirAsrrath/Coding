from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re

mydb = 'login_and_registration'

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
        self.on_trees = []

    @classmethod
    def save(cls, data):
        query = "INSERT INTO users (first_name,last_name,email,password) VALUES (%(first_name)s,%(last_name)s,%(email)s,%(password)s, NOW(),NOW());"
        result = connectToMySQL(mydb).query_db(query,data)
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
            flash("Name must be at least 2 characters.")
            is_valid = False
        if len(user['last_name']) < 2:
            flash("Name must be at least 2 characters.")
            is_valid = False
        if len(user['email']) < 3:
            flash("Invalid email.")
            is_valid = False
        if len(user['password']) < 8:
            flash("Password must be at least 8 characters.")
            is_valid = False
        if user['cpassword'] != user['password']:
            flash("Passwords must match.")
            is_valid = False
        if EMAIL_REGEX.match(user['email']):
            flash("Email already exists.")
            is_valid = False
        return is_valid
    
    @staticmethod
    def validate_login( user ):
        is_valid = True
        # test whether a field matches the pattern
        if not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!")
            is_valid = False
        if len(user['password']) == 0:
            flash("Invalid password!")
            is_valid = False
        return is_valid