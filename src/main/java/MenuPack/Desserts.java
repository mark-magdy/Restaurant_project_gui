package MenuPack;

public class Desserts extends MenuItem {
private String extraSauces;
    public Desserts(){}
    public Desserts(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public String getExtraSauces() {
        return extraSauces;
    }

    public void setExtraSauces(String extraSauces) {
        this.extraSauces = extraSauces;
    }
}
