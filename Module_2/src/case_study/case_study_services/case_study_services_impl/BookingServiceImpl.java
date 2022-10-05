package case_study.case_study_services.case_study_services_impl;

import case_study.case_study_controllers.Booking;
import case_study.case_study_controllers.Facility;
import case_study.case_study_controllers.Villa;
import case_study.case_study_exception.UserException;
import case_study.case_study_models.Customer;
import case_study.case_study_services.BookingService;
import case_study.case_study_utils.BookingComparator;
import case_study.case_study_validate.Validator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static TreeSet<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    private static Scanner scanner = new Scanner(System.in);

    public static Customer chooseCustomer() {
        System.out.println("List of customers: ");
        for (Customer customer : CustomerServiceImpl.customersList
        ) {
            System.out.println(customer.toString());
        }
        System.out.println("Input id customer: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());
        while (check) {
            for (Customer customer : CustomerServiceImpl.customersList
            ) {
                if (id == customer.getId()) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Id customer input is wrong, pls input again: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("List of facilities: ");
        for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facility.entrySet()
        ) {
            System.out.println(entry.getKey().toString());
        }
        System.out.println("Input name of service: ");
        boolean check = true;
        String name = scanner.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facility.entrySet()
            ) {
                if (entry.getKey().getNameOfService().equals(name)) {
                    check = false;
                    return entry.getKey();
                }
            }
            if (check) {
                System.out.println("Name of service input is wrong, pls input again: ");
                name = scanner.nextLine();
            }
        }
        return null;
    }

    static {
        CustomerServiceImpl.customersList.add(new Customer(1, "Nam", new Date(8 / 8 / 1993), "male", 1,
                1, "m", "m", "m"));
        CustomerServiceImpl.customersList.add(new Customer(2, "An", new Date(8 / 8 / 1995), "female", 1,
                1, "m", "m", "m"));
        FacilityServiceImpl.facility.put(new Villa("villa1", 56, 56, 1,
                "m", "M", 5, 2), 0);
        FacilityServiceImpl.facility.put(new Villa("villa2", 6, 6, 2,
                "n", "n", 4, 1), 0);
    }

    @Override
    public void addBooking() {
        int id;
        if (bookingSet.isEmpty()) {
            id = 1;
        } else {
            id = bookingSet.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        Date startDate;
        do {
            System.out.println("Pls enter start date: ");
            String startDateAsString = scanner.nextLine();
            try {
                startDate = Validator.validateStartdate(startDateAsString);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        Date endDate;
        do {
            System.out.println("Pls enter end date: ");
            String endDateAsString = scanner.nextLine();
            try {
                endDate = Validator.validateStartdate(endDateAsString);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        System.out.println(bookingSet.add(new Booking(id, startDate, endDate, customer, facility)));
        System.out.println("Add success");
        FacilityServiceImpl.facility.put(facility, FacilityServiceImpl.facility.get(facility) + 1);
    }

    @Override
    public void display() {
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    public Set<Booking> sendBooking() {
        return bookingSet;
    }
}
