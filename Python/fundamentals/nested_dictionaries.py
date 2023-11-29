x = [ [5,2,3], [10,8,9] ] 
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

# # 1

x [1][0] = 15
print (x)

# # 2

students[0]['last_name'] = 'Bryant'

print(students[0])

# # 3

sports_directory['soccer'][0] = 'Andres'
print(sports_directory['soccer'])

# # 4 

z[0]['y'] = 30
print(z)

#####################################################################################

# Iterate through a list of dictionaries

students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iterateDictionary():
    for i in range (len(students)):
        print('first_name - ' + students[i]['first_name'] + ', last_name - ' + students[i]['last_name'])
iterateDictionary()

# # Get Values From a List of Dictionaries

def iterateDictionary2(x, y):
    for i in range (len(y)):
        print(y[i][x])

iterateDictionary2('last_name',students)

# Iterate Through a Dictionary with List Values

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(x):
    print(str(len(x['locations'])) + ' Locations')
    for i in range (len(x['locations'])):
        print(x['locations'][i])
    print(str(len(x['instructors'])) + ' Instructors')
    for i in range (len(x['instructors'])):
        print(x['instructors'][i])

printInfo(dojo)