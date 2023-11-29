public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts

        BankAccount bank1 = new BankAccount(300.0 , 500.0);
        BankAccount bank2 = new BankAccount(25.0 , 30.0);
        BankAccount bank3 = new BankAccount(10.0 , 15.0);

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        bank1.deposit(2.0, "checking");
        bank1.deposit(3.0 , "savings");
        BankAccount.getAccounts();

        // Withdrawal Test
        bank1.withdraw(503, "savings");
        bank1.withdraw(2000, "checking");
        bank1.withdraw(301, "checking");

        bank1.getTotalMoney();
        
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        // Static Test (print the number of bank accounts and the totalMoney)
    }
}
