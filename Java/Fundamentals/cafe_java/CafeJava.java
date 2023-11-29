public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 1.5;
        double latte = 3;
        double cappuccino = 3;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReahttps://login.codingdojo.com/m/684/15724/115066dyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
        
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if (isReadyOrder1){
            System.out.println(customer1  + readyMessage);
        }
        else {
            System.out.println(customer1  + pendingMessage);
        }

        //Second Challenge

        System.out.println(generalGreeting + customer4); // Displays "Welcome to Cafe Java, Noah"
    	// ** Your customer interaction print statements will go here ** //
        if (isReadyOrder4){
            System.out.println(customer4  + readyMessage);
        }
        else {
            System.out.println(customer4  + pendingMessage);
        }

        // Third Challenge
        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Sam"
        System.out.println("Your total is " + (latte + latte));
        if (isReadyOrder2){
            System.out.println(customer2  + readyMessage);
        }
        else {
            System.out.println(customer2  + pendingMessage);
        }

        // Fourth Challenge
        System.out.println(generalGreeting + customer3); // Display "Welcome to Cafe Java, Jimmy"
        System.out.println("Your total is: " + (latte - dripCoffee));
    }
}
