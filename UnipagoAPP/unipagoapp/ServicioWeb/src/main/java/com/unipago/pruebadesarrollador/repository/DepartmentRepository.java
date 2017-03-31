package com.unipago.pruebadesarrollador.repository;

import com.unipago.pruebadesarrollador.entity.Department;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by cristian on 3/26/17.
 */
@Stateless
public class DepartmentRepository extends Repository<Department>{

    public DepartmentRepository() {
        super(Department.class);
    }

    @Override
    public List<Department> findAll() {
        return super.findAll();
//        return getEntityManager().createQuery("select a from Department a join fetch  a.employees ").getResultList();
    }
}
