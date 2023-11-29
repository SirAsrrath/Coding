class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)
        self.account2 = BankAccount(int_rate=0.02, balance=0)
    
    def make_deposit(self, amount, account_num):
        if (account_num == 1):
            self.account.deposit(amount)
            return self
        elif (account_num == 2):
            self.account2.deposit(amount)
            return self
        else:
            print('Account not created')
            return self
        
    def make_withdrawal(self,amount, account_num):
        if (account_num == 1):
            self.account.withdraw(amount)
            return self
        elif (account_num == 2):
            self.account2.withdraw(amount)
            return self
        else:
            print('Account not created')
            return self
            
    def display_user_balance(self):
        if (account_num == 1):
            self.account.display_account_info()
            return self
        elif (account_num == 2):
            self.account2.display_account_info()
            return self
        else:
            return self

    def transfer_money(self, amount, account_num):
        if (account_num == 1):
            self.account2.balance = self.account2.balance + amount
            print('Your new balance is: $' , self.account2.balance)
            return self
        elif (account_num == 2):
            self.account.balance = self.account.balance + amount
            print('Your new balance is: $' , self.account.balance)
            return self
        else:
            print('Account not created')
            return self

class BankAccount:
    
    def __init__(self, int_rate, balance): 
        self.balance = balance
        self.int_rate = int_rate * 0.01
    
    def deposit(self, amount):
        self.balance = self.balance + amount
        return self
    
    def withdraw(self, amount):
        if (amount > self.balance):
            print('Insuficient balance')
            print('Charging $5 fee')
            self.balance = self.balance - 5
            return self
        else:
            self.balance = self.balance - amount
            return self
        
    def display_account_info(self):
        print('Balance: $' + str(self.balance))
        return self
    
jdoe = User('John Doe', 'jdoe@dojo.com')

jdoe.make_deposit(1000,1).make_deposit(100,2).transfer_money(500,1)
