import java.util.ArrayList;



public class CoffeeKiosk {

    // Member variables

    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    //Constructor

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    //Methods

    public void addMenuItem(String name, double price ){
        Item newItem = new Item(name , price);
        menu.add(newItem);
    }

    public void displayMenu(){
        System.out.println("Menu");
        for(int i = 0; i< menu.size(); i++){
            
            System.out.println(menu.get(i).getItemIndex() + " " + menu.get(i).getItemName() + " " + menu.get(i).getItemPrice());
        }
    }


    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        System.out.println("Hello, " + name);
    	// Your code:
        // Create a new order with the given input string

        Order newOrder = new Order(name);
        // Show the user the menu, so they can choose items to add.
        
    	// Prompts the user to enter an item number
        displayMenu();
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
                newOrder.addItem(menu.get(Integer.parseInt(itemNumber)));
                System.out.println("Please enter a menu item index or q to quit:");
                itemNumber = System.console().readLine();
                
                
            
            // Get the item object from the menu, and add the item to the order
            
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
        newOrder.display();
    }

}
