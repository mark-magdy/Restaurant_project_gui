package MenuPack;

import java.util.Objects;

public abstract  class MenuItem implements Comparable<MenuItem> {
    private String name;
     private double price;
      public int stockQuantity;  // to check if it available or not  ... and for manager to see his stock
     private String comment;

    public MenuItem(String name, double price, int quantity,String comment) {
        this.name = name;
        this.price = price;
        this.stockQuantity = quantity;
        this.comment=comment;
    }
    public MenuItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = quantity;
    }

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
        stockQuantity = 1 ;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int quantity) {
        this.stockQuantity = quantity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(price, menuItem.price) == 0 && stockQuantity == menuItem.stockQuantity && Objects.equals(name, menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, stockQuantity);
    }

    @Override
    public int compareTo(MenuItem o) {
        if(this.price<o.price)return -1;
        if(this.price>o.price)return 1;
        return 0;
    }
}
