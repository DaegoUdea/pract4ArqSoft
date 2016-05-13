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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
    private void init() {
        clearForm();
        extraSalary = false;
        extraSalaryType = "extraHours";
    }

    public void addEmployee() {
        long baseSalary = 0;
        int extraHours = 0;
        long extraHoursValue = 0;
        long comission = 0;

        if (validateFields() == 0) {
            return;
        }

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

        Employee employee = new Employee(id, name, baseSalary, extraHours, extraHoursValue, comission, 0);

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

    private int validateFields() {
        int invalid = 1;
        FacesMessage message;
        FacesContext context;
        context = FacesContext.getCurrentInstance();

        if (id == null || id.equals("")) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID error:", "You have to type an identification.");
            context.addMessage(null, message);
            invalid = 0;
        } else {
            List<Employee> employees = employeeService.getEmployees();

            for (Employee employee : employees) {
                if (employee.getId().equalsIgnoreCase(id)) {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID error:", "The employee has been  inserted already.");
                    context.addMessage(null, message);
                    invalid = 0;
                    break;
                }
            }
        }

        if (name == null || name.equals("")) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name error:", "You have to type a name.");
            context.addMessage(null, message);
            invalid = 0;
        }

        if (baseSalaryStr == null || baseSalaryStr.equals("")) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Salary error:", "You have to type a base salary.");
            context.addMessage(null, message);
            invalid = 0;
        }

        if (extraSalary) {
            if (extraSalaryType == null || extraSalaryType.equals("")) {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Extra salary error:", "You have to select a extra salary type.");
                context.addMessage(null, message);
                invalid = 0;
            } else {
                System.out.println(extraSalaryType);
                if (extraSalaryType.equalsIgnoreCase("extraHours")) {
                    if (extraHoursStr == null || extraHoursStr.equals("")) {
                        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Number hours error:", "You have to type a number of hours.");
                        context.addMessage(null, message);
                        invalid = 0;
                    }

                    if (extraHoursValueStr == null || extraHoursValueStr.equals("")) {
                        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hours value error:", "You have to type a hours value.");
                        context.addMessage(null, message);
                        invalid = 0;
                    }
                } else if (extraSalaryType.equalsIgnoreCase("commission")) {
                    if (comissionStr == null || comissionStr.equals("")) {
                        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Commission error:", "You have to type a commission value.");
                        context.addMessage(null, message);
                        invalid = 0;
                    }
                }
            }
        }
        return invalid;
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
