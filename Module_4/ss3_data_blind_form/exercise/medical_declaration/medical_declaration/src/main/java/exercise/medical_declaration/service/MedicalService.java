package exercise.medical_declaration.service;

import exercise.medical_declaration.bean.MedicalDeclaration;
import exercise.medical_declaration.repository.IMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalService implements IMedicalService{
    @Autowired
    IMedicalRepository medicalRepository;
    @Override
    public MedicalDeclaration show() {
        return medicalRepository.show();
    }

    @Override
    public void addOrUpdate(MedicalDeclaration medicalDeclaration) {
        medicalRepository.addOrUpdate(medicalDeclaration);
    }
}
