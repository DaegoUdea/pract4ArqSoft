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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import com.udea.edu.logic.IPaysheet;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Daego_000
 */
@ManagedBean(name = "employeeBean")
@ViewScoped
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

    private String id;
    private String name;
    private String baseSalaryStr;
    private String extraHoursStr;
    private String extraHoursValueStr;
    private String comissionStr;

    private boolean extraSalary;
    private String extraSalaryType;
    private List<Employee> employees;

    public EmployeeBean() {
    }
    
    @PostConstruct
    private void init () {
        clearForm();
        extraSalary = false;
        extraSalaryType = "extraHours";        
    }

    public void addEmployee() {
        long baseSalary = 0;
        int extraHours = 0;
        long extraHoursValue = 0;
        long comission = 0;

        if (baseSalaryStr != null && !baseSalaryStr.equalsIgnoreCase("")) {
            baseSalary = Long.parseLong(baseSalaryStr);
        }
        if (extraHoursStr != null && !extraHoursStr.equalsIgnoreCase("")) {
            extraHours = Integer.parseInt(extraHoursStr);
        }
        if (extraHoursValueStr != null && !extraHoursValueStr.equalsIgnoreCase("")) {
            extraHoursValue = Long.parseLong(extraHoursValueStr);
        }
        if (comissionStr != null && !comissionStr.equalsIgnoreCase("")) {
            comission = Long.parseLong(comissionStr);
        }

        System.out.println(extraHoursStr);
        System.out.println(extraHoursValueStr);

        System.out.println(extraHours);
        System.out.println(extraHoursValue);

        Employee employee = new Employee(id, name, baseSalary, extraHours, extraHoursValue, comission, 0);
        System.out.println(extraSalary + " -- " + extraSalaryType);
        
        if (extraSalary) {
            if (extraSalaryType.equalsIgnoreCase("extraHours")) {
                employee.setFinalSalary(extraHoursPaysheet.getFinalSalary(employee));
            } else if (extraSalaryType.equalsIgnoreCase("commission")) {
                employee.setFinalSalary(commissionPaysheet.getFinalSalary(employee));
            }
        } else {
            employee.setFinalSalary(normalPaysheet.getFinalSalary(employee));
        }
        employeeService.addEmployee(employee);
        clearForm();
    }

    private void clearForm() {
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

    public boolean isExtraSalary() {
        return extraSalary;
    }

    public void setExtraSalary(boolean extraSalary) {
        this.extraSalary = extraSalary;
    }

    public String getExtraSalaryType() {
        return extraSalaryType;
    }

    public void setExtraSalaryType(String extraSalaryType) {
        this.extraSalaryType = extraSalaryType;
    }
}
