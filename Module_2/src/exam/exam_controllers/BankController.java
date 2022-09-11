package exam.exam_controllers;

import java.util.Scanner;

public class BankController {
    public static Services noteService = new Services();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("PROGRAM CONTROL NOTE OF INVESTEMENT");
            System.out.println("1. Add new note of investement");
            System.out.println("2. Delete note of investement");
            System.out.println("3. Display note of investement");
            System.out.println("4.  Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    noteService.addNew();
                    break;
                case 2:
                    noteService.deleteNote();
                    break;
                case 3:
                    noteService.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input. Input must be 1-4. Please choose again!\n");
            }
        }
    }
}
