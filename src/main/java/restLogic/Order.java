package restLogic;

import java.util.ArrayList;
import java.util.List;

import MenuPack.*;

public class Order {
    private List<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public void addItem(MenuItem menuItem, int quantity) {
        for (OrderItem i : orderItemList) {
            if (i.getMenuItem().equals(menuItem)) {
                i.incQuantity(quantity);
                return;
            }
        }
        orderItemList.add(new OrderItem(menuItem, quantity));
    }

    public void addItem(MenuItem menuItem) {
        for (OrderItem i : orderItemList) {
            if (i.getMenuItem().equals(menuItem)) {
                if (menuItem.getStockQuantity() > i.getQuantity()) {
                    i.incQuantity();
                    return;
                } else {
                    System.out.println("Stock Quantity are not suffucient\n");
                    return;
                }
            }
        }
        if (menuItem.getStockQuantity() >= 1) {
            orderItemList.add(new OrderItem(menuItem, 1));
        }
    }

    public void removeItem(MenuItem menuItem) {
        for (OrderItem i : orderItemList) {
            if (i.getMenuItem().equals(menuItem)) {
                i.decQuantity();
                if (i.getQuantity() == 0) {
                    orderItemList.remove(i);
                }
                break;
            }
        }
    }


    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public double getBill() {
        double total = 0;
        for (OrderItem i : orderItemList) {
            total += i.getPrice();
        }
        return (Math.round(total * 1000.0) / 1000.0);
    }

    public void finishOrder() {
        for (OrderItem i : orderItemList) {
            i.getMenuItem().setStockQuantity(i.getMenuItem().getStockQuantity() - i.getQuantity());
        }
        for (OrderItem i : orderItemList) {
            System.out.println(i.getMenuItem().getName() + " + " + i.getMenuItem().getStockQuantity());
        }
        orderItemList.clear();
    }
}