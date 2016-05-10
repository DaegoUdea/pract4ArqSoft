/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.logic;

import com.edu.udea.model.Employee;

/**
 *
 * @author Daego_000
 */
public interface IEmployeeDao {
    
    public Employee getEmployee(String id, String name, long baseSalary,
            int extraHours, long extraHoursValue, long comission);
    
}
