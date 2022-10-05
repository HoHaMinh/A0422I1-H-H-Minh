package case_study.case_study_services.case_study_services_impl;

import case_study.case_study_exception.UserException;
import case_study.case_study_models.Employee;
import case_study.case_study_services.CustomerService;
import case_study.case_study_validate.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements CustomerService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee employee : employeeList
        ) {
            System.out.println(employee.toString());
        }
    }

    public Employee inputInformation() {
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
        System.out.println("Pls enter education: ");
        String education = scanner.nextLine();
        System.out.println("Pls enter position: ");
        String position = scanner.nextLine();
        System.out.println("Pls enter salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        Employee employeeInput = new Employee(id, name, dateOfBirth, gender, nationalId, tel, email, education, position, salary);
        return employeeInput;
    }

    @Override
    public void addNew() {
        Employee employee = inputInformation();
        employeeList.add(employee);
        System.out.println("Add success!");
    }


    @Override
    public void edit() {
        boolean idChecking = true;
        do {
            System.out.println("Pls enter id of employee which need to be edited: ");
            int idInput = Integer.parseInt(scanner.nextLine());
            int length = employeeList.size();
            for (int i = 0; i < length; i++) {
                if (employeeList.get(i).getId() == idInput) {
                    System.out.println("Pls input all information of employee with id " + idInput);
                    employeeList.set(i, inputInformation());
                    idChecking = false;
                    break;
                } else if (i == length - 1) {
                    System.out.println("Do not find any employee with id " + idInput);
                }
            }
        } while (idChecking);
    }
}
