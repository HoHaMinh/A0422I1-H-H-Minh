package ss15_text_file.ss15_text_file_exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static String DELIMITER = ",";
    public static String EMPTY = "";

    public static void main(String[] args) {
        System.out.println("Pls input the file path");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        List<String> countriesListFromFile = ReadFile.readFile(path);
        countriesListFromFile.forEach(System.out::println);
    }

    public static List<String> readFile(String path) {
        List<String> countriesList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                if (EMPTY.equals(temp.trim())) {
                    continue;
                }
                String[] results = temp.split(DELIMITER);
                if (results.length != 3) {
                    continue;
                }
                String countries = results[2];
                countriesList.add(countries);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countriesList;
    }
}