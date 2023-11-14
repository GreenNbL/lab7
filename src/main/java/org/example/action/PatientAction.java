package org.example.action;

import org.example.dao.PatientDao;
import org.example.model.Patient;

public class PatientAction {
    PatientDao dao = new PatientDao();
    int st;

    public void insert(Patient patient) {
        st = dao.insert(patient);
        if (st == 1) {
            System.out.println("Patient Inserted Successfully");
        } else if (st == -1) {
            System.out.println("Patient Already exists");
        } else {
            System.out.println("Unable to Insert Patient");
        }
    }

    public void update(Patient patient) {
        st = dao.update(patient);
        if (st == 1) {
            System.out.println("Patient Updated Successfully");
        } else {
            System.out.println("Unable to update Patient");
        }
    }

    public void delete(int id) {
        st = dao.delete(id);
        if (st == 1) {
            System.out.println("Patient Deleted Successfully");
        } else {
            System.out.println("No Record Found");
        }
    }
}
