package restLogic;

import MenuPack.MenuItem;

public class OrderItem {
    MenuItem menuItem ;
    int quantity ;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return menuItem.getPrice();
    }
}