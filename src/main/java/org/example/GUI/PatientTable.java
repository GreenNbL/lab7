package org.example.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Date;

import org.example.NewEditPatientWindow;
import org.example.action.DoctorAction;
import org.example.action.PatientAction;
import org.example.dao.ConnectionFactory;
import org.example.model.Doctor;
import org.example.model.Patient;

public class PatientTable extends JFrame {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status
    private DefaultTableModel tableModel;
    private JPanel root;
    private JScrollPane scroll;
    private JTable tablePatient;
    private JButton AddButton;
    private JButton DeleteButton;
    private JButton EditButton;
    public PatientTable() {
        setSize(400, 250);
        setVisible(true);
        setContentPane(root);
        setLocationRelativeTo(null);
        ShowData();
        EditButton.addActionListener(new EditAction());
        AddButton.addActionListener(new EditAction2());
        DeleteButton.addActionListener(new EditAction3());
    }
    private class EditAction3 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Patient patient = new Patient();
            TableModel model = tablePatient.getModel();
            PatientAction action =new PatientAction();
            int id =Integer.valueOf(model.getValueAt(tablePatient.getSelectedRow(),0).toString());
            action.delete(id);
            setVisible(false);
            MainDialog.DialogPatient();
        }
    }
    private class EditAction2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(tableDoctor.getSelectedRow());
            Patient patient = new Patient();
            TableModel model = tablePatient.getModel();
            NewEditPatientWindow window=new NewEditPatientWindow(tablePatient);
            setVisible(false);
        }
    }
    private class EditAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Patient patient = new Patient();
            TableModel model = tablePatient.getModel();
            patient.setSecondName(model.getValueAt(tablePatient.getSelectedRow(), 1).toString());
            patient.setFirstName(model.getValueAt(tablePatient.getSelectedRow(), 2).toString());
            patient.setMiddleName(model.getValueAt(tablePatient.getSelectedRow(), 3).toString());
            patient.setDateOfBirth(Date.valueOf(model.getValueAt(tablePatient.getSelectedRow(), 4).toString()));
            patient.setDiagnosis(model.getValueAt(tablePatient.getSelectedRow(), 5).toString());
            patient.setId(Integer.valueOf(model.getValueAt(tablePatient.getSelectedRow(),0).toString()));
            NewEditPatientWindow window=new NewEditPatientWindow(patient,tablePatient);
            setVisible(false);
        }
    }

    public void ShowData() {
        Object[] columnTitle = {"id","Фамилия", "Имя", "Отчество", "Дата Рождения","Диагноз"};
        tableModel = new DefaultTableModel(null, columnTitle);
        tablePatient.setModel(tableModel);
        tableModel.getDataVector().removeAllElements();
        System.out.println("Connected in Action_dialog");
        tableModel.getDataVector().removeAllElements();
        con = ConnectionFactory.getConnection();
        String query ="SELECT * FROM patient";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] data = {
                        rs.getString("id"),
                        rs.getString("secondName"),
                        rs.getString("firstName"),
                        rs.getString("middleName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("diagnosis"),

                };
                tableModel.addRow(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
