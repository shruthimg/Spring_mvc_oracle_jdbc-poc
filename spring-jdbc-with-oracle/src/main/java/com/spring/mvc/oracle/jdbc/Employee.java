package com.spring.mvc.oracle.jdbc;

public class Employee {
	private long id;
    private String firstName;
    private String startDate;
    private String jobRole;
    private String departmet;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
    
    public String getDepartmet() {
        return departmet;
    }

    public void setDepartmet(String departmet) {
        this.departmet = departmet;
    }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + startDate + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", departmet='" + departmet + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public static Employee create(String firstName, String startDate, String jobRole, String departmet, String comment) {
    	Employee employee = new Employee();
    	employee.setFirstName(firstName);
    	employee.setStartDate(startDate);
    	employee.setJobRole(jobRole);
    	employee.setDepartmet(departmet);
    	employee.setComment(comment);
        return employee;
    }
}
