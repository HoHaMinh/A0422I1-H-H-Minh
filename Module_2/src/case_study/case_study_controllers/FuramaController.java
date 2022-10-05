package case_study.case_study_controllers;

import case_study.case_study_services.case_study_services_impl.*;

import java.util.Scanner;

public class FuramaController {
    public static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    public static CustomerServiceImpl customerService = new CustomerServiceImpl();
    public static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    public static BookingServiceImpl bookingService = new BookingServiceImpl();
    public static ContactServiceImpl contactService = new ContactServiceImpl();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu of drawing");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6.  Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    displayMenu1();
                    break;
                case 2:
                    displayMenu2();
                    break;
                case 3:
                    displayMenu3();
                    break;
                case 4:
                    displayMenu4();
                    break;
                case 5:
                    displayMenu5();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong input. Input must be 1-6. Please choose again!");
                    System.out.println("\n");
            }
        }
    }

    public static void displayMenu1() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit new employee");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    choice = 0;
                    break;
                default:
                    System.out.println("Wrong input. Input must be 1-4. Please choose again! \n");
            }
        }
    }

    public static void displayMenu2() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("1. Display list customer");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit new customer");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.addNew();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    choice = 0;
                    break;
                default:
                    System.out.println("Wrong input. Input must be 1-4. Please choose again!\n");
            }
        }
    }

    public static void displayMenu3() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    facilityService.addNew();
                    break;
                case 3:
                    facilityService.displayMaintenant();
                    break;
                case 4:
                    choice = 0;
                    break;
                default:
                    System.out.println("Wrong input. Input must be 1-4. Please choose again!\n");
            }
        }
    }

    public static void displayMenu4() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    bookingService.addBooking();
                    break;
                case 2:
                    bookingService.display();
                    break;
                case 3:
                    contactService.createNewContract();
                    break;
                case 4:
                    contactService.display();
                    break;
                case 5:
                    contactService.editContract();
                    break;
                case 6:
                    choice = 0;
                    break;
                default:
                    System.out.println("Wrong input. Input must be 1-6. Please choose again!\n");
            }
        }
    }

    public static void displayMenu5() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                default:
                    System.out.println("Wrong input. Input must be 1-3. Please choose again!");
                    System.out.println("\n");
            }
        }
    }
}
