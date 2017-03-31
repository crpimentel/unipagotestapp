package com.unipago.pruebadesarrollador.controller;

import com.unipago.pruebadesarrollador.client.employee.Employee;
import com.unipago.pruebadesarrollador.client.employee.EmployeeService;
import com.unipago.pruebadesarrollador.client.employee.EmployeeService_Service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by cristian on 3/26/17.
 */
@SessionScoped
@Named
public class EmployeeController implements Serializable {
    EmployeeService employeeService = new EmployeeService_Service().getEmployeeServicePort();
    private List<Employee> employees;
    private List<Employee> filteredEmployees;

    private Employee employee;
    private final String EMPLOYEE_PAGE = "employee.xhtml?faces-redirect=true";
    private final String EMPLOYEES_PAGE = "employees.xhtml?faces-redirect=true";

    @PostConstruct
    public void init(){
            employees = employeeService.findAll();

    }

    public String create(){
        employee = new Employee();
        return EMPLOYEE_PAGE;
    }



    public String save() {
            employeeService.save(employee);

        init();
        return EMPLOYEES_PAGE;
    }

    public String edit(Employee employee) {
        this.employee = employee;
        return EMPLOYEE_PAGE;

    }

    public String delete(Employee employee) {
            employeeService.delete(employee);

        return EMPLOYEES_PAGE;

    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getFilteredEmployees() {
        return filteredEmployees;
    }

    public void setFilteredEmployees(List<Employee> filteredEmployees) {
        this.filteredEmployees = filteredEmployees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
