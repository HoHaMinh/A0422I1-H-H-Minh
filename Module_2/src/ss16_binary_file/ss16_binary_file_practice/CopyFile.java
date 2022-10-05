package ss16_binary_file.ss16_binary_file_practice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter the source path: ");
        String source = scanner.nextLine();
        System.out.println("Pls enter the destiny path: ");
        String dest = scanner.nextLine();
        File sourceFile = new File(source);
        File destFile = new File(dest);
        try {
            copyFileUsingJava7Files(sourceFile, destFile);
        } catch (IOException e) {
            System.out.println("Cannot copy file");
        }
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
