from flask_app.config.mysqlconnection import connectToMySQL

class Ninja:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.age = data['age']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']


    @classmethod
    def get_all(cls):
        query = "SELECT * FROM ninjas;"
        results = connectToMySQL('dojos_and_ninjas').query_db(query)
        dojos_and_ninjas = []
        for u in results:
            dojos_and_ninjas.append( cls(u) )
        return dojos_and_ninjas
    
    @classmethod
    def save(cls, data):
        query = "INSERT INTO ninjas (first_name,last_name,age) VALUES (%(first_name)s,%(last_name)s,%(age)s);"

        result = connectToMySQL('dojos_and_ninjas').query_db(query,data)
        return result

    @classmethod
    def get_ninja_id(cls,data):
        query  = "SELECT * FROM ninjas WHERE id = %(dojo_id)s;"
        result = connectToMySQL('dojos_and_ninjas').query_db(query,data)
        return cls(result[0])
    
    @classmethod
    def get_ninjas(cls,data):
        query = "SELECT * FROM ninjas WHERE dojo_id = %(id)s;"
        results = connectToMySQL('dojos_and_ninjas').query_db(query,data)
        ninjas = []
        for u in results:
            ninjas.append( cls(u) )
        return ninjas


    @classmethod
    def update(cls,data):
        query = "UPDATE ninjas SET first_name=%(first_name)s,last_name=%(last_name)s,email=%(email)s,updated_at=NOW() WHERE id = %(id)s;"
        return connectToMySQL('dojos_and_ninjas').query_db(query,data)

    @classmethod
    def destroy(cls,data):
        query  = "DELETE FROM ninjas WHERE id = %(id)s;"
        return connectToMySQL('dojos_and_ninjas').query_db(query,data)
    



class Dojo:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas=[]

    @classmethod
    def get_dojos(cls):
        query = "SELECT * FROM dojos;"
        results = connectToMySQL('dojos_and_ninjas').query_db(query)
        dojos = []
        for u in results:
            dojos.append( cls(u) )
        return dojos
    
    @classmethod
    def get_dojo_id(cls,data):
        query  = "SELECT * FROM dojos WHERE id = %(id)s;"
        result = connectToMySQL('dojos_and_ninjas').query_db(query,data)
        return cls(result[0])
    
    @classmethod
    def save(cls, data):
        query = "INSERT INTO dojos (`name`) VALUES (%(name)s);"

        result = connectToMySQL('dojos_and_ninjas').query_db(query,data)
        return result

    @classmethod
    def dojos_with_ninjas( cls , data ):
        query = "SELECT * FROM dojos LEFT JOIN ninjas ON ninjas.dojo_id = dojos.id WHERE dojos.id = %(id)s;"
        results = connectToMySQL('dojos_and_ninjas').query_db( query , data )
        dojo = cls( results[0] )
        for row_from_db in results:
            ninja_data = {
                "id" : row_from_db["ninjas.id"],
                "first_name" : row_from_db["ninjas.first_name"],
                "last_name" : row_from_db["ninjas.last_name"],
                "age" : row_from_db["age"],
            }
            dojo.ninjas.append( ninjas.Ninja( ninja_data ) )
        return dojo