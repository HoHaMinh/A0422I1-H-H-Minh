package case_study.case_study_controllers;

public class House extends Facility {
    private String standardHouse;
    private int numberOfFloors;

    public House(String nameOfService, double areaOfService, double rentFee, int numberPeoplesAllowed, String typeOfRent, String standardHouse, int numberOfFloors) {
        super(nameOfService, areaOfService, rentFee, numberPeoplesAllowed, typeOfRent);
        this.standardHouse = standardHouse;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardHouse() {
        return standardHouse;
    }

    public void setStandardHouse(String standardHouse) {
        this.standardHouse = standardHouse;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "standardHouse='" + standardHouse + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
