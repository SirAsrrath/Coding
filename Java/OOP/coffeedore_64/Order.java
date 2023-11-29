import java.util.ArrayList;

public class Order {

    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();
        
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    // Getters & Setters

    public void getItems(){
        for(int i = 0; i< this.items.size(); i++){
            System.out.println(this.items.get(i).getName());
        }
    
    }
    public String getOrderName(){
        return name;
    }

    public void setOrderName(String orName){
        this.name = orName;
    }

    public boolean getOrderStatus(){
        return ready;
    }

    public void setOrderStatus(boolean ready){
        this.ready = ready;
    }

    // Methods

    // add item
    public void addItem(Item item){
        items.add(item);
    }

    // get status message

    public String getStatusMessage(){
        if (this.ready){
            String readyOrder = "Your order is ready";
            return readyOrder;
        }
        else{
            String readyOrder = "Your order is not ready, thank you for your patience";
            return readyOrder;
        }
    }

    // get order total
    public double getOrderTotal(){
        double total = 0;
        for (Item item:items){
            total += item.getItemPrice();
        }
        return total;
    }

    // display method
    public void display(){
        System.out.println("Name: "+this.name);
        for(Item item : items){
            System.out.println(item.getItemName()+" - "+item.getItemPrice());
        }
        System.out.println("Total = "+getOrderTotal());
    }
}
