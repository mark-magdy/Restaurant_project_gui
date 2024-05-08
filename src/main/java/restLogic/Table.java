package restLogic;

import MenuPack.MenuItem;

import java.util.List;

public class Table {
    private Table.State state;

    //    int state ; // TODO: need ot be updated to enum
    public enum State {
        EMPTY,
        HAVE_ORDER,
        RESERVED
    }
    Order order ;

    public Table() {
        State state = State.EMPTY;
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
    public State getState() {
        if (getBill() >0){
            state = State.HAVE_ORDER;
        }else if (getBill() == 0 ) {
            state = State.EMPTY;
        }
        return this.state;
    }
    public void clearTable () {
        state = State.EMPTY;
        order = new Order();
    }
}
