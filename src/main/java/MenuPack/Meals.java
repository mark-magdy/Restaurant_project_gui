package MenuPack;

import java.util.ArrayList;

public class Meals extends MenuSection{
    String description;
    ArrayList<Integer>quatities=new ArrayList<Integer>();
    public void addFood(Food f,int quantity)
    {
        addItem(f);
        quatities.add(quantity);
    }
    public void removeFood(Food f)
    {
        int i= getMenuItems().indexOf(f);
       if(removeItem(f))
       {
           quatities.remove(i);
       }
    }
    public void addDrinks(Drinks f,int quantity)
    {
        addItem(f);
        quatities.add(quantity);
    }
    public void removeDrinks(Drinks f)
    {
        int i= getMenuItems().indexOf(f);
        if(removeItem(f))
        {
            quatities.remove(i);

        }

    }
    public void addAppetizers(Appetizers f,int quantity)
    {
        addItem(f);
        quatities.add(quantity);
    }
    public void removeAppetizers(Appetizers f)
    {
        int i= getMenuItems().indexOf(f);
        if(removeItem(f))
        {
            quatities.remove(i);
        }
    }
    public void setDescription()
    {
     String appetizer=null,food=null,drink=null;
     for(int i=0;i<getSectionSize();i++)
         if(items.get(i)instanceof Food)food= food+(items.get(i).getName())+" "+quatities.get(i).toString()+" ";
        else if(items.get(i)instanceof Appetizers)appetizer= appetizer+(items.get(i).getName())+" "+quatities.get(i).toString()+" ";
         else if(items.get(i)instanceof Drinks)drink= drink+(items.get(i).getName())+" "+quatities.get(i).toString()+" ";
description=appetizer+food+drink;
    }

}
