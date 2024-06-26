package restLogic;

import MenuPack.*;

public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public String getName() {
        return menuItem.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return (Math.round((menuItem.getPrice() * quantity) * 1000.0) / 1000.0);
    }

    public void incQuantity() {
        quantity++;
    }

    public void decQuantity() {
        if (quantity > 0) quantity--;
    }

    public void incQuantity(int quant) {
        quantity += quant;
    }

    public void decQuantity(int quant) {
        if (quantity > quant - 1) quantity -= quant;
        else quantity = 0;
    }
}