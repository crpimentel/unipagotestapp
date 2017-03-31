package com.unipago.pruebadesarrollador.service;

import com.unipago.pruebadesarrollador.entity.Employee;
import com.unipago.pruebadesarrollador.repository.EmployeeRepository;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by cristian on 3/26/17.
 */
@WebService(serviceName = "EmployeeService")
public class EmployeeService {


    @Inject
    private EmployeeRepository employeeRepository;

    @WebMethod
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees != null) {
            employees.forEach(x->x.getDepartment().setEmployees(null));
        }
        return employees;
    }
    @WebMethod
    public Employee find(Integer id)  {
        return employeeRepository.find(id);
    }
    @WebMethod
    public Employee save(Employee employee)  {

        Employee employee1 = employeeRepository.merge(employee);
        employee1.getDepartment().setEmployees(null);
        return employee1;
    }

    @WebMethod
    public void delete(Employee employee)  {
        employeeRepository.remove(employee);
    }
}
