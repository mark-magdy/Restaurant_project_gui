package MenuPack;

import java.util.ArrayList;

public class Menu {
   private ArrayList<MenuSection>sections=new ArrayList<MenuSection>();
   private ArrayList<Meals>meals=new ArrayList<Meals>();
   public Menu() {
       sections.add(new MenuSection("Appetizers")) ;
       sections.add(new MenuSection("Sandwiches")) ;
       sections.add(new MenuSection("Pizza")) ;
       sections.add(new MenuSection("Desserts")) ;
       sections.add(new MenuSection("Hot drinks")) ;
       sections.add(new MenuSection("Cold drinks")) ;

   }

    public ArrayList<MenuSection> getSections() {
        return sections;
    }



    public ArrayList<Meals> getMeals() {
        return meals;
    }



    // TODO: return each section in array (recommended to be List see List) to be viewed
    // TODO: function extend sections
    // TODO: add Items ,  remove Items ,update price
    // TODO: if we run the program it will be empty so we need to initialize it within the code or with seperate files (File Handling is extra)
   void addItem(String secName,String name , double price,int stockQuantity){
        for (MenuSection sec:this.sections)
        {
            if(sec.getName()==secName)
            {
                MenuItem m=new MenuItem(name,price,stockQuantity);
                sec.addItem(m);
            }
        }
    }
    void updatePrice(String secName,String name , double price){
        for (MenuSection sec:this.sections)
        {
            if(sec.getName()==secName)
            {
                for(MenuItem m:sec.getItems())
                {
                    if(name==m.getName())
                    {
                        m.setPrice(price);
                    }
                }
            }
        }
    }
    void addSection(String name )
    {
        MenuSection m=new MenuSection(name);
        this.sections.add(m);
    }
    void addMeal(Meals m)
    {
        meals.add(m);
    }
    void removeMeal(Meals m)
    {
        meals.remove(m);
    }
    void addMeal(String name)
    {
        Meals m=new Meals(name);
        this.meals.add(m);
    }
    void removeSection(String name)
    {
        for(MenuSection m:this.sections)
        {
            if(m.getName()==name)
            {
                sections.remove(m);
            }
        }
    }
    void removeMeal(String name)
    {
        for(Meals m:this.meals)
        {
            if(m.getName()==name)
            {
                meals.remove(m);
            }
        }
    }
/*
    public static void main(String [] args)
    {
      Menu m=new Menu();
     Sandwiches hamburger=new Sandwiches("hamburger",50,2);
      for(MenuSection sec:m.getSections())
      {
          if(sec.getName()=="Sandwiches")
          {
              sec.addItem(hamburger);
          }
      }
        System.out.println(m.getSections().get(0).getMenuItems().get(0).getName());

      Meals f=new Meals("godzilla");
      f.addFood("fried chicken",50.5,3,2);
      f.addAppetizers("fries",22,3,3);
      f.addDrinks("pepsi",10,3,1);
      f.setDescription();
      m.addMeal(f);
        System.out.println(f.getName());
        System.out.println(f.getDescription());
        System.out.println("price is "+f.getPrice());


    }*/
}