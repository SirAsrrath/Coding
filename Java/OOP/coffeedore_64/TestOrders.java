import java.util.ArrayList;


public class TestOrders {
    public static void main(String[] args) {
    


        CoffeeKiosk menu = new CoffeeKiosk();

        menu.addMenuItem("Mocha", 3.50);
        menu.addMenuItem("Mocha" , 3.5);
        menu.addMenuItem("Drip Coffee" , 3.5);
        menu.addMenuItem("Latte", 3.01);
        menu.addMenuItem("Cappuccino" , 3.0);
        // menu.displayMenu();

        menu.newOrder();


//         // Order variables -- order1, order2 etc.
//         //Empty Order
//         Order order1 = new Order();
//         Order order2 = new Order();

//         //Custom Orders
//         Order order3 = new Order("Order 3 Test");
//         Order order4 = new Order("Order 4 Test");
//         Order order5 = new Order("Order 5 Test");
        

//         //Tasks
//         //Add at least 2 items to each of the orders using the addItem method.
//         order1.addItem(item1);
//         order1.addItem(item2);

//         order2.addItem(item1);
//         order2.addItem(item2);

//         order3.addItem(item1);
//         order3.addItem(item2);

//         order4.addItem(item1);
//         order4.addItem(item2);

//         order5.addItem(item1);
//         order5.addItem(item2);


//         //Test your getStatusMessage method by setting some orders to ready and printing the messages for each order.
//         order1.setOrderStatus(true);
//         order1.getStatusMessage();
//         System.out.println(order1.getStatusMessage());
//         order2.getStatusMessage();
//         System.out.println(order2.getStatusMessage());

//         //Test the total by printing the return value
        
//         System.out.println(order1.getOrderTotal());

//         // call the display on all orders

//         order1.display();
//         order2.display();
//         order3.display();
//         order4.display();
//         order5.display();
        
    }
}
