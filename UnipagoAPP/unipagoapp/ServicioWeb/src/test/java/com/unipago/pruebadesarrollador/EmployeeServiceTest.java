package com.unipago.pruebadesarrollador;

import com.unipago.pruebadesarrollador.entity.Employee;
import com.unipago.pruebadesarrollador.repository.EmployeeRepository;
import com.unipago.pruebadesarrollador.service.EmployeeService;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by cristian on 3/29/17.
 */
@RunWith(Arquillian.class)
public class EmployeeServiceTest {

    @Inject
    EmployeeService employeeService;


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(EmployeeService.class, EmployeeRepository.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    }

    @Test
    public void saveEmployee() {
        Employee employee = new Employee();
            employee = employeeService.save(employee);

        Assert.assertNotNull(employee.getId());
    }

    @Test
    public void findAllEmployees() throws DatabaseException {
        Employee employee1 = new Employee();
        employee1.setName("Edgar");

        Employee employee2 = new Employee();
        employee2.setName("Enmanuel");
        employeeService.save(employee1);
        employeeService.save(employee2);

        Assert.assertEquals(employeeService.findAll().size(), 2);
    }

    @Test
    public void deleteEmployee() throws DatabaseException {
        Employee employee = new Employee();
        employee = employeeService.save(employee);

        employeeService.delete(employee);

        Employee employeeFromDb = employeeService.find(1);
        Assert.assertNull(employeeFromDb);
    }

    @Test
    public void findEmployee() throws DatabaseException {
        Employee employee = new Employee();
        employee.setName("Enmanuel");
        employeeService.save(employee);
        Employee employeeFromDb = null;
        employeeFromDb = employeeService.find(1);

        Assert.assertEquals(employee.getName(), employeeFromDb.getName());
    }
}
