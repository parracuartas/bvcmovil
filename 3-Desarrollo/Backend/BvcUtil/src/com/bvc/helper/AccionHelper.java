package com.bvc.helper;

import com.bvc.configuracion.Configuracion;
import com.bvc.dto.AccionDTO;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Ofrece servicios para convertir instancias de <code>AccionDTO</code>
 * en documentos XML equivalentes y viceversa.
 *
 * @author xHANSx
 */
public class AccionHelper {

    /**
     * Devuelve un documento XML a partir de una instancia de
     * <code>AccionDTO</code> que contiene informacion sobre
     * Acciones.
     *
     * @param objetoVO La instancia de un Accion
     *
     * @return El documento XML que representa la informacion de un Accion
     */
    public static String getDocumento(AccionDTO objetoVO) throws Exception {
        Element rootElement = new Element("Accion");
        rootElement.addContent(getElemento(objetoVO));
        XMLOutputter salida = new XMLOutputter(Format.getCompactFormat().setEncoding(Configuracion.getInstancia().CODIFICACION));
        return salida.outputString(new Document(rootElement));
    }

    /**
     * Devuelve un documento XML a partir de una coleccion de instancias de
     * <code>AccionDTO</code> que contiene informacion sobre
     * Acciones.
     *
     * @param coleccionVOs Coleccion con instancias de Acciones.
     *
     * @return El documento XML con la informaci�n de un Accion
     */
    public static String getDocumento(List<AccionDTO> coleccionVOs) throws Exception {
        Element rootElement = new Element("Acciones");
        for (AccionDTO objeto : coleccionVOs) {
            rootElement.addContent(getElemento(objeto));
        }
        XMLOutputter salida = new XMLOutputter(Format.getCompactFormat().setEncoding(Configuracion.getInstancia().CODIFICACION));
        return salida.outputString(new Document(rootElement));
    }

    /**
     * Crea un elemento a partir de una instancia de
     * <code>AccionDTO</code>.
     *
     * @param objetoVO La instancia.
     *
     * @return El elemento.
     */
    private static Element getElemento(AccionDTO objetoVO) {
        Element elemento = new Element("Accion");
        if (objetoVO.getId() != null) {
            elemento.setAttribute("id", objetoVO.getId());
        }
        if (objetoVO.getNombre() != null) {
            elemento.setAttribute("nombre", objetoVO.getNombre());
        }
        elemento.setAttribute("valorActual", objetoVO.getValorActual() + "");
        elemento.setAttribute("cantidadCirculacion", objetoVO.getCantidadCirculacion() + "");
        return elemento;
    }

    /**
     * Convierte una cadena que representa un XML en una coleccion de
     * instancias de <code>AccionDTO</code>.
     *
     * @return La colecci�n de instancias de <code>AccionDTO</code>.
     */
    public static AccionDTO getInstancia(String cadenaXmlObjetos) throws Exception {
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
     * <code>AccionDTO</code>.
     * Se supone que el documento contiene informacion de un Accion.
     *
     * @return La instancia de <code>AccionDTO</code>.
     */
    private static AccionDTO getInstancia(Document documento) throws Exception {
        return getInstancia(documento.getRootElement().getChild("Accion"));
    }

    /**
     * Retorna una instancia de <code>AccionDTO</code> dado
     * un elemento de Accion.
     *
     * @param elemento El elemento del documento.
     *
     * @return La instancia de <code>AccionDTO</code>.
     */
    private static AccionDTO getInstancia(Element elemento) throws Exception {
        AccionDTO objetoVO = new AccionDTO();
        if (elemento.getAttributeValue("id") != null) {
            objetoVO.setId(elemento.getAttributeValue("id"));
        }
        if (elemento.getAttributeValue("nombre") != null) {
            objetoVO.setNombre(elemento.getAttributeValue("nombre"));
        }
        objetoVO.setValorActual(Float.parseFloat(elemento.getAttributeValue("valorActual")));
        objetoVO.setCantidadCirculacion(Integer.parseInt(elemento.getAttributeValue("cantidadCirculacion")));
        return objetoVO;
    }

    /**
     * Convierte una cadena que representa un XML en una coleccion de
     * instancias de <code>AccionDTO</code>.
     *
     * @return La colecci�n de instancias de <code>AccionDTO</code>.
     */
    public static List<AccionDTO> getInstancias(String cadenaXmlObjetos) throws Exception {
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
     * <code>AccionDTO</code>.
     *
     * @return La colecci�n de instancias de <code>AccionDTO</code>.
     */
    private static List<AccionDTO> getInstancias(Document documento) throws Exception {
        List<AccionDTO> list = new ArrayList<AccionDTO>();
        List<Element> elementos = documento.getRootElement().getChildren("Accion");
        for (Element elemento : elementos) {
            list.add(getInstancia(elemento));
        }
        return list;
    }
}
