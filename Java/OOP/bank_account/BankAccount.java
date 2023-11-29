public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts = 0;
    private static double totalMoney = 0; // refers to the sum of all bank account checking and savings balances

    
    // CONSTRUCTOR
    // Be sure to increment the number of accounts

    public BankAccount(double checkingBalance, double savingsBalance){
        accounts++;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
    }
    // GETTERS
    // for checking, savings, accounts, and totalMoney

    public static void getAccounts(){
        System.out.println("The number of accounts is: " + accounts);
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public void setCheckingBalance(double cBalance){
        this.checkingBalance = cBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void setSavingsBalance(double sBalance){
        this.savingsBalance = sBalance;
    }




    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account

    public void deposit(double amount , String account){
        if(account.equals ( "savings")){
            this.savingsBalance += amount;
            System.out.println("Transaction succesful");
            System.out.println("The balance on your savings account is: " + this.savingsBalance);
        }
        if(account.equals("checking")){
            this.checkingBalance += amount;
            System.out.println("Transaction succesful");
            System.out.println("The balance on your checking account is: " + this.checkingBalance);
        }
    }

    // // withdraw 
    // // - users should be able to withdraw money from their checking or savings account
    // // - do not allow them to withdraw money if there are insufficient funds
    // // - all deposits and withdrawals should affect totalMoney

    public void withdraw(double amount , String account){
        if(account.equals ( "savings")){
            if(amount> savingsBalance){
                System.out.println("Insufficient funds");
            }
            else{
                this.savingsBalance -= amount;
                System.out.println("Transaction succesful");
                System.out.println("The balance on your savings account is: " + this.savingsBalance);
            }
        }
        if(account.equals("checking")){
            if(amount> checkingBalance){
                System.out.println("Insufficient funds");
            }
            else{
                this.checkingBalance -= amount;
                System.out.println("Transaction succesful");
                System.out.println("The balance on your savings account is: " + this.checkingBalance);
            }
        }
    }

    // // getBalance
    // // - display total balance for checking and savings of a particular bank account

    public void getBalance(String account){
        if (account == "savings"){
            System.out.println("The balance on the savings account is: " + savingsBalance);
        }
        if(account == "checking"){
            System.out.println("The balance on the checking acoount is: " + checkingBalance);
        }
    }

    
    public void getTotalMoney(){
        totalMoney = this.checkingBalance + this.savingsBalance;
        System.out.println("The total money in the account is: " + totalMoney);
    }
}