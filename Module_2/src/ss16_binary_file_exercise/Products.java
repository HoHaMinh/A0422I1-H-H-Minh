package ss16_binary_file_exercise;

import java.io.Serializable;

public class Products implements Serializable {
    private int idProduct;
    private String nameProduct;
    private String brand;
    private double price;
    private String description;

    public Products() {
    }

    public Products(int idProduct, String nameProduct, String brand, double price, String description) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + idProduct +
                ", name='" + nameProduct + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
