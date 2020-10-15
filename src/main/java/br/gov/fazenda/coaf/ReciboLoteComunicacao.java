
package br.gov.fazenda.coaf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReciboLoteComunicacao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReciboLoteComunicacao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReciboLoteComunicacao", propOrder = {
    "lote"
})
public class ReciboLoteComunicacao {

    protected String lote;

    /**
     * Gets the value of the lote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLote() {
        return lote;
    }

    /**
     * Sets the value of the lote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLote(String value) {
        this.lote = value;
    }

}
