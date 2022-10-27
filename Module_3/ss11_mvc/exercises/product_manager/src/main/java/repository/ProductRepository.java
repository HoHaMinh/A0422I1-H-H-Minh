package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "S22 Ultra", 1050, "smartphone", "samsung"));
        productList.add(new Product(2, "Z Flip 4", 850, "smartphone", "samsung"));
        productList.add(new Product(3, "Z Fold 4", 1500, "smartphone", "samsung"));
        productList.add(new Product(4, "14 Promax", 999, "smartphone", "iphone"));
        productList.add(new Product(5, "14", 799, "smartphone", "iphone"));
    }

    @Override
    public List<Product> displayAll() {
        return productList;
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean edit(Product product) {
        boolean result = false;
        for (Product p : productList
        ) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacture(product.getManufacture());
                result = true;
            }
        } return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        for (Product p : productList
        ) {
            if (p.getId() == id) {
                result = true;
            }
        }
        productList.remove(findById(id));
        return result;
    }

    @Override
    public Product displayOneProduct() {
        return new Product();
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productsToFind = new ArrayList<>();
        for (Product p : productList
        ) {
            if (p.getName().contains(name)) {
                productsToFind.add(p);
            }
        }
        return productsToFind;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList
        ) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

}
