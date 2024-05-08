package restLogic;


import MenuPack.Menu;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String name;
    String address;
    Menu mainMenu;
    private List<Table> tablesList = new ArrayList<>();
    Order takeaway;

    public Restaurant(String name, String address , int noTables) {
        this.name = name;
        this.address = address;
        for (int i = 0; i < noTables; i++) {
            tablesList.add(new Table());
        }


    }

    public List<Table> getTables() {
        return tablesList;
    }

    public Menu getMainMenu() {
        return mainMenu;
    }
}
