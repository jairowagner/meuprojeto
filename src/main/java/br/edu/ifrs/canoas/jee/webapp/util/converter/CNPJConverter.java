package br.edu.ifrs.canoas.jee.webapp.util.converter;
 
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import lombok.experimental.Value;
 
/**
* Conversor de CPF.
*
* @author Pablo Nóbrega
*/
public class CNPJConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
         /*
          * Irá converter CNPJ formatado para um sem pontos e traço.
          */
          String cnpj = value;
          if (value!= null && !value.equals(""))
        	  cnpj = value.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("/", "");
 
          return cnpj;
     }
 
  

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		/*
         * Irá converter CNPJ não formatado para um com pontos e traço.
         */
         String cnpj= arg2.toString();
         if (cnpj != null && cnpj.length() == 14)
        	 cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8 ) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);

         return cnpj;
	}
}