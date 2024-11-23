package fr.univtours.polytech.td9.business;

import fr.univtours.polytech.td9.business.country.CountryInfoService;
import fr.univtours.polytech.td9.business.country.CountryInfoServiceSoapType;
import jakarta.ejb.Stateless;

@Stateless
public class CapBusinessImpl implements CapBusiness {

    private CountryInfoServiceSoapType ws = new CountryInfoService().getCountryInfoServiceSoap();

    public String getCapitalCity(String code){
        return ws.capitalCity(code);
    }
}
