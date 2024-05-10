package MenuPack;

import java.util.ArrayList;

public class Meals extends MenuSection {
   private String name;
   private String description;
 public Meals(String name)
 {
     this.name=name;
 }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }



    public ArrayList<Integer> getQuatities() {
        return quatities;
    }

    public void setQuatities(ArrayList<Integer> quatities) {
        this.quatities = quatities;
    }

    ArrayList<Integer>quatities=new ArrayList<Integer>();
    public void addFood(String name, double price, int stockQuantity,int quantity)
    {
        Food f=new Food(name,price,stockQuantity);
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
    public void addDrinks(String name, double price, int stockQuantity,int quantity)
    {
        Drinks f=new Drinks(name,price,stockQuantity);
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
    public void addAppetizers(String name, double price, int stockQuantity,int quantity)
    {
        Appetizers f= new Appetizers(name,price,stockQuantity);
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
     String appetizer="",food="",drink="";
     for(int i=0;i<getSectionSize();i++)
         if(getItems().get(i)instanceof Food)food= food+(getItems().get(i).getName())+" "+quatities.get(i).toString()+", ";
        else if(getItems().get(i)instanceof Appetizers)appetizer= appetizer+(getItems().get(i).getName())+" "+quatities.get(i).toString()+", ";
         else if(getItems().get(i)instanceof Drinks)drink= drink+(getItems().get(i).getName())+" "+quatities.get(i).toString()+", ";
description=appetizer+food+drink;
    }
    public double getPrice()
    {
        double total=0;
        for(int i=0;i<getSectionSize();i++)
        {
            total+=quatities.get(i)*getItems().get(i).getPrice();
        }
        return total;
    }


}
