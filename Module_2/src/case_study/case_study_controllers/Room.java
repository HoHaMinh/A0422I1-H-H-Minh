package case_study.case_study_controllers;

public class Room extends Facility {
    private String freeServices;

    public Room(String nameOfService, double areaOfService, double rentFee, int numberPeoplesAllowed, String typeOfRent, String freeServices) {
        super(nameOfService, areaOfService, rentFee, numberPeoplesAllowed, typeOfRent);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                "freeServices='" + freeServices + '\'' +
                '}';
    }
}
