package exercise.medical_declaration.repository;

import exercise.medical_declaration.bean.MedicalDeclaration;

public interface IMedicalRepository {
    public MedicalDeclaration show ();
    public void addOrUpdate();
}
