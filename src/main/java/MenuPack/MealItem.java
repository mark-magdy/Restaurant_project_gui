package MenuPack;



public class MealItem extends MenuItem {
   public MealItem (String name,String description,double price,int stockQuantity)
   {
       super();
       this.name=name +" : "+description;
       this.price=price;
       this.stockQuantity=stockQuantity;
   }
}
