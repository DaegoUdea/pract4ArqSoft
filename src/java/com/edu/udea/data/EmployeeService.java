package com.edu.udea.data;

import com.edu.udea.model.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "employeeService")
@ApplicationScoped
public class EmployeeService implements Serializable {

    List<Employee> employees;

    //Funcion que inicializa algunos empleados en la lista de empleados inmediatamente despues
    //de la instanciacion de la clase.
    @PostConstruct
    public void init() {
        System.out.println("Initializing employees service");
        employees = new ArrayList<Employee>();
        employees.add(new Employee("1", "Rogelio Rivera", 900000, 0, 3000, 0, 903000));
        employees.add(new Employee("2", "Roberto Giraldo", 700000, 4, 2000, 0, 708000));
        employees.add(new Employee("3", "Bernarda Tobias", 800000, 3, 4000, 20000, 820000));
    }

    //Funcion que se ejecuta cuando la instancia de la clase está por ser destruida.
    @PreDestroy
    public void release() {
        System.out.println("Destroying employees Service");
    }

    //Funcion para obtener la lista de empleados.
    public List<Employee> getEmployees() {
        System.out.println("Returning employees");
        return employees;
    }

    //Funcion para añadir empleados.
    public void addEmployee(Employee employee) {
        System.out.println("Adding employee");
        //Se inserta un empleado al principio de la lista.
        employees.add(0, employee);
    }

    //Funcion para remover empleados.
    public void removeEmployee(Employee employee) {
        System.out.println("Removing employee");
        employees.remove(employee);
    }
}
