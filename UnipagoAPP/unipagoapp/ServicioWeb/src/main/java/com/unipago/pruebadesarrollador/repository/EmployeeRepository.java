package com.unipago.pruebadesarrollador.repository;

import com.unipago.pruebadesarrollador.entity.Employee;

import javax.ejb.Stateless;

/**
 * Created by cristian on 3/26/17.
 */
@Stateless
public class EmployeeRepository extends Repository<Employee> {

    public EmployeeRepository() {
        super(Employee.class);
    }
}
