public class Item {

    private String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public String getItemName(){
        return name;
    }

    public void setItemName(String itName){
        this.name = itName;
    }

    public double getItemPrice(){
        return price;
    }

    public void setItemPrice(double price){
        this.price = price;
    }
}


