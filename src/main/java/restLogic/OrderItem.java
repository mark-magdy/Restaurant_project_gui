package restLogic;

import MenuPack.MenuItem;

public class OrderItem {
    private MenuItem menuItem ;
    private int quantity ;

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
    public void incQuantity (){
        quantity++;
    }
    public void decQuantity (){
        if (quantity>0) quantity--;
    }
    public void incQuantity (int quant){
        quantity+=quant;
    }
    public void decQuantity (int quant){
        if (quantity>quant-1) quantity-=quant;
        else quantity = 0 ;
    }
}