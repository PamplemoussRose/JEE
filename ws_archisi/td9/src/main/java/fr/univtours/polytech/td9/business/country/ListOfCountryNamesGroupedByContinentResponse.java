
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
 *         &lt;element name="ListOfCountryNamesGroupedByContinentResult" type="{http://www.oorsprong.org/websamples.countryinfo}ArrayOftCountryCodeAndNameGroupedByContinent"/&gt;
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
    "listOfCountryNamesGroupedByContinentResult"
})
@XmlRootElement(name = "ListOfCountryNamesGroupedByContinentResponse")
public class ListOfCountryNamesGroupedByContinentResponse {

    @XmlElement(name = "ListOfCountryNamesGroupedByContinentResult", required = true)
    protected ArrayOftCountryCodeAndNameGroupedByContinent listOfCountryNamesGroupedByContinentResult;

    /**
     * Obtient la valeur de la propriété listOfCountryNamesGroupedByContinentResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountryCodeAndNameGroupedByContinent }
     *     
     */
    public ArrayOftCountryCodeAndNameGroupedByContinent getListOfCountryNamesGroupedByContinentResult() {
        return listOfCountryNamesGroupedByContinentResult;
    }

    /**
     * Définit la valeur de la propriété listOfCountryNamesGroupedByContinentResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountryCodeAndNameGroupedByContinent }
     *     
     */
    public void setListOfCountryNamesGroupedByContinentResult(ArrayOftCountryCodeAndNameGroupedByContinent value) {
        this.listOfCountryNamesGroupedByContinentResult = value;
    }

}
