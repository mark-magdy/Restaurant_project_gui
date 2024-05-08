package restLogic;

import MenuPack.MenuItem;

import java.util.List;

public class Table {
    int state ; // TODO: need ot be updated to enum
    Order order ;

    public Table() {
        order = new Order();
    }

    // methods: addItemInOrder , removeItemInOrder , getBill , ClearTable ,  ShowAlreadyOrderedItems --> return already ordered
    public void addItemInOrder (MenuItem item){
        order.addItem(item);
    }
    public void removeItemInOrder (MenuItem item){
        order.removeItem(item);
    }
    public double getBill (){
        return order.getBill();
    }
    public List<OrderItem> getOrderItemList(){
        return order.getOrderItemList();
    }
}
