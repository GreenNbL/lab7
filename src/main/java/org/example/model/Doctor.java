package org.example.model;


import java.sql.Date;

public class Doctor {
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private Date dateOfBirth;
    private String jobTitle;
    private String specialization;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//    @Override
//    public String toString() {
//        return "Student{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", mobileNo=" + mobileNo + ", mailId=" + mailId + ", city=" + city + ", designation=" + designation + ", dob=" + dob + ", doj=" + doj + ", salary=" + salary + ", addDate=" + addDate + '}';
//    }
}
