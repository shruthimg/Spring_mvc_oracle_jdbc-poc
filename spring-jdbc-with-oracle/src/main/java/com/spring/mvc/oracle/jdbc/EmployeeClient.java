package com.spring.mvc.oracle.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeClient {

    @Autowired
    Dao<Employee> empDao;

    public void process() {
        List<Employee> list = empDao.loadAll();
        System.out.println("Loaded all: " + list);

        Employee employee = Employee.create("Alex", "25-08-2018", "Tester", "Testing an application", "no");
        System.out.println("saving: "+employee);
        empDao.save(employee);

        List<Employee> list2 = empDao.loadAll();
        System.out.println("Loaded all: " + list2);

    }
}