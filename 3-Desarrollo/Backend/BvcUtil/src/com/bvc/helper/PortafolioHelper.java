package com.bvc.helper;

import com.bvc.configuracion.Configuracion;
import com.bvc.dto.PortafolioDTO;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Ofrece servicios para convertir instancias de
 * <code>PortafolioDTO</code> en documentos XML equivalentes y viceversa.
 *
 * @author xHANSx
 */
public class PortafolioHelper {

    /**
     * Devuelve un documento XML a partir de una instancia de
     * <code>PortafolioDTO</code> que contiene informacion sobre Portafolios.
     *
     * @param objetoVO La instancia de un Portafolio
     *
     * @return El documento XML que representa la informacion de un Portafolio
     */
    public static String getDocumento(PortafolioDTO objetoVO) throws Exception {
        Element rootElement = new Element("Portafolio");
        rootElement.addContent(getElemento(objetoVO));
        XMLOutputter salida = new XMLOutputter(Format.getCompactFormat().setEncoding(Configuracion.getInstancia().CODIFICACION));
        return salida.outputString(new Document(rootElement));
    }

    /**
     * Devuelve un documento XML a partir de una coleccion de instancias de
     * <code>PortafolioDTO</code> que contiene informacion sobre Portafolios.
     *
     * @param coleccionVOs Coleccion con instancias de Portafolios.
     *
     * @return El documento XML con la informaci�n de un Portafolio
     */
    public static String getDocumento(List<PortafolioDTO> coleccionVOs) throws Exception {
        Element rootElement = new Element("Portafolios");
        for (PortafolioDTO objeto : coleccionVOs) {
            rootElement.addContent(getElemento(objeto));
        }
        XMLOutputter salida = new XMLOutputter(Format.getCompactFormat().setEncoding(Configuracion.getInstancia().CODIFICACION));
        return salida.outputString(new Document(rootElement));
    }

    /**
     * Crea un elemento a partir de una instancia de
     * <code>PortafolioDTO</code>.
     *
     * @param objetoVO La instancia.
     *
     * @return El elemento.
     */
    private static Element getElemento(PortafolioDTO objetoVO) {
        Element elemento = new Element("Portafolio");
        if (objetoVO.getId() != null) {
            elemento.setAttribute("id", objetoVO.getId());
        }
        if (objetoVO.getNombre() != null) {
            elemento.setAttribute("nombre", objetoVO.getNombre());
        }
        elemento.setAttribute("saldo", objetoVO.getSaldo() + "");
        elemento.setAttribute("inversionista", objetoVO.getInversionista());
        return elemento;
    }

    /**
     * Convierte una cadena que representa un XML en una coleccion de instancias
     * de
     * <code>PortafolioDTO</code>.
     *
     * @return La colecci�n de instancias de <code>PortafolioDTO</code>.
     */
    public static PortafolioDTO getInstancia(String cadenaXmlObjetos) throws Exception {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document documento = builder.build(new StringReader(cadenaXmlObjetos));
            return getInstancia(documento);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Convierte un documento XML en una instancia de
     * <code>PortafolioDTO</code>. Se supone que el documento contiene
     * informacion de un Portafolio.
     *
     * @return La instancia de <code>PortafolioDTO</code>.
     */
    private static PortafolioDTO getInstancia(Document documento) throws Exception {
        return getInstancia(documento.getRootElement().getChild("Portafolio"));
    }

    /**
     * Retorna una instancia de
     * <code>PortafolioDTO</code> dado un elemento de Portafolio.
     *
     * @param elemento El elemento del documento.
     *
     * @return La instancia de <code>PortafolioDTO</code>.
     */
    private static PortafolioDTO getInstancia(Element elemento) throws Exception {
        PortafolioDTO objetoVO = new PortafolioDTO();
        if (elemento.getAttributeValue("id") != null) {
            objetoVO.setId(elemento.getAttributeValue("id"));
        }
        if (elemento.getAttributeValue("nombre") != null) {
            objetoVO.setNombre(elemento.getAttributeValue("nombre"));
        }
        objetoVO.setSaldo(Float.parseFloat(elemento.getAttributeValue("saldo")));
        objetoVO.setInversionista(elemento.getAttributeValue("inversionista"));
        return objetoVO;
    }

    /**
     * Convierte una cadena que representa un XML en una coleccion de instancias
     * de
     * <code>PortafolioDTO</code>.
     *
     * @return La colecci�n de instancias de <code>PortafolioDTO</code>.
     */
    public static List<PortafolioDTO> getInstancias(String cadenaXmlObjetos) throws Exception {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document documento = builder.build(new StringReader(cadenaXmlObjetos));
            return getInstancias(documento);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Convierte un documento XML en una coleccion de instancias de
     * <code>PortafolioDTO</code>.
     *
     * @return La colecci�n de instancias de <code>PortafolioDTO</code>.
     */
    private static List<PortafolioDTO> getInstancias(Document documento) throws Exception {
        List<PortafolioDTO> list = new ArrayList<PortafolioDTO>();
        List<Element> elementos = documento.getRootElement().getChildren("Portafolio");
        for (Element elemento : elementos) {
            list.add(getInstancia(elemento));
        }
        return list;
    }
}
