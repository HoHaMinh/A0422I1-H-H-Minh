package case_study.case_study_services.case_study_services_impl;

import case_study.case_study_controllers.Booking;
import case_study.case_study_controllers.Contract;
import case_study.case_study_models.Customer;
import case_study.case_study_services.ContactService;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    static List<Contract> contractList = new ArrayList<>();
    Queue<Booking> bookingQueue = new LinkedList<>();
    Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void createNewContract() {
        for (Booking booking : bookingSet
        ) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();
            System.out.println("Creating new contract for booking information");
            System.out.println("Creating new contract for customer information");
            System.out.println("Pls enter contract No.");
            int contractNo = Integer.parseInt(scanner.nextLine());
            System.out.println("Pls enter the amount for advance payment");
            double advancePayment = Double.parseDouble(scanner.nextLine());
            System.out.println("Pls enter total payment");
            double totalPayment = Double.parseDouble(scanner.nextLine());
            Contract contract = new Contract(contractNo, advancePayment, totalPayment, booking, customer);
            System.out.println("Create new contract success!");
            contractList.add(contract);
        }
    }

    @Override
    public void display() {
        for (Contract contract : contractList
        ) {
            System.out.println(contract.toString());
        }
    }

    @Override
    public void editContract() {
        boolean idChecking = true;
        do {
            System.out.println("Pls enter contract No. which need to be edited: ");
            int contractNo = Integer.parseInt(scanner.nextLine());
            int length = contractList.size();
            for (int i = 0; i < length; i++) {
                Booking booking = bookingQueue.poll();
                Customer customer = booking.getCustomer();
                if (contractList.get(i).getContractNo() == contractNo) {
                    System.out.println("Pls input all information of contract with id " + contractNo);
                    System.out.println("Pls enter contract No.");
                    contractNo = Integer.parseInt(scanner.nextLine());
                    System.out.println("Pls enter the amount for advance payment");
                    double advancePayment = Double.parseDouble(scanner.nextLine());
                    System.out.println("Pls enter total payment");
                    double totalPayment = Double.parseDouble(scanner.nextLine());
                    Contract contract = new Contract(contractNo, advancePayment, totalPayment, booking, customer);
                    contractList.set(i, contract);
                    idChecking = false;
                    break;
                } else if (i == length - 1) {
                    System.out.println("Do not find any contract No:  " + contractNo);
                }
            }
        } while (idChecking);
    }
}
