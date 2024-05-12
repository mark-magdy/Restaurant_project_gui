package MenuPack;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuSection> sections = new ArrayList<MenuSection>();
    private ArrayList<Meals> meals = new ArrayList<Meals>();

    public Menu() {
        sections.add(new MenuSection("Appetizers"));
        sections.add(new MenuSection("Sandwiches"));
        sections.add(new MenuSection("Pizza"));
        sections.add(new MenuSection("Desserts"));
        sections.add(new MenuSection("Hot drinks"));
        sections.add(new MenuSection("Cold drinks"));
        sections.add(new MenuSection("Meals"));

    }

    public ArrayList<MenuSection> getSections() {
        return sections;
    }

    public ArrayList<Meals> getMeals() {
        return meals;
    }

    public void addItem(String secName, String name, double price, int stockQuantity) {
        for (MenuSection sec : this.sections) {
            if (sec.getName() == secName) {
                switch (secName) {
                    case ("Appetizers"): {
                        Appetizers m = new Appetizers(name, price, stockQuantity);
                        sec.addItem(m);
                        break;
                    }
                    case ("Sandwiches"): {
                        Sandwiches m = new Sandwiches(name, price, stockQuantity);
                        sec.addItem(m);
                        break;
                    }
                    case ("Pizza"): {
                        Pizza m = new Pizza(name, price, stockQuantity);
                        sec.addItem(m);
                        break;
                    }
                    case ("Desserts"): {
                        Desserts m = new Desserts(name, price, stockQuantity);
                        sec.addItem(m);
                        break;
                    }
                    case ("Hot drinks"): {
                        HotDrinks m = new HotDrinks(name, price, stockQuantity);
                        sec.addItem(m);
                        break;
                    }
                    case ("Cold drinks"): {
                        ColdDrinks m = new ColdDrinks(name, price, stockQuantity);
                        sec.addItem(m);
                        break;
                    }
                }


            }
        }
    }

    public void removeItem(String name) {
        for (MenuSection sec : sections) {
            for (int i = 0; i < sec.getSectionSize(); i++) {
                MenuItem m = sec.getItems().get(i);
                if (m.getName().equals(name)) {
                    sec.getItems().remove(m);
                }
            }
        }
    }

    public void updatePrice(String secName, String name, double price) {
        for (MenuSection sec : this.sections) {
            if (sec.getName() == secName) {
                for (MenuItem m : sec.getItems()) {
                    if (name == m.getName()) {
                        m.setPrice(price);
                    }
                }
            }
        }
    }

    public void addMeal(Meals m) {
        String name=m.getName();
        String description=m.getDescription();
        double price=m.getPrice();
        MealItem s=new MealItem(name,description,price,3);
        this.sections.get(6).addItem(s);
    }

    public void removeMeal(Meals m) {
        meals.remove(m);
    }

    public void addMeal(String name) {
        Meals m = new Meals(name);
        this.meals.add(m);
    }

    public void removeSection(String name) {
        for (MenuSection m : this.sections) {
            if (m.getName() == name) {
                sections.remove(m);
            }
        }
    }

    public void removeMeal(int index) {
        this.getSections().get(6).getItems().remove(index-1);

    }

    /*Meals f=new Meals("godzilla");
      f.addFood("fried chicken",50.5,3,2);
      f.addAppetizers("fries",22,3,3);
      f.addDrinks("pepsi",10,3,1);
      f.setDescription();
      m.addMeal(f);
      */


}