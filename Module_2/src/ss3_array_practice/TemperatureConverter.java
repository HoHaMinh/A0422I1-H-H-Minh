package ss3_array_practice;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        double fahrenheit;
        double celcius;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1.Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0.  Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Please enter the Fahrenheit: ");
                    fahrenheit = input.nextDouble();
                    input.nextLine();
                    System.out.println("Celcius is: " + fahrenheitToCelcius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Please enter the Celcius: ");
                    celcius = input.nextDouble();
                    input.nextLine();
                    System.out.println("Fahrenheit is: " + celsiusToFahrenheit(celcius));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please choose again!");
                    System.out.println("\n");
            }
        }
    }

    public static double celsiusToFahrenheit(double number) {
        return number / 5 * 9 + 32;
    }

    public static double fahrenheitToCelcius(double number) {
        return (5.0 / 9) * (number - 32);
    }
}