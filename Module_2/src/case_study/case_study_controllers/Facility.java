package case_study.case_study_controllers;

public abstract class Facility {
    private String nameOfService;
    private double areaOfService;
    private double rentFee;
    private int numberPeoplesAllowed;
    private String typeOfRent;

    public Facility() {
    }

    public Facility(String nameOfService, double areaOfService, double rentFee, int numberPeoplesAllowed, String typeOfRent) {
        this.nameOfService = nameOfService;
        this.areaOfService = areaOfService;
        this.rentFee = rentFee;
        this.numberPeoplesAllowed = numberPeoplesAllowed;
        this.typeOfRent = typeOfRent;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public double getAreaOfService() {
        return areaOfService;
    }

    public void setAreaOfService(double areaOfService) {
        this.areaOfService = areaOfService;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
    }

    public int getNumberPeoplesAllowed() {
        return numberPeoplesAllowed;
    }

    public void setNumberPeoplesAllowed(int numberPeoplesAllowed) {
        this.numberPeoplesAllowed = numberPeoplesAllowed;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    @Override
    public String toString() {
        return "nameOfService='" + nameOfService + '\'' +
                ", areaOfService=" + areaOfService +
                ", rentFee=" + rentFee +
                ", numberPeoplesAllowed=" + numberPeoplesAllowed +
                ", typeOfRent='" + typeOfRent + '\'' + ", ";
    }
}
