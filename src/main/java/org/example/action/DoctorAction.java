package org.example.action;

import org.example.dao.DoctorDao;
import org.example.dao.PatientDao;
import org.example.model.Doctor;
import org.example.model.Patient;

public class DoctorAction {
    DoctorDao dao = new DoctorDao();
    int st;

    public void insert(Doctor doctor) {
        st = dao.insert(doctor);
        if (st == 1) {
            System.out.println("Doctor Inserted Successfully");
        } else if (st == -1) {
            System.out.println("Doctor Already exists");
        } else {
            System.out.println("Unable to Insert Doctor");
        }
    }

    public void update(Doctor doctor) {
        st = dao.update(doctor);
        if (st == 1) {
            System.out.println("Doctor Updated Successfully");
        } else {
            System.out.println("Unable to update Doctor");
        }
    }

    public void delete(int id) {
        st = dao.delete(id);
        if (st == 1) {
            System.out.println("Doctor Deleted Successfully");
        } else {
            System.out.println("No Record Found");
        }
    }
}
