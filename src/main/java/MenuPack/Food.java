package MenuPack;

public class Food extends MenuItem {
private String Size ;
private String course;


    public Food(){}
    public Food(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
