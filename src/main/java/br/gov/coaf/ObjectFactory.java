
package br.gov.coaf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.coaf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SolicitaReciboEnvio_QNAME = new QName("http://www.gov.br/coaf/", "SolicitaReciboEnvio");
    private final static QName _EnviarLoteComunicacao_QNAME = new QName("http://www.gov.br/coaf/", "EnviarLoteComunicacao");
    private final static QName _SolicitaProtocoloComunicacaoResponse_QNAME = new QName("http://www.gov.br/coaf/", "SolicitaProtocoloComunicacaoResponse");
    private final static QName _ReciboLoteComunicacaoResponse_QNAME = new QName("http://www.gov.br/coaf/", "ReciboLoteComunicacaoResponse");
    private final static QName _CancelarLoteComunicacao_QNAME = new QName("http://www.gov.br/coaf/", "CancelarLoteComunicacao");
    private final static QName _EnviarLoteComunicacaoResponse_QNAME = new QName("http://www.gov.br/coaf/", "EnviarLoteComunicacaoResponse");
    private final static QName _ReciboLoteComunicacao_QNAME = new QName("http://www.gov.br/coaf/", "ReciboLoteComunicacao");
    private final static QName _SolicitaReciboEnvioResponse_QNAME = new QName("http://www.gov.br/coaf/", "SolicitaReciboEnvioResponse");
    private final static QName _CancelarLoteComunicacaoResponse_QNAME = new QName("http://www.gov.br/coaf/", "CancelarLoteComunicacaoResponse");
    private final static QName _SolicitaProtocoloComunicacao_QNAME = new QName("http://www.gov.br/coaf/", "SolicitaProtocoloComunicacao");
    private final static QName _RetificarLoteComunicacao_QNAME = new QName("http://www.gov.br/coaf/", "RetificarLoteComunicacao");
    private final static QName _RetificarLoteComunicacaoResponse_QNAME = new QName("http://www.gov.br/coaf/", "RetificarLoteComunicacaoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.coaf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnviarLoteComunicacao }
     * 
     */
    public EnviarLoteComunicacao createEnviarLoteComunicacao() {
        return new EnviarLoteComunicacao();
    }

    /**
     * Create an instance of {@link SolicitaProtocoloComunicacaoResponse }
     * 
     */
    public SolicitaProtocoloComunicacaoResponse createSolicitaProtocoloComunicacaoResponse() {
        return new SolicitaProtocoloComunicacaoResponse();
    }

    /**
     * Create an instance of {@link ReciboLoteComunicacaoResponse }
     * 
     */
    public ReciboLoteComunicacaoResponse createReciboLoteComunicacaoResponse() {
        return new ReciboLoteComunicacaoResponse();
    }

    /**
     * Create an instance of {@link SolicitaReciboEnvio }
     * 
     */
    public SolicitaReciboEnvio createSolicitaReciboEnvio() {
        return new SolicitaReciboEnvio();
    }

    /**
     * Create an instance of {@link CancelarLoteComunicacaoResponse }
     * 
     */
    public CancelarLoteComunicacaoResponse createCancelarLoteComunicacaoResponse() {
        return new CancelarLoteComunicacaoResponse();
    }

    /**
     * Create an instance of {@link SolicitaProtocoloComunicacao }
     * 
     */
    public SolicitaProtocoloComunicacao createSolicitaProtocoloComunicacao() {
        return new SolicitaProtocoloComunicacao();
    }

    /**
     * Create an instance of {@link RetificarLoteComunicacao }
     * 
     */
    public RetificarLoteComunicacao createRetificarLoteComunicacao() {
        return new RetificarLoteComunicacao();
    }

    /**
     * Create an instance of {@link RetificarLoteComunicacaoResponse }
     * 
     */
    public RetificarLoteComunicacaoResponse createRetificarLoteComunicacaoResponse() {
        return new RetificarLoteComunicacaoResponse();
    }

    /**
     * Create an instance of {@link CancelarLoteComunicacao }
     * 
     */
    public CancelarLoteComunicacao createCancelarLoteComunicacao() {
        return new CancelarLoteComunicacao();
    }

    /**
     * Create an instance of {@link EnviarLoteComunicacaoResponse }
     * 
     */
    public EnviarLoteComunicacaoResponse createEnviarLoteComunicacaoResponse() {
        return new EnviarLoteComunicacaoResponse();
    }

    /**
     * Create an instance of {@link ReciboLoteComunicacao }
     * 
     */
    public ReciboLoteComunicacao createReciboLoteComunicacao() {
        return new ReciboLoteComunicacao();
    }

    /**
     * Create an instance of {@link SolicitaReciboEnvioResponse }
     * 
     */
    public SolicitaReciboEnvioResponse createSolicitaReciboEnvioResponse() {
        return new SolicitaReciboEnvioResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitaReciboEnvio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "SolicitaReciboEnvio")
    public JAXBElement<SolicitaReciboEnvio> createSolicitaReciboEnvio(SolicitaReciboEnvio value) {
        return new JAXBElement<SolicitaReciboEnvio>(_SolicitaReciboEnvio_QNAME, SolicitaReciboEnvio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarLoteComunicacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "EnviarLoteComunicacao")
    public JAXBElement<EnviarLoteComunicacao> createEnviarLoteComunicacao(EnviarLoteComunicacao value) {
        return new JAXBElement<EnviarLoteComunicacao>(_EnviarLoteComunicacao_QNAME, EnviarLoteComunicacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitaProtocoloComunicacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "SolicitaProtocoloComunicacaoResponse")
    public JAXBElement<SolicitaProtocoloComunicacaoResponse> createSolicitaProtocoloComunicacaoResponse(SolicitaProtocoloComunicacaoResponse value) {
        return new JAXBElement<SolicitaProtocoloComunicacaoResponse>(_SolicitaProtocoloComunicacaoResponse_QNAME, SolicitaProtocoloComunicacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReciboLoteComunicacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "ReciboLoteComunicacaoResponse")
    public JAXBElement<ReciboLoteComunicacaoResponse> createReciboLoteComunicacaoResponse(ReciboLoteComunicacaoResponse value) {
        return new JAXBElement<ReciboLoteComunicacaoResponse>(_ReciboLoteComunicacaoResponse_QNAME, ReciboLoteComunicacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarLoteComunicacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "CancelarLoteComunicacao")
    public JAXBElement<CancelarLoteComunicacao> createCancelarLoteComunicacao(CancelarLoteComunicacao value) {
        return new JAXBElement<CancelarLoteComunicacao>(_CancelarLoteComunicacao_QNAME, CancelarLoteComunicacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarLoteComunicacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "EnviarLoteComunicacaoResponse")
    public JAXBElement<EnviarLoteComunicacaoResponse> createEnviarLoteComunicacaoResponse(EnviarLoteComunicacaoResponse value) {
        return new JAXBElement<EnviarLoteComunicacaoResponse>(_EnviarLoteComunicacaoResponse_QNAME, EnviarLoteComunicacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReciboLoteComunicacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "ReciboLoteComunicacao")
    public JAXBElement<ReciboLoteComunicacao> createReciboLoteComunicacao(ReciboLoteComunicacao value) {
        return new JAXBElement<ReciboLoteComunicacao>(_ReciboLoteComunicacao_QNAME, ReciboLoteComunicacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitaReciboEnvioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "SolicitaReciboEnvioResponse")
    public JAXBElement<SolicitaReciboEnvioResponse> createSolicitaReciboEnvioResponse(SolicitaReciboEnvioResponse value) {
        return new JAXBElement<SolicitaReciboEnvioResponse>(_SolicitaReciboEnvioResponse_QNAME, SolicitaReciboEnvioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarLoteComunicacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "CancelarLoteComunicacaoResponse")
    public JAXBElement<CancelarLoteComunicacaoResponse> createCancelarLoteComunicacaoResponse(CancelarLoteComunicacaoResponse value) {
        return new JAXBElement<CancelarLoteComunicacaoResponse>(_CancelarLoteComunicacaoResponse_QNAME, CancelarLoteComunicacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitaProtocoloComunicacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "SolicitaProtocoloComunicacao")
    public JAXBElement<SolicitaProtocoloComunicacao> createSolicitaProtocoloComunicacao(SolicitaProtocoloComunicacao value) {
        return new JAXBElement<SolicitaProtocoloComunicacao>(_SolicitaProtocoloComunicacao_QNAME, SolicitaProtocoloComunicacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetificarLoteComunicacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "RetificarLoteComunicacao")
    public JAXBElement<RetificarLoteComunicacao> createRetificarLoteComunicacao(RetificarLoteComunicacao value) {
        return new JAXBElement<RetificarLoteComunicacao>(_RetificarLoteComunicacao_QNAME, RetificarLoteComunicacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetificarLoteComunicacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gov.br/coaf/", name = "RetificarLoteComunicacaoResponse")
    public JAXBElement<RetificarLoteComunicacaoResponse> createRetificarLoteComunicacaoResponse(RetificarLoteComunicacaoResponse value) {
        return new JAXBElement<RetificarLoteComunicacaoResponse>(_RetificarLoteComunicacaoResponse_QNAME, RetificarLoteComunicacaoResponse.class, null, value);
    }

}
