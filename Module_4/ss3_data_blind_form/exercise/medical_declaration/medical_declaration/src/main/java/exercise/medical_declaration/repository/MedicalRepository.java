package exercise.medical_declaration.repository;

import exercise.medical_declaration.bean.MedicalDeclaration;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalRepository implements IMedicalRepository{
    @Override
    public MedicalDeclaration show() {
        return null;
    }

    @Override
    public void addOrUpdate() {

    }
}
