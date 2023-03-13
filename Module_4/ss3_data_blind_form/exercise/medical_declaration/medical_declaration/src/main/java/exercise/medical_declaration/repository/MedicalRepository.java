package exercise.medical_declaration.repository;

import exercise.medical_declaration.bean.MedicalDeclaration;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private MedicalDeclaration medicalDeclarationRepo = new MedicalDeclaration();

    @Override
    public MedicalDeclaration show() {
        return medicalDeclarationRepo;
    }

    @Override
    public void addOrUpdate(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepo = medicalDeclaration;
    }
}
