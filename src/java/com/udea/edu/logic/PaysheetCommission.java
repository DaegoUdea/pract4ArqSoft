package com.udea.edu.logic;

import com.edu.udea.model.Employee;
import com.edu.udea.qualifiers.Commission;

@Commission
public class PaysheetCommission implements IPaysheet {

        //Función que calcula el el salario final de un empleado apartir de su comision.
    @Override
    public long getFinalSalary(Employee employee) {
        System.out.println("Estimating commission salary");
        long baseSalary = employee.getBaseSalary();
        long commission = employee.getComission();

        return baseSalary + commission;
    }
}
