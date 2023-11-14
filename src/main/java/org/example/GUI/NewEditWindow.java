package org.example.GUI;

import org.example.GUI.DoctorTable;
import org.example.action.DoctorAction;
import org.example.model.Doctor;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class NewEditWindow extends JFrame{
    private JTextField secondNameField;
    private JTextField firstNameField;
    private JButton applyButton;
    private JTextField middleNameField;
    private JTextField dateOfBirthField;
    private JTextField jobTitleNameField;
    private JTextField specializationField;
    private JPanel root;
    private JTable tableDoctor;
    private Doctor doctor;

    public NewEditWindow( Doctor doctor,JTable tableDoctor)
    {
        this.tableDoctor=tableDoctor;
        this.doctor=doctor;
        setSize(1200, 150);
        setVisible(true);
        setContentPane(root);
        setLocationRelativeTo(null);
        //EditButton.addActionListener(new DoctorTable.EditAction());
        //id= doctor.getId();
        secondNameField.setText(doctor.getSecondName());
        firstNameField.setText(doctor.getFirstName());
        middleNameField.setText(doctor.getMiddleName());
        dateOfBirthField.setText(doctor.getDateOfBirth().toString());
        jobTitleNameField.setText(doctor.getJobTitle());
        specializationField.setText(doctor.getSpecialization());
        applyButton.addActionListener(new EditAction());
        //System.out.println(doctor.getId());
    }
    public NewEditWindow( JTable tableDoctor)
    {
        this.tableDoctor=tableDoctor;
        this.doctor=doctor;
        setSize(1200, 150);
        setVisible(true);
        setContentPane(root);
        setLocationRelativeTo(null);
        applyButton.addActionListener(new EditAction2());
    }
    private class EditAction2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableModel model = tableDoctor.getModel();
            doctor=new Doctor();
            doctor.setSecondName(secondNameField.getText());
            doctor.setFirstName( firstNameField.getText());
            doctor.setMiddleName( middleNameField.getText());
            doctor.setDateOfBirth( Date.valueOf(dateOfBirthField.getText().toString()));
            doctor.setJobTitle( jobTitleNameField.getText());
            doctor.setSpecialization( specializationField.getText());
            DoctorAction action= new DoctorAction();
            action.insert(doctor);
            setVisible(false);
            MainDialog.DialogDoctor();


        }
    }
    private class EditAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableModel model = tableDoctor.getModel();
           doctor.setSecondName(secondNameField.getText());
           doctor.setFirstName( firstNameField.getText());
           doctor.setMiddleName( middleNameField.getText());
           doctor.setDateOfBirth( Date.valueOf(dateOfBirthField.getText().toString()));
           doctor.setJobTitle( jobTitleNameField.getText());
           doctor.setSpecialization( specializationField.getText());
           DoctorAction action= new DoctorAction();
           action.update(doctor);
           setVisible(false);
           MainDialog.DialogDoctor();

        }
    }

}
