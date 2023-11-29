class User:
    def __init__(self,fname, lname, mail, agenum, is_rewards_member = False, gold_card_points = 0):
        self.first_name = fname
        self.last_name = lname
        self.email = mail
        self.age = agenum
        self.is_rewards_member = is_rewards_member
        self.gold_card_points = gold_card_points

    def display_info(self):
        print(f"First Name: {self.first_name} \n Last Name: {self.last_name} \n Email: {self.email} \n Age: {self.age}")
        return self
    
    def enroll(self):
        if (self.is_rewards_member == True):
            print('User is already a member')
            return self
        else:
            self.is_rewards_member = True
            self.gold_card_points = 200
            return self
    
    def spend_points(self,amount):
        if (amount>self.gold_card_points):
            print("You don't have enough points for this transaction")
        else:
            self.gold_card_points = self.gold_card_points - amount
            return self

user1 = User('John','Doe','jDoe@dojo.com',35)
user1.display_info()



user2 = User('Jane', 'Doe', 'Jane@dojo.com', 21, True, 900)
user2.enroll()
user2.spend_points(0)
user3 = User('Gabriel', 'Solarte', 'gsolarte@dojo.com', 27, True)
