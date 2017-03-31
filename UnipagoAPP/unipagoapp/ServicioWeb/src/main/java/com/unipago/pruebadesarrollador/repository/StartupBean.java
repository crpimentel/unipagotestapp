package com.unipago.pruebadesarrollador.repository;

import com.unipago.pruebadesarrollador.entity.Department;
import com.unipago.pruebadesarrollador.entity.Employee;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Collections;

/**
 * Created by cristian on 3/28/17.
 */
@Startup
@Singleton
public class StartupBean {

    @Inject
    DepartmentRepository departmentRepository;
    @Inject
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        Department tecnologia = new Department("Departamento prueba", "Persona a cargo", "Tecnologia");
        Employee employee = new Employee();
        employee.setName("Cristian");
        employee.setDepartment(tecnologia);
        Employee employee2 = new Employee();
        employee2.setName("Mariela");
        employee2.setDepartment(tecnologia);
        departmentRepository.save(tecnologia);
        employeeRepository.save(employee);
        employeeRepository.save(employee2);
        departmentRepository.merge(tecnologia);

    }
}
