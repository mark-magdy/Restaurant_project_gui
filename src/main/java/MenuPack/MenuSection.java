package MenuPack;

public abstract class MenuSection {
    String name ;
    MenuItem [] menuItems = new MenuItem[20]; // TODO: use lists instead of Arrays
    int lengthOfMenuItems = 0 ;

    public MenuSection() {}


    public MenuItem[] getMenuItems() {return menuItems;}
    public void addItem (String name ,  double price , int quantity ){
        // TODO: validation of inputs try catch
        // TODO: each item have ID and search with ID in LOG(N)
        for ( int i = 0 ; i < lengthOfMenuItems ; i++ ){
            if (menuItems[i].getName() == name ){
                //TODO: check have same price if true continue if not have same price there is error try ctach
                menuItems[i].setStockQuantity(menuItems[i].getStockQuantity()+quantity);
                return ;
            }
        }
        menuItems[lengthOfMenuItems++] = new MenuItem(name,price,quantity) ; // will be updated if we change array to list
    }
    // TODO: Function to remove Item or Decrease the quantity of Item when someone Order
}
