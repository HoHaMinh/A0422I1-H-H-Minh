package Service;

import Model.Student;
import Repository.IStudentRepository;
import Repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository= new StudentRepository();
    @Override
    public List<Student> showAll() {
        return studentRepository.showAll();
    }
}
