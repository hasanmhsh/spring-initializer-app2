package com.lambdaschool.webemployees;

import java.util.concurrent.atomic.AtomicLong;

public class Employee {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String fname;
    private String lname;
    private double salary;
    private boolean has401K;
    private int companyID;
    private int healthPlanID;

    public Employee(String fname, String lname, double salary, boolean has401K, int companyID, int healthPlanID) {
        this.id = counter.incrementAndGet();
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.has401K = has401K;
        this.companyID = companyID;
        this.healthPlanID = healthPlanID;
    }

    public Employee(Employee e) {
        this.id = e.getId();
        this.fname = e.getFname();
        this.lname = e.getLname();
        this.salary = e.getSalary();
        this.has401K = e.isHas401K();
        this.companyID = e.getCompanyID();
        this.healthPlanID = e.getHealthPlanID();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isHas401K() {
        return has401K;
    }

    public void setHas401K(boolean has401K) {
        this.has401K = has401K;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getHealthPlanID() {
        return healthPlanID;
    }

    public void setHealthPlanID(int healthPlanID) {
        this.healthPlanID = healthPlanID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", salary=" + salary +
                ", has401K=" + has401K +
                ", companyID=" + companyID +
                ", healthPlanID=" + healthPlanID +
                '}';
    }
}
