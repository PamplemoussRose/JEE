package webService;

import fr.univtours.polytech.td9.business.SecuBusiness;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "secu")
public class Secu {

    @Inject
    private SecuBusiness business;

    @WebMethod(operationName = "verifCle")
    public boolean cleCorrecte(@WebParam(name = "numero") long numero) {
       return business.checkNumSecu(numero);
    }
}
