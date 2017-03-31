package com.unipago.pruebadesarrollador.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

import static javax.persistence.FetchType.*;

/**
 * Created by cristian on 3/26/17.
 */
@Entity
@Table(name= "department")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_department")
    private Integer id;

    private String name;
    private String inchargeName;
    private String vicePresidency;
    @OneToMany(mappedBy = "department",fetch = LAZY)
    @XmlElement(name="employees")
    private List<Employee> employees;

    public Department(String name, String inchargeName, String vicePresidency) {
        this.name = name;
        this.inchargeName = inchargeName;
        this.vicePresidency = vicePresidency;
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInchargeName() {
        return inchargeName;
    }

    public void setInchargeName(String inchargeName) {
        this.inchargeName = inchargeName;
    }

    public String getVicePresidency() {
        return vicePresidency;
    }

    public void setVicePresidency(String vicePresidency) {
        this.vicePresidency = vicePresidency;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
