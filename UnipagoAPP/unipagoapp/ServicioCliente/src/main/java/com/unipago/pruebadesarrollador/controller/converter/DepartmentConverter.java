package com.unipago.pruebadesarrollador.controller.converter;

import com.unipago.pruebadesarrollador.client.department.Department;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by cristian on 3/28/17.
 */
@FacesConverter("departmentConverter")
public class DepartmentConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        com.unipago.pruebadesarrollador.client.employee.Department d = new com.unipago.pruebadesarrollador.client.employee.Department();
        d.setId(Integer.parseInt(s));
        d.setInchargeName("");
        d.setVicePresidency("");
        d.setName("");
        return d;
//        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

//        return "";
        try {
            return ((Department)o).getId().toString();

        } catch (Exception e) {
            return ((com.unipago.pruebadesarrollador.client.employee.Department)o).getId().toString();

        }
    }
}
