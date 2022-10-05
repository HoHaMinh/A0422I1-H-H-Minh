package case_study.case_study_controllers;

public class Villa extends Facility {
    private String standardVilla;
    private double areaOfPool;
    private int numberOfFloors;

    public Villa(String nameOfService, double areaOfService, double rentFee, int numberPeoplesAllowed, String typeOfRent, String standardVilla, double areaOfPool, int numberOfFloors) {
        super(nameOfService, areaOfService, rentFee, numberPeoplesAllowed, typeOfRent);
        this.standardVilla = standardVilla;
        this.areaOfPool = areaOfPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardVilla() {
        return standardVilla;
    }

    public void setStandardVilla(String standardVilla) {
        this.standardVilla = standardVilla;
    }

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "standardVilla='" + standardVilla + '\'' +
                ", areaOfPool=" + areaOfPool +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
