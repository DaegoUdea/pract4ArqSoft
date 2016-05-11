/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.logic;

import com.edu.udea.model.Employee;
import com.edu.udea.qualifiers.ExtraHours;

/**
 *
 * @author daego
 */
@ExtraHours
public class PaysheetExtraHours implements IPaysheet {

    @Override
    public long getFinalSalary(Employee employee) {
        System.out.println("Estimating extra hours salary");
        int extraHours = employee.getExtraHours();
        long extraHoursValue = employee.getExtraHoursValue();
        long baseSalary = employee.getBaseSalary();
        
        return baseSalary + (extraHours * extraHoursValue);
    }    
}
