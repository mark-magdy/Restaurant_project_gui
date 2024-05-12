
package restpack.restaurant_project_gui;
public class TakeAway extends OrderView {
    public TakeAway() {
        firstBtnInit();
        secondBtnInit();
    }

    @Override
    public void firstBtnInit() {
        firstBtn.setText("Cash");
        firstBtn.setOnAction(e -> {
            System.out.println("order are pressed = " + orderToView.getBill());
            ConfirmBox checkOrdering = new ConfirmBox();
            Boolean chck = checkOrdering.display("Reciept Request" , "Are You Sure want to get Receipt and t7asb");
            if (chck){
                asuResto.setAvailableCash(asuResto.getAvailableCash()+ orderToView.getBill());
                orderToView.finishOrder();
                update();
            }
        });
    }
    @Override
    public void secondBtnInit() {
        secondBtn.setText("VISA");
        secondBtn.setOnAction(e -> {
            alert.display("Uner Condtruction" , "It's not working yet");
            System.out.println("receipt are pressed ");

        });
    }

    @Override
    public void setOrderToView() {
//        orderToView = asuResto.getTakeaway();
    }
}