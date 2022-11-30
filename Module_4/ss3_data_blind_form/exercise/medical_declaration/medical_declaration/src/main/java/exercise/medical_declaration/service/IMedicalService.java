package exercise.medical_declaration.service;

import exercise.medical_declaration.bean.MedicalDeclaration;

public interface IMedicalService {
    public MedicalDeclaration show ();
    public void addOrUpdate(MedicalDeclaration medicalDeclaration);
}
