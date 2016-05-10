/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.udea.controllers;

import com.edu.udea.data.EmployeeService;
import com.edu.udea.model.Employee;
import com.udea.edu.logic.IEmployeeDao;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

/**
 *
 * @author Daego_000
 */
@ManagedBean(name = "employeeBean")
@RequestScoped
public class EmployeeBean implements Serializable {

    @ManagedProperty(value = "#{employeeService}")
    private EmployeeService employeeService;
    
    @Inject
    private IEmployeeDao employeeDao;

    private String id;
    private String name;
    private String baseSalaryStr;
    private String extraHoursStr;
    private String extraHoursValueStr;
    private String comissionStr;

    private List<Employee> employees;

    public EmployeeBean() {
    }

    public void addEmployee() {
        long baseSalary = 0;
        int extraHours = 0;
        long extraHoursValue = 0;
        long comission = 0;

        if (!baseSalaryStr.equalsIgnoreCase("")) {
            baseSalary = Long.parseLong(baseSalaryStr);
        }
        if (!extraHoursStr.equalsIgnoreCase("")) {
            extraHours = Integer.parseInt(extraHoursStr);
        }
        if (!extraHoursValueStr.equalsIgnoreCase("")) {
            extraHoursValue = Long.parseLong(extraHoursValueStr);
        }
        if (!comissionStr.equalsIgnoreCase("")) {
            comission = Long.parseLong(comissionStr);
        }

        Employee employee = employeeDao.getEmployee(id, name, baseSalary, extraHours, extraHoursValue, comission);
        employeeService.addEmployee(employee);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseSalaryStr() {
        return baseSalaryStr;
    }

    public void setBaseSalaryStr(String baseSalaryStr) {
        this.baseSalaryStr = baseSalaryStr;
    }

    public String getExtraHoursStr() {
        return extraHoursStr;
    }

    public void setExtraHoursStr(String extraHoursStr) {
        this.extraHoursStr = extraHoursStr;
    }

    public String getExtraHoursValueStr() {
        return extraHoursValueStr;
    }

    public void setExtraHoursValueStr(String extraHoursValueStr) {
        this.extraHoursValueStr = extraHoursValueStr;
    }

    public String getComissionStr() {
        return comissionStr;
    }

    public void setComissionStr(String comissionStr) {
        this.comissionStr = comissionStr;
    }

    public List<Employee> getEmployees() {
        employees = employeeService.getEmployees();
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
