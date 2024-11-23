
package fr.univtours.polytech.td9.business.country;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CountryCurrencyResult" type="{http://www.oorsprong.org/websamples.countryinfo}tCurrency"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "countryCurrencyResult"
})
@XmlRootElement(name = "CountryCurrencyResponse")
public class CountryCurrencyResponse {

    @XmlElement(name = "CountryCurrencyResult", required = true)
    protected TCurrency countryCurrencyResult;

    /**
     * Obtient la valeur de la propriété countryCurrencyResult.
     * 
     * @return
     *     possible object is
     *     {@link TCurrency }
     *     
     */
    public TCurrency getCountryCurrencyResult() {
        return countryCurrencyResult;
    }

    /**
     * Définit la valeur de la propriété countryCurrencyResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TCurrency }
     *     
     */
    public void setCountryCurrencyResult(TCurrency value) {
        this.countryCurrencyResult = value;
    }

}
