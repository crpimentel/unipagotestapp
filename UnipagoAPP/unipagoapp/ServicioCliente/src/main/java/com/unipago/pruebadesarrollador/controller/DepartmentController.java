package com.unipago.pruebadesarrollador.controller;


import com.unipago.pruebadesarrollador.client.department.Department;
import com.unipago.pruebadesarrollador.client.department.DepartmentService;
import com.unipago.pruebadesarrollador.client.department.DepartmentService_Service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by cristian on 3/28/17.
 */
@SessionScoped
@Named
public class DepartmentController  implements Serializable {

    DepartmentService departmentService = new DepartmentService_Service().getDepartmentServicePort();

    private List<Department> departments;
    private List<Department> filteredDepartments;

    private Department department;
    private final String DEPARTMENT_PAGE = "department.xhtml?faces-redirect=true";

    @PostConstruct
    public void init(){
        departments = departmentService.findAll();

    }

    public String view(Department department) {
        this.department = department;
        return DEPARTMENT_PAGE;
    }
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getFilteredDepartments() {
        return filteredDepartments;
    }

    public void setFilteredDepartments(List<Department> filteredDepartments) {
        this.filteredDepartments = filteredDepartments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
