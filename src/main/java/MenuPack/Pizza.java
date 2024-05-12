package MenuPack;

public class Pizza extends Food{
    private String remove;
    private boolean extraSauces;
    private boolean extracheese;
    private String type;


    public Pizza(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public boolean isExtraSauces() {
        return extraSauces;
    }

    public void setExtraSauces(boolean extraSauces) {
        this.extraSauces = extraSauces;
    }

    public boolean isExtracheese() {
        return extracheese;
    }

    public void setExtracheese(boolean extracheese) {
        this.extracheese = extracheese;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
