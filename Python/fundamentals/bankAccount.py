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
    def yield_interest(self):
        if (self.balance > 0):
            self.balance = self.balance + (self.balance * self.int_rate)
            return self
        else:
            return self
acc1 = BankAccount(5,300)

acc1.deposit(100).deposit(500).deposit(100).withdraw(1000).yield_interest().display_account_info()

acc2 = BankAccount(3, 100)

acc2.deposit(100).deposit(300).withdraw(250).withdraw(500).withdraw(300).withdraw(1000).yield_interest().display_account_info()

