package case_study.case_study_services;

public interface EmployeeService extends Service {
    @Override
    void display();

    void addNew();

    void edit();
}
