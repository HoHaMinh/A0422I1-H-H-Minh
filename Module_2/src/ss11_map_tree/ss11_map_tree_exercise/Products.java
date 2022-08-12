package ss11_map_tree.ss11_map_tree_exercise;

public class Products {
    private int id;
    private String name;
    private double price;

    public Products () {};

    public Products(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Products(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfoProducts() {
        System.out.printf("Product with id %d has name: %s and price: %.1f\n", id, name,price);
    }

}
