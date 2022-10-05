package case_study.case_study_services;

public interface ContactService extends Service {
    void createNewContract();

    @Override
    void display();

    void editContract();
}
