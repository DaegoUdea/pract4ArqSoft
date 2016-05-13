package com.udea.edu.logic;

import com.edu.udea.model.Employee;
import com.edu.udea.qualifiers.Normal;

@Normal
public class DefaultPaysheet implements IPaysheet {

    //Función que calcula el el salario final de un empleado apartir de su salario base.
    @Override
    public long getFinalSalary(Employee employee) {
        System.out.println("Estimating default salary");
        long baseSalary = employee.getBaseSalary();
        return baseSalary;
    }
}
