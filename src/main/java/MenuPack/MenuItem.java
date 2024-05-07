package MenuPack;

public class MenuItem {
    private String name;
    private double price;
    private int quantity;  // to check if it available or not  ... and for manager to see his stock

    public MenuItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
        quantity = 1 ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
