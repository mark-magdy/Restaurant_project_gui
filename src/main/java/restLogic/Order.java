package restLogic;

import java.util.ArrayList;
import java.util.List;

public class Order  {
    private List<OrderItem > orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }
    public void addItem (MenuItem menuItem, int quantity){
        for (OrderItem i : orderItemList){
            if ( i.getMenuItem().equals(menuItem)){
                i.incQuantity(quantity);
                return ;
            }
        }
        orderItemList.add(new OrderItem(menuItem,quantity));
    }
    public void addItem (MenuItem menuItem){
        for (OrderItem i : orderItemList){
            if ( i.getMenuItem().equals(menuItem)){
                i.incQuantity();
                return ;
            }
        }
        orderItemList.add(new OrderItem(menuItem,1));
    }
    public void removeItem (MenuItem menuItem){
        for (OrderItem i : orderItemList){
            if ( i.getMenuItem().equals(menuItem)){
                i.decQuantity();
                if (i.getQuantity()==0) {
                    orderItemList.remove(i);
                }
                break ;
            }
        }
    }


    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
    public double getBill (){
        double total =0;
        for(OrderItem i : orderItemList ){
            total +=  i.getPrice() ;
        }
        return (Math.round(total * 1000.0) / 1000.0 )  ;
    }
    public void clearOrder () {
        orderItemList.clear();
    }
}