package ss1_introduction_practice;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        String day;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the month you want to know days: ");
        int month = Integer.parseInt(scanner.nextLine());
        switch (month) {
            case 2:
                day = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = "30";
                break;
            default:
                day = "";
        }
        if (!day.equals("")) {
            System.out.printf("The month %d has %s days", month, day);
        } else System.out.println("Invalid input");
    }
}
