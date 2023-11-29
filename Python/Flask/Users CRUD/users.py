from config.mysqlconnection import connectToMySQL

mydb = 'users'

class Post: 
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
        results = connectToMySQL(mydb).query_db(query)
        print(results)
        output = []
        for i in results:
            output.append(cls(i))
        return output
    
    @classmethod
    def save(cls, data):
        query = "INSERT INTO users (first_name, last_name, email) VALUES (%(first_name)s , %(last_name)s , %(email)s, NOW(), NOW());"
        return connectToMySQL(mydb).query_db(query,data)