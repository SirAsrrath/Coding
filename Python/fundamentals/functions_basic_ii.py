# Countdown
x=0
cdown = []
def countdown(x):
    for i in range(int(x), -1, -1):
        cdown.append(i)
countdown(7)
print(cdown)

# Print and Return
x=0
y=0
def print_and_return(x,y):
    print(x)
    print(y)
    return y
    
print_and_return(1,4)


# First Plus Length

result = 0
def fpl():
    list = [1,2,3,4,5]
    result = len(list) + list[0]
    print(result)
fpl()

# Values Greater than Second
count = 0
list = []
def values ():
    original_list = [5,2,3,2,1,4]
    for i in range (0,len(original_list)):
        if original_list[i]>original_list[1]:
            list.append(original_list[i])
            global count 
            count = count + 1         
values()
if count < 2:
    print('False')
else:
    print(list)
    print(count)

# This Length, That Value
x=0
y=0
list=[]
def length_and_value(x,y):
    for i in range (x):
        list.append(y)
    return list
length_and_value(6,2)
print(list)
