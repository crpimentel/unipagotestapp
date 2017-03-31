package com.unipago.pruebadesarrollador.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by cristian on 3/26/17.
 */
@FacesConverter("XMLGregorianCalendarConverter")
public class XMLGregorianCalendarConverter extends org.primefaces.convert.DateTimeConverter {

    public XMLGregorianCalendarConverter() {
        this.setTimeZone(TimeZone.getTimeZone("America/Santo_Domingo"));
        this.setPattern("dd/MM/yyyy");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.equals("")) {
            return null;
        }
        Date date = (Date) super.getAsObject(context, component, value);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        XMLGregorianCalendar xgc = null;
        try {
            xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        if(xgc == null) {
            throw new ConverterException(new FacesMessage("Error converting to XMLGregorianCalendar."));
        }
        return xgc;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof XMLGregorianCalendar) || (value == null)) {
            return null;
        }
        Date date = ((XMLGregorianCalendar)value).toGregorianCalendar().getTime();
        return super.getAsString(context, component, date);
    }

}