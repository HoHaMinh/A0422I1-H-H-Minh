package product_manager.repository;

import org.springframework.stereotype.Repository;
import product_manager.bean.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone 12", 500));
        productList.add(new Product(2, "iphone 13", 700));
        productList.add(new Product(3, "iphone 14", 1000));
        productList.add(new Product(4, "samsung z fold", 1200));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean update(Product product) {
        productList.set((product.getProductId()-1),product);
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        return productList.remove(productList.get(id));
    }

    @Override
    public Product findById(Integer id) {
        return productList.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listSearching = new ArrayList<>();
        for (Product p: productList
             ) {
            if (p.getProductName().contains(name)) {
                listSearching.add(p);
            }
        }
        return listSearching;
    }
}
