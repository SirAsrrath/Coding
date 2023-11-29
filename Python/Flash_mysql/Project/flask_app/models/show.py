from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user
from flask import flash

mydb = 'black_belt'


class Recipe:
    def __init__(self,data):
        print(data)
        self.id = data['id']
        self.name = data['name']
        self.instructions = data['instructions']
        self.description = data['description']
        self.user_id = data['user_id']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']


    @classmethod
    def get_all(cls):
        query = "SELECT * FROM shows;"
        results = connectToMySQL(mydb).query_db(query)
        print(results)
        shows = []
        for u in results:
            shows.append( cls(u) )
        return shows

    @classmethod
    def save(cls, data):
        query = "INSERT INTO shows (title, network, release_date, description, user_id) VALUES (%(title)s,%(network)s,%(release_date)s,%(description)s, %(user_id)s);"
        result = connectToMySQL(mydb).query_db(query,data)
        return result

    @classmethod
    def get(cls,data):
        query  = "SELECT * FROM shows WHERE id = %(id)s";
        result = connectToMySQL(mydb).query_db(query,data)
        return cls(result[0])

    @classmethod
    def update(cls,data):
        query = "UPDATE shows SET title=%(title)s,network=%(network)s,release_date=%(release_date)s,description=%(description)s,updated_at=NOW() WHERE id = %(id)s;"
        return connectToMySQL(mydb).query_db(query,data)

    @classmethod
    def delete(cls,data):
        query  = "DELETE FROM shows WHERE id = %(id)s;"
        return connectToMySQL(mydb).query_db(query,data)
    
    @staticmethod
    def validate_show(show):
        is_valid = True # we assume this is true
        if len(show['title']) < 3:
            flash("title must be at least 3 characters.")
            is_valid = False
        if len(show['network']) < 3:
            flash("network must be at least 3 characters.")
            is_valid = False
        if len(show['description']) < 3:
            flash("description should at least 3 characters.")
            is_valid = False
        if len(show['description']) == 0:
            flash("Please enter a description.")
            is_valid = False
        return is_valid
    
    @classmethod
    def get_user_with_shows( cls ):
        query = "SELECT * FROM shows JOIN users ON shows.user_id = users.id ;"
        results = connectToMySQL(mydb).query_db( query )
        output = []
        for row in results:
            output.append(cls(row) )
            print(output)
            user_data = {
                "id" : row['users.id'],
                "first_name" : row['first_name'],
                "last_name" : row['last_name'],
                "email" : row['email'],
                "password" : row['password']
            }


