package com.unipago.pruebadesarrollador.service;

import com.unipago.pruebadesarrollador.entity.Department;
import com.unipago.pruebadesarrollador.entity.Employee;
import com.unipago.pruebadesarrollador.repository.DepartmentRepository;
import com.unipago.pruebadesarrollador.repository.EmployeeRepository;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cristian on 3/28/17.
 */
@WebService(serviceName = "DepartmentService")
public class DepartmentService {

    @Inject
    private DepartmentRepository departmentRepository;

    @WebMethod
    public List<Department> findAll() {
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            for (Employee employee : department.getEmployees()) {
                employee.setDepartment(null);
            }
        }
        Set s = new HashSet<>(departments);

        ArrayList<Department> arrayList = new ArrayList<>(s);
        return arrayList;
    }

}
