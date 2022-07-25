package ss2_loop_exercise;

import java.util.Scanner;

public class MenuOfDrawing {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu of drawing");
            System.out.println("1.Draw the rectangle");
            System.out.println("2 Draw the square triangle has square at top-left");
            System.out.println("3 Draw the square triangle has square at top-right");
            System.out.println("4 Draw the square triangle has square at bottom-left");
            System.out.println("5 Draw the square triangle has square at bottom-right");
            System.out.println("6.Draw the isosceles triangle");
            System.out.println("0.  Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Draw the square triangle has square at top-left");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= (6 - i); j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Draw the square triangle has square at top-right");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5; j++) {
                            if (j <= (i - 1)) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.out.println("Draw the square triangle has square at bottom-left");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 5:
                    System.out.println("Draw the square triangle has square at bottom-right");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5; j++) {
                            if (j <= (5 - i)) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 6:
                    System.out.println("Draw the isosceles triangle");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i + 4; j++) {
                            if (j < (6 - i)) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please choose again!");
                    System.out.println("\n");
            }
        }
    }
}
