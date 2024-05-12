package MenuPack;

public class Sandwiches extends Food {

    private String remove;
    private boolean extraSauces;
    private boolean extracheese;
    private String bread;
    private String BeafORchicken;
    public Sandwiches(){}
    public Sandwiches(String name, double price, int quantity) {
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

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getBeafORchicken() {
        return BeafORchicken;
    }

    public void setBeafORchicken(String beafORchicken) {
        BeafORchicken = beafORchicken;
    }
}
