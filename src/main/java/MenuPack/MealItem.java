package MenuPack;



public class MealItem extends MenuItem {
   public MealItem (String name,String description,double price,int stockQuantity)
   {
       super();
       this.setName(name +" : "+description);
       this.setPrice(price);
       this.stockQuantity=stockQuantity;
   }
}
