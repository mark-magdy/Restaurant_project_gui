package MenuPack;

import java.util.ArrayList;

public class Menu {
    ArrayList<MenuSection>sections=new ArrayList<MenuSection>();
    ArrayList<Meals>meals=new ArrayList<Meals>();
   Menu()
   {

       sections.add(new MenuSection("Sandwiches")) ;
       sections.add(new MenuSection("Pizza")) ;
       sections.add(new MenuSection("Desserts")) ;
       sections.add(new MenuSection("Hot drinks")) ;
       sections.add(new MenuSection("Cold drinks")) ;

   }

    // TODO: return each section in array (recommended to be List see List) to be viewed
    // TODO: function extend sections
    // TODO: add Items ,  remove Items ,update price
    // TODO: if we run the program it will be empty so we need to initialize it within the code or with seperate files (File Handling is extra)
   /* void addItem(String name , double price){
        drinks.addItem(name,price , 1 );
    }
    void addItem(String name , double price, int quantitiy ){
        drinks.addItem(name,price , quantitiy );
    }*/
}