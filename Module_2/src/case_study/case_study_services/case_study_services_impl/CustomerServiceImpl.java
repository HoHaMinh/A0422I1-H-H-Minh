package case_study.case_study_services.case_study_services_impl;

import case_study.case_study_exception.UserException;
import case_study.case_study_models.Customer;
import case_study.case_study_services.CustomerService;
import case_study.case_study_validate.Validator;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static List<Customer> customersList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Customer customer : customersList
        ) {
            System.out.println(customer.toString());
        }
    }

    public Customer inputInformation() {
        System.out.println("Pls enter id: ");
        int id = Integer.parseInt(scanner.nextLine());

        String name = null;
        do {
            System.out.println("Pls enter name: ");
            name = scanner.nextLine();
            try {
                Validator.validateName(name);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        Date dateOfBirth;
        do {
            System.out.println("Pls enter date of birth: ");
            String dateAsString = scanner.nextLine();
            try {
                dateOfBirth = Validator.validateBirthday(dateAsString);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String gender = null;
        do {
            System.out.println("Pls enter gender: ");
            gender = scanner.nextLine();
            try {
                Validator.validateGender(gender);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Pls enter national id: ");
        int nationalId = Integer.parseInt(scanner.nextLine());
        System.out.println("Pls enter tel: ");
        int tel = Integer.parseInt(scanner.nextLine());
        System.out.println("Pls enter email: ");
        String email = scanner.nextLine();
        System.out.println("Pls enter type of customer: ");
        String typeOfCustomer = scanner.nextLine();
        System.out.println("Pls enter address: ");
        String address = scanner.nextLine();
        Customer customerInput = new Customer(id, name, dateOfBirth, gender, nationalId, tel, email, typeOfCustomer, address);
        return customerInput;
    }

    @Override
    public void addNew() {
        Customer customer = inputInformation();
        customersList.add(customer);
        System.out.println("Add success!");
    }

    @Override
    public void edit() {
        boolean idChecking = true;
        do {
            System.out.println("Pls enter id of customer which need to be edited: ");
            int idInput = Integer.parseInt(scanner.nextLine());
            int length = customersList.size();
            for (int i = 0; i < length; i++) {
                if (customersList.get(i).getId() == idInput) {
                    System.out.println("Pls input all information of customer with id " + idInput);
                    customersList.set(i, inputInformation());
                    idChecking = false;
                    break;
                } else if (i == length - 1) {
                    System.out.println("Do not find any customer with id " + idInput);
                }
            }
        } while (idChecking);
    }
}
