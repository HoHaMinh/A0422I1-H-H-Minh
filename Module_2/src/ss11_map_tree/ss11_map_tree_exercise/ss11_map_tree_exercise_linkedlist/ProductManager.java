package ss11_map_tree.ss11_map_tree_exercise.ss11_map_tree_exercise_linkedlist;

import ss11_map_tree.ss11_map_tree_exercise.Products;
import ss11_map_tree.ss11_map_tree_exercise.SortByPriceAscending;
import ss11_map_tree.ss11_map_tree_exercise.SortByPriceDescending;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ProductManager {
    private LinkedList<Products> productsManager;

    public ProductManager() {
        productsManager = new LinkedList();
    }

    public void addProduct(int id, String name, double price) {
        Products products = new Products(id, name, price);
        productsManager.add(products);
    }

    public void setProduct(int id, String newname) {
        int size = productsManager.size();
        for (int i = 0; i < size; i++) {
            Products products = productsManager.get(i);
            if (products.getId() == id) {
                products.setName(newname);
            }
        }
    }

    public void deleteProduct(int id) {
        int size = productsManager.size();
        for (int i = 0; i < size; i++) {
            Products products = productsManager.get(i);
            if (products.getId() == id) {
                productsManager.remove(products);
            }
        }
    }

    public void displayList() {
        for (Products products : productsManager) {
            products.displayInfoProducts();
        }
    }

    public void findByNameProduct(String name) {
        for (Products products : productsManager) {
            if (products.getName().equals(name)) {
                products.displayInfoProducts();
            }
        }
    }

    public void sortByPriceAscending() {
        Comparator priceComparator = new SortByPriceAscending();
        Collections.sort(productsManager, priceComparator);
        for (Products products : productsManager) {
            products.displayInfoProducts();
        }
    }

    public void sortByPriceDescending() {
        Comparator priceComparator = new SortByPriceDescending();
        Collections.sort(productsManager, priceComparator);
        for (Products products : productsManager) {
            products.displayInfoProducts();
        }
    }

}
