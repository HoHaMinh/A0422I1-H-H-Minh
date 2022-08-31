package ss16_binary_file_exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Products> products = new ArrayList<>();
        products.add(new Products(1, "phone", "apple", 1000, "new model"));
        products.add(new Products(2, "tablet", "samsung", 1000, "new model"));
        products.add(new Products(3, "phone", "nokia", 300, "old model"));
        products.add(new Products(4, "phone", "sony", 500, "old model"));
        products.add(new Products(5, "phone", "lg", 600, "old model"));
        writeToFile("products.txt", products);
        List<Products> productDataFromFile = readDataFromFile("products.txt");
        for (Products product : productDataFromFile) {
            System.out.println(product);
        }
        findWord(products);
    }

    public static void writeToFile(String path, List<Products> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Products> readDataFromFile(String path) {
        List<Products> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Products>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static void findWord(List products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter brand products need to be searched: ");
        String searchingWord = scanner.nextLine();
        System.out.println("The searched product is: ");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).toString().contains(searchingWord)) {
                System.out.println(products.get(i));
            }
        }
    }
}
