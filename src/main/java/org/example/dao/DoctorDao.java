package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import org.example.model.Doctor;
import org.example.model.Patient;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class DoctorDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status
    public int insert(Doctor doctor) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into doctor(firstName,secondName,middleName,dateOfBirth,jobTitle,specialization) "
                    + "values(?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getSecondName());
            ps.setString(3, doctor.getMiddleName());
            ps.setDate(4, doctor.getDateOfBirth());
            ps.setString(5, doctor.getJobTitle());
            ps.setString(6, doctor.getSpecialization());
            st = ps.executeUpdate();
            System.out.println("inserted doctor " + st);
        } catch (MySQLQueryInterruptedException e) {
            st = -1;
            e.printStackTrace();
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }
    public int update(Doctor doctor) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "update doctor set firstName=?,secondName=?,middleName=?,dateOfBirth=?,jobTitle=?,specialization=?"
                    + "where id=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getSecondName());
            ps.setString(3, doctor.getMiddleName());
            ps.setDate(4, doctor.getDateOfBirth());
            ps.setString(5, doctor.getJobTitle());
            ps.setString(6, doctor.getSpecialization());
            ps.setInt(7, doctor.getId());
            System.out.println(doctor.getId());
            st = ps.executeUpdate();
            System.out.println("updated doctor " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;

    }
    public int delete(int id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "delete from doctor where id=? ";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            st = ps.executeUpdate();
            System.out.println("deleted doctor " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }
}

