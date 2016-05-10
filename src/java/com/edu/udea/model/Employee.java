/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.udea.model;

/**
 *
 * @author Daego_000
 */
public class Employee {
    private String id;
    private String name;
    private long baseSalary;
    private int extraHours;
    private long extraHoursValue;
    private long comission;
    private long finalSalary;

    public Employee() {
    }

    public Employee(String id, String name, long baseSalary, int extraHours,
            long extraHoursValue, long comission, long finalSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.extraHours = extraHours;
        this.extraHoursValue = extraHoursValue;
        this.comission = comission;
        this.finalSalary = finalSalary;
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

    public long getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(long baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public long getExtraHoursValue() {
        return extraHoursValue;
    }

    public void setExtraHoursValue(long extraHoursValue) {
        this.extraHoursValue = extraHoursValue;
    }

    public long getComission() {
        return comission;
    }

    public void setComission(long comission) {
        this.comission = comission;
    }

    public long getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(long finalSalary) {
        this.finalSalary = finalSalary;
    }
    
    
    
}
