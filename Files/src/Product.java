public class Product {
    private String name;
    private String description;
    private double price;
    private int num_sold;
    
    public Product(String name, String description, double price, int num_sold) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.num_sold = num_sold;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getNum_sold() {
        return num_sold;
    }
    public void setNum_sold(int num_sold) {
        this.num_sold = num_sold;
    }
    @Override
    public String toString() {
        return name + " " + description + " " + price + " " + num_sold;
    }

}
