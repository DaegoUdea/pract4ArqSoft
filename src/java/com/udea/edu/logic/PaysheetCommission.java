/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.logic;

import com.edu.udea.model.Employee;
import com.edu.udea.qualifiers.Commission;

/**
 *
 * @author daego
 */
@Commission
public class PaysheetCommission implements IPaysheet {

    @Override
    public long getFinalSalary(Employee employee) {
        System.out.println("Estimating commission salary");
        long baseSalary = employee.getBaseSalary();
        long commission = employee.getComission();

        return baseSalary + commission;
    }
}
