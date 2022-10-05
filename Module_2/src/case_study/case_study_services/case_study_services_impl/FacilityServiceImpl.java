package case_study.case_study_services.case_study_services_impl;

import case_study.case_study_controllers.Facility;
import case_study.case_study_controllers.House;
import case_study.case_study_controllers.Room;
import case_study.case_study_controllers.Villa;
import case_study.case_study_services.FacilityService;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    public static Map<Facility, Integer> facility = new LinkedHashMap();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> elements : facility.entrySet()) {
            System.out.println(elements);
        }
    }

    @Override
    public void addNew() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Add new villa");
            System.out.println("2. Add new house");
            System.out.println("3. Add new room");
            System.out.println("4. Back to menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addHouse();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    choice = 0;
                    break;
                default:
                    System.out.println("Wrong input. Input must be 1-4. Please choose again!\n");
            }
        }
    }


    @Override
    public void displayMaintenant() {
        List<Facility> maintenantFacility = new ArrayList<>();
        for (Map.Entry<Facility, Integer> elements : facility.entrySet()) {
            if (elements.getValue() >= 5) {
                maintenantFacility.add(elements.getKey());
            }
        }
        for (Facility maintenaantFacility : maintenantFacility
        ) {
            System.out.println("Maintenant facilities: " + maintenaantFacility.toString());
        }
    }

    public void addVilla() {
        Facility facilityInput = inputInformation();
        System.out.println("Pls enter standard of villa: ");
        String standardVilla = scanner.nextLine();
        System.out.println("Pls enter area of pool: ");
        double areaOfPool = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls enter number of floors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Facility villa = new Villa(facilityInput.getNameOfService(),
                facilityInput.getAreaOfService(),
                facilityInput.getRentFee(),
                facilityInput.getNumberPeoplesAllowed(),
                facilityInput.getTypeOfRent(),
                standardVilla, areaOfPool, numberOfFloors) {
        };
        facility.put(villa, 0);
        System.out.println("Add success!");
    }

    public void addHouse() {
        Facility facilityInput = inputInformation();
        System.out.println("Pls enter standard of house: ");
        String standardHouse = scanner.nextLine();
        System.out.println("Pls enter number of floors: ");
        int numberOfFloors = Integer.parseInt((scanner.nextLine()));
        Facility house = new House(facilityInput.getNameOfService(),
                facilityInput.getAreaOfService(),
                facilityInput.getRentFee(),
                facilityInput.getNumberPeoplesAllowed(),
                facilityInput.getTypeOfRent(),
                standardHouse, numberOfFloors) {
        };
        facility.put(house, 0);
        System.out.println("Add success!");
    }

    public void addRoom() {
        Facility facilityInput = inputInformation();
        System.out.println("Pls enter free services: ");
        String freeServices = scanner.nextLine();
        Facility room = new Room(facilityInput.getNameOfService(),
                facilityInput.getAreaOfService(),
                facilityInput.getRentFee(),
                facilityInput.getNumberPeoplesAllowed(),
                facilityInput.getTypeOfRent(),
                freeServices) {
        };
        facility.put(room, 0);
        System.out.println("Add success!");
    }

    public Facility inputInformation() {
        System.out.println("Pls enter name of service: ");
        String nameOfService = scanner.nextLine();
//        String name = null;
//        do {
//            System.out.println("Pls enter name: ");
//            name = scanner.nextLine();
//            try {
//                Validator.validateName(name);
//                break;
//            } catch (UserException e) {
//                System.out.println(e.getMessage());
//            }
//        } while (true);

        System.out.println("Pls enter area of service: ");
        double areaOfService = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls enter rent fee: ");
        double rentFee = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls enter number of max peoples allowed: ");
        int numberPeoplesAllowed = Integer.parseInt(scanner.nextLine());
        System.out.println("Pls enter type of rent: ");
        String typeOfRent = scanner.nextLine();

        Facility facilityInput = new Facility(nameOfService, areaOfService, rentFee, numberPeoplesAllowed, typeOfRent) {
        };
        return facilityInput;
    }
}
