package org.example;

import org.example.GUI.MainDialog;
import org.example.GUI.NewEditWindow;
import org.example.action.DoctorAction;
import org.example.action.PatientAction;
import org.example.model.Doctor;
import org.example.model.Patient;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class NewEditPatientWindow extends JFrame {
    private JPanel root;
    private JTextField firstNameField;
    private JTextField secondNameField;
    private JTextField middleNameField;
    private JTextField dateOfBirthField;
    private JTextField diagnosisNameField;
    private JButton applyButton;
    private JTable tablePatient;
    private Patient patient;
    public NewEditPatientWindow(Patient patient, JTable tablePatient)
    {
        this.tablePatient=tablePatient;
        this.patient=patient;
        setSize(1200, 150);
        setVisible(true);
        setContentPane(root);
        setLocationRelativeTo(null);
        secondNameField.setText(patient.getSecondName());
        firstNameField.setText(patient.getFirstName());
        middleNameField.setText(patient.getMiddleName());
        dateOfBirthField.setText(patient.getDateOfBirth().toString());
        diagnosisNameField.setText(patient.getDiagnosis());
        applyButton.addActionListener(new NewEditPatientWindow.EditAction());
        //System.out.println(doctor.getId());
    }
    public NewEditPatientWindow( JTable tablePatient)
    {
        this.tablePatient=tablePatient;
        setSize(1200, 150);
        setVisible(true);
        setContentPane(root);
        setLocationRelativeTo(null);
        applyButton.addActionListener(new NewEditPatientWindow.EditAction2());
    }
    private class EditAction2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableModel model = tablePatient.getModel();
            patient=new Patient();
            patient.setSecondName(secondNameField.getText());
            patient.setFirstName( firstNameField.getText());
            patient.setMiddleName( middleNameField.getText());
            patient.setDateOfBirth( Date.valueOf(dateOfBirthField.getText().toString()));
            patient.setDiagnosis( diagnosisNameField.getText());
            PatientAction action= new PatientAction();
            action.insert(patient);
            setVisible(false);
            MainDialog.DialogPatient();


        }
    }
    private class EditAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableModel model = tablePatient.getModel();
            patient.setSecondName(secondNameField.getText());
            patient.setFirstName( firstNameField.getText());
            patient.setMiddleName( middleNameField.getText());
            patient.setDateOfBirth( Date.valueOf(dateOfBirthField.getText().toString()));
            patient.setDiagnosis( diagnosisNameField.getText());
            PatientAction action= new PatientAction();
            action.update(patient);
            setVisible(false);
            MainDialog.DialogPatient();

        }
    }

}
