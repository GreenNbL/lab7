package org.example.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Date;

import org.example.action.DoctorAction;
import org.example.dao.ConnectionFactory;
import org.example.model.Doctor;

public class DoctorTable extends JFrame {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status
    private DefaultTableModel tableModel;
    private JPanel root;
    private JScrollPane scroll;
    private JTable tableDoctor;
    private JButton AddButton;
    private JButton DeleteButton;
    private JButton EditButton;
    public DoctorTable() {
        setSize(400, 250);
        setVisible(true);
        setContentPane(root);
        setLocationRelativeTo(null);
        ShowData();
        EditButton.addActionListener(new EditAction());
        AddButton.addActionListener(new EditAction2());
        DeleteButton.addActionListener(new EditAction3());
    }
    public void close()
    {
        setVisible(false);
    }
    private class EditAction3 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Doctor doctor=new Doctor();
            TableModel model = tableDoctor.getModel();
            DoctorAction action =new DoctorAction();
            int id =Integer.valueOf(model.getValueAt(tableDoctor.getSelectedRow(),0).toString());
            action.delete(id);
            setVisible(false);
            MainDialog.DialogDoctor();
        }
    }
    private class EditAction2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(tableDoctor.getSelectedRow());
            Doctor doctor=new Doctor();
            TableModel model = tableDoctor.getModel();
            NewEditWindow window=new NewEditWindow(tableDoctor);
            setVisible(false);
        }
    }
    private class EditAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(tableDoctor.getSelectedRow());
            Doctor doctor=new Doctor();
            TableModel model = tableDoctor.getModel();
            doctor.setSecondName(model.getValueAt(tableDoctor.getSelectedRow(), 1).toString());
            doctor.setFirstName(model.getValueAt(tableDoctor.getSelectedRow(), 2).toString());
            doctor.setMiddleName(model.getValueAt(tableDoctor.getSelectedRow(), 3).toString());
            doctor.setDateOfBirth(Date.valueOf(model.getValueAt(tableDoctor.getSelectedRow(), 4).toString()));
            doctor.setJobTitle(model.getValueAt(tableDoctor.getSelectedRow(), 5).toString());
            doctor.setSpecialization(model.getValueAt(tableDoctor.getSelectedRow(), 6).toString());
            doctor.setId(Integer.valueOf(model.getValueAt(tableDoctor.getSelectedRow(),0).toString()));
            NewEditWindow window=new NewEditWindow(doctor,tableDoctor);
            setVisible(false);
        }
    }

    public void ShowData() {
        Object[] columnTitle = {"id","Фамилия", "Имя", "Отчество", "Дата Рождения","Должность","Специализация"};
        tableModel = new DefaultTableModel(null, columnTitle);
        tableDoctor.setModel(tableModel);
        tableModel.getDataVector().removeAllElements();
        System.out.println("Connected in Action_dialog");
        tableModel.getDataVector().removeAllElements();
        con = ConnectionFactory.getConnection();
        String query ="SELECT * FROM doctor";
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
                    rs.getString("jobTitle"),
                    rs.getString("specialization")

            };
           // System.out.println(rs.getString("id"));
            tableModel.addRow(data);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
