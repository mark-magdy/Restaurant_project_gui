package restLogic;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String name;
    String address;
    Menu mainMenu;
    Double availableCash  ;
    private List<Table> tablesList = new ArrayList<>();
    Order takeaway = new Order();
    int stateOfLogin = 0; // 0 -> not valid , 1 -> worker , 2 -> manager



    public Restaurant(String name, String address , int noTables) {
        this.name = name;
        this.address = address;
        for (int i = 0; i < noTables; i++) {tablesList.add(new Table());}
        availableCash =0.0;
    }

    public List<Table> getTables() {
        return tablesList;
    }
    public Menu getMainMenu() {
        return mainMenu;
    }
    public Double getAvailableCash() {return availableCash;}
    public void setAvailableCash(Double availableCash) {
        this.availableCash = availableCash;
    }
    public Order getTakeaway() {return takeaway;}

    public int getStateOfLogin() {return stateOfLogin;}
    public void setStateOfLogin(int stateOfLogin) {this.stateOfLogin = stateOfLogin;}
}
