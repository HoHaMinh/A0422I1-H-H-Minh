package ss11_map_tree.ss11_map_tree_exercise.ss11_map_tree_exercise_arraylist;

public class Test {
    public static void main(String[] args) {
        ProductManager listProduct = new ProductManager();
        listProduct.addProduct(0, "rice", 20000);
        listProduct.addProduct(1, "fish", 10000);
        listProduct.addProduct(2, "beef", 30000);
        listProduct.displayList();
        listProduct.setProduct(1, "vegetable");
        listProduct.deleteProduct(2);
        listProduct.displayList();
        listProduct.addProduct(2, "chicken", 30000);
        listProduct.sortByPriceAscending();
        listProduct.sortByPriceDescending();
    }
}
