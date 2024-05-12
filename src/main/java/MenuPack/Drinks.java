package MenuPack;

import java.security.PublicKey;

public class Drinks extends MenuItem {
    private String size;
    private int sugerCubes;


    public Drinks (){}
    public Drinks(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSugerCubes() {
        return sugerCubes;
    }

    public void setSugerCubes(int sugerCubes) {
        this.sugerCubes = sugerCubes;
    }
}
