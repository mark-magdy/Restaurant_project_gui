package MenuPack;

import java.util.ArrayList;
import java.util.Collections;

public  class MenuSection {
     private String name ;
   private ArrayList<MenuItem> items=new ArrayList<MenuItem>();
   // MenuItem [] menuItems = new MenuItem[20]; // TODO: use lists instead of Arrays
    //int lengthOfMenuItems = 0 ;

    public MenuSection() {}

    public MenuSection(String name) {
        this.name = name;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  ArrayList<MenuItem> getMenuItems() {return this.items;}

   public void addItem(MenuItem item) {
       items.add(item);
       Collections.sort(items,MenuItem::compareTo);
   }
   public boolean removeItem(MenuItem item) {
       return items.remove(item);
   }
   public int getSectionSize()
   {
       return this.items.size();
   }
}
