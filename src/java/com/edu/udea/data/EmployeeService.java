/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.udea.data;

import com.edu.udea.model.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Daego_000
 */
@ManagedBean(name = "employeeService")
@ApplicationScoped
public class EmployeeService implements Serializable {

    List<Employee> employees;

    @PostConstruct
    public void init() {
        System.out.println("Initializing employees service");
        employees = new ArrayList<Employee>();
        employees.add(new Employee("1", "Rogelio Rivera", 900000, 0, 3000, 0, 903000));
        employees.add(new Employee("2", "Roberto Giraldo", 700000, 4, 2000, 0,708000));
        employees.add(new Employee("3", "Bernarda Tobias", 800000, 3, 4000, 20000,832000));
    }

    @PreDestroy
    public void dsr() {
        System.out.println("Destroying employees Service");
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        System.out.println("Adding employee");
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
}
