/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.udea.controllers;

import com.edu.udea.data.EmployeeService;
import com.edu.udea.model.Employee;
import com.edu.udea.qualifiers.Commission;
import com.edu.udea.qualifiers.ExtraHours;
import com.edu.udea.qualifiers.Normal;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import com.udea.edu.logic.IPaysheet;

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
    @Normal
    private IPaysheet normalPaysheet;

    @Inject
    @ExtraHours
    private IPaysheet extraHoursPaysheet;
    
    @Inject
    @Commission
    private IPaysheet commissionPaysheet;
    
    

    private String id = "";
    private String name = "";
    private String baseSalaryStr = "0";
    private String extraHoursStr = "0";
    private String extraHoursValueStr = "0";
    private String comissionStr = "0";

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

        //Employee employee = employeeDao.getEmployee(id, name, baseSalary, extraHours, extraHoursValue, comission);
        //employeeService.addEmployee(employee);

        id = "";
        name = "";
        baseSalaryStr = "0";
        extraHoursStr = "0";
        extraHoursValueStr = "0";
        comissionStr = "0";
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
