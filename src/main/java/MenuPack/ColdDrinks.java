package MenuPack;

public class ColdDrinks extends Drinks {
   private boolean iced;

    public ColdDrinks(String name, double price, int quantity) {
        super(name, price, quantity);



    }

    public boolean isIced() {
        return iced;
    }

    public void setIced(boolean iced) {
        this.iced = iced;
    }



}
