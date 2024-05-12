package MenuPack;

public class Appetizers extends MenuItem {
    private String cusinie ;
    public Appetizers(){}
    public Appetizers(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public String getCusinie() {
        return cusinie;
    }

    public void setCusinie(String cusinie) {
        this.cusinie = cusinie;
    }
}
