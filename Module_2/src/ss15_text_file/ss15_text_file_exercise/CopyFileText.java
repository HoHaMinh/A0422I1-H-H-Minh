package ss15_text_file.ss15_text_file_exercise;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static String EMPTY = "";

    public static void main(String[] args) {
        System.out.println("Pls enter path of file which you want to copy: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        copyFile(path);
    }

    public static void copyFile(String path) {
        int count = 0;
        File outputFile = new File("Result.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
                if (outputFile.exists()) {
                    System.out.println("Output file was exist");
                }
                String text;
                while ((text = bufferedReader.readLine()) != null) {
                    if (EMPTY.equals(text.trim())) {
                        continue;
                    }
                    System.out.println(text);
                    count += text.length();
                    bufferedWriter.write(text);
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("Count of character is: " + count);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}