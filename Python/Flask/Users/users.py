from config.mysqlconnection import connectToMySQL



class Post: 

    mydb = 'users'


    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    
    @classmethod
    def get_all(cls):
        query = 'SELECT * FROM users'
        results = connectToMySQL(cls.mydb).query_db(query)
        print(results)
        users = []
        for row in results:
            users.append(cls(row))
        return users
    
    @classmethod
    def save(cls, data):
        query = "INSERT INTO users (first_name, last_name, email) VALUES (%(first_name)s , %(last_name)s , %(email)s);"
        return connectToMySQL(cls.mydb).query_db(query,data)
    

    @classmethod
    def get_id(cls,data):
        query = """SELECT * from users WHERE id = %(id)s;"""
        results = connectToMySQL(cls.mydb).query_db(query, data)
        return cls(results[0])
    
    @classmethod
    def update(cls,data):
        query = "UPDATE users SET first_name=%(first_name)s,last_name=%(last_name)s,email=%(email)s,updated_at=NOW() WHERE id = %(id)s;"
        return connectToMySQL(cls.mydb).query_db(query,data)

    @classmethod
    def destroy(cls,id):
        query  = "DELETE FROM `users`.`users` WHERE (`id` = %(id)s);"
        return connectToMySQL(cls.mydb).query_db(query,{"id":id})