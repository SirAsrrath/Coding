public class Item {

    private String name;
    private double price;
    private int index = 0;
    static int numberOfItems = 0;

    

    public Item(String name, double price ){
    
        this.name = name;
        this.price = price;
        this.index = numberOfItems;
        numberOfItems++;
        
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

    public int getItemIndex(){
        return index;
    }


}


