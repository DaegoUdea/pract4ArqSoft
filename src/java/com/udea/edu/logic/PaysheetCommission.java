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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
