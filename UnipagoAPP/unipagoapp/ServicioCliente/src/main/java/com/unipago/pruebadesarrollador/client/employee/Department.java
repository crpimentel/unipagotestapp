
package com.unipago.pruebadesarrollador.client.employee;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for department complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="department">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employees" type="{http://service.pruebadesarrollador.unipago.com/}employee" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="inchargeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vicePresidency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "department", propOrder = {
    "employees",
    "id",
    "inchargeName",
    "name",
    "vicePresidency"
})
public class Department {

    @XmlElement(nillable = true)
    protected List<Employee> employees;
    protected Integer id;
    protected String inchargeName;
    protected String name;
    protected String vicePresidency;

    /**
     * Gets the value of the employees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmployees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Employee }
     * 
     * 
     */
    public List<Employee> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        return this.employees;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the inchargeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInchargeName() {
        return inchargeName;
    }

    /**
     * Sets the value of the inchargeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInchargeName(String value) {
        this.inchargeName = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the vicePresidency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVicePresidency() {
        return vicePresidency;
    }

    /**
     * Sets the value of the vicePresidency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVicePresidency(String value) {
        this.vicePresidency = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != com.unipago.pruebadesarrollador.client.department.Department.class &&
                getClass() != o.getClass())) return false;

        try {
            Department that = (Department) o;
            return id.equals(that.id);

        }
        catch (Exception e) {
            com.unipago.pruebadesarrollador.client.department.Department that = (com.unipago.pruebadesarrollador.client.department.Department) o;
            return id.equals(that.getId());
        }

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
