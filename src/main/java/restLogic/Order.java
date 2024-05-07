package restLogic;

import MenuPack.Menu;
import MenuPack.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Order  {
    private List<OrderItem > orderItemList ;

    public Order() {
        orderItemList = new ArrayList<>();
    }
    public void addItem (MenuItem menuItem, int quantity){
        orderItemList.add(new OrderItem(menuItem,quantity));
    }
    public void addItem (MenuItem menuItem){
        orderItemList.add(new OrderItem(menuItem,1));
    }
    // TODO: removeItem function


    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
    public double getBill (){
        double total =0;
        for(OrderItem i : orderItemList ){
            total +=  i.getPrice() * i.getQuantity();
        }
        return total ;
    }
}