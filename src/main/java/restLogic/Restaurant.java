package restLogic;


import MenuPack.Meals;
import MenuPack.Menu;
import MenuPack.MenuSection;
import MenuPack.Sandwiches;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String name;
    String address;
    Menu mainMenu;
    Double availableCash;
    private List<Table> tablesList = new ArrayList<>();
    Order takeaway = new Order();
    int stateOfLogin = 0; // 0 -> not valid , 1 -> worker , 2 -> manager


    public Restaurant(String name, String address, int noTables) {
        this.name = name;
        this.address = address;
        for (int i = 0; i < noTables; i++) {
            tablesList.add(new Table());
        }
        availableCash = 0.0;
        mainMenu = new Menu();
        //Menu m=new Menu();
        //Sandwiches hamburger=new Sandwiches("hamburger",50,2);
        mainMenu.addItem("Sandwiches", "hamburger", 50, 2);
        mainMenu.addItem("Sandwiches", "buffalo", 100, 2);
        mainMenu.addItem("Sandwiches", "bunnbun", 70, 2);
        mainMenu.addItem("Sandwiches", "buchhas", 70, 2);
        mainMenu.addItem("Pizza", "margrita", 200, 4);
        mainMenu.addItem("Cold drinks", "pepsi", 10, 2);
        mainMenu.addItem("Desserts", "pepsi", 10, 2);
        mainMenu.removeItem("bunnbun");
        Meals f=new Meals("godzilla");
        f.addFood("fried chicken",50,3,2);
        f.addAppetizers("fries",20,3,1);
        f.addAppetizers("colsolo",5,3,4);
        f.addDrinks("pepsi",10,3,3);
        f.setDescription();
        f.setPrice();
        f.offer(10);
        mainMenu.addMeal(f);
       // mainMenu.removeMeal(1);
    }

    public List<Table> getTables() {
        return tablesList;
    }

    public Menu getMainMenu() {
        return mainMenu;
    }

    public Double getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(Double availableCash) {
        this.availableCash = availableCash;
    }

    public Order getTakeaway() {
        return takeaway;
    }

    public int getStateOfLogin() {
        return stateOfLogin;
    }

    public void setStateOfLogin(int stateOfLogin) {
        this.stateOfLogin = stateOfLogin;
    }
}
