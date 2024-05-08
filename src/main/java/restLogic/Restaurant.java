package restLogic;


import MenuPack.Menu;

public class Restaurant {
    String name ;
    String address ;
    Menu mainMenu ;
    Table [] tables = new Table[9];
    Order takeaway ;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Table[] getTables() {
        return tables;
    }

    public Menu getMainMenu() {
        return mainMenu;
    }
}
