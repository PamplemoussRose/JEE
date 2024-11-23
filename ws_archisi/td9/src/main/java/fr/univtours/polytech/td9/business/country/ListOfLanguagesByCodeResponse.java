
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
 *         &lt;element name="ListOfLanguagesByCodeResult" type="{http://www.oorsprong.org/websamples.countryinfo}ArrayOftLanguage"/&gt;
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
    "listOfLanguagesByCodeResult"
})
@XmlRootElement(name = "ListOfLanguagesByCodeResponse")
public class ListOfLanguagesByCodeResponse {

    @XmlElement(name = "ListOfLanguagesByCodeResult", required = true)
    protected ArrayOftLanguage listOfLanguagesByCodeResult;

    /**
     * Obtient la valeur de la propriété listOfLanguagesByCodeResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftLanguage }
     *     
     */
    public ArrayOftLanguage getListOfLanguagesByCodeResult() {
        return listOfLanguagesByCodeResult;
    }

    /**
     * Définit la valeur de la propriété listOfLanguagesByCodeResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftLanguage }
     *     
     */
    public void setListOfLanguagesByCodeResult(ArrayOftLanguage value) {
        this.listOfLanguagesByCodeResult = value;
    }

}
