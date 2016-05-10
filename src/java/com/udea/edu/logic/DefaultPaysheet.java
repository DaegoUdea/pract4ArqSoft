/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.logic;

import com.edu.udea.model.Employee;
import com.edu.udea.qualifiers.Normal;

/**
 *
 * @author Daego_000
 */
@Normal
public class DefaultPaysheet implements IPaysheet {

    @Override
    public long getFinalSalary(Employee employee) {
        return -1;
    }
}
