package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import org.example.model.Patient;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class PatientDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status
    public int insert(Patient patient) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into patient(firstName,secondName,middleName,dateOfBirth,diagnosis) "
                    + "values(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getSecondName());
            ps.setString(3, patient.getMiddleName());
            ps.setDate(4, patient.getDateOfBirth());
            ps.setString(5, patient.getDiagnosis());
            st = ps.executeUpdate();
            System.out.println("inserted student " + st);
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
    public int update(Patient patient) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "update patient set firstName=?,secondName=?,middleName=?,dateOfBirth=?,diagnosis=?"
                    + "where id=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getSecondName());
            ps.setString(3, patient.getMiddleName());
            ps.setDate(4, patient.getDateOfBirth());
            ps.setString(5, patient.getDiagnosis());
            ps.setInt(6, patient.getId());
            st = ps.executeUpdate();
            System.out.println("updated student " + st);
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
            String query = "delete from patient where id=? ";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            st = ps.executeUpdate();
            System.out.println("deleted patient " + st);
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
