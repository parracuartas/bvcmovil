package com.bvc.helper;

import com.bvc.configuracion.Configuracion;
import com.bvc.dto.CompraDTO;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Ofrece servicios para convertir instancias de
 * <code>CompraDTO</code> en documentos XML equivalentes y viceversa.
 *
 * @author xHANSx
 */
public class CompraHelper {

    /**
     * Devuelve un documento XML a partir de una instancia de
     * <code>CompraDTO</code> que contiene informacion sobre Compras.
     *
     * @param objetoVO La instancia de un Compra
     *
     * @return El documento XML que representa la informacion de un Compra
     */
    public static String getDocumento(CompraDTO objetoVO) throws Exception {
        Element rootElement = new Element("Compra");
        rootElement.addContent(getElemento(objetoVO));
        XMLOutputter salida = new XMLOutputter(Format.getCompactFormat().setEncoding(Configuracion.getInstancia().CODIFICACION));
        return salida.outputString(new Document(rootElement));
    }

    /**
     * Devuelve un documento XML a partir de una coleccion de instancias de
     * <code>CompraDTO</code> que contiene informacion sobre Compras.
     *
     * @param coleccionVOs Coleccion con instancias de Compras.
     *
     * @return El documento XML con la informaci�n de un Compra
     */
    public static String getDocumento(List<CompraDTO> coleccionVOs) throws Exception {
        Element rootElement = new Element("Compras");
        for (CompraDTO objeto : coleccionVOs) {
            rootElement.addContent(getElemento(objeto));
        }
        XMLOutputter salida = new XMLOutputter(Format.getCompactFormat().setEncoding(Configuracion.getInstancia().CODIFICACION));
        return salida.outputString(new Document(rootElement));
    }

    /**
     * Crea un elemento a partir de una instancia de
     * <code>CompraDTO</code>.
     *
     * @param objetoVO La instancia.
     *
     * @return El elemento.
     */
    private static Element getElemento(CompraDTO objetoVO) {
        Element elemento = new Element("Compra");
        elemento.setAttribute("compraId", objetoVO.getCompraId());
        if (objetoVO.getFechaInicial() != null) {
            elemento.setAttribute("fechaInicial", objetoVO.getFechaInicial().getTime() + "");
        }
        if (objetoVO.getFechaFinal() != null) {
            elemento.setAttribute("fechaFinal", objetoVO.getFechaFinal().getTime() + "");
        }
        elemento.setAttribute("cantidad", objetoVO.getCantidad() + "");
        elemento.setAttribute("valorUnidad", objetoVO.getValorUnidad() + "");
        elemento.setAttribute("porcentajeComision", objetoVO.getPorcentajeComision() + "");
        elemento.setAttribute("porcentajeImpuestos", objetoVO.getPorcentajeImpuestos() + "");
        elemento.setAttribute("gastos", objetoVO.getGastos() + "");
        elemento.setAttribute("observaciones", objetoVO.getObservaciones() + "");
        elemento.setAttribute("estado", objetoVO.getEstado() + "");
        elemento.setAttribute("accionId", objetoVO.getAccionId());
        elemento.setAttribute("portafolioId", objetoVO.getPortafolioId() + "");
        return elemento;
    }

    /**
     * Convierte una cadena que representa un XML en una coleccion de instancias
     * de
     * <code>CompraDTO</code>.
     *
     * @return La colecci�n de instancias de <code>CompraDTO</code>.
     */
    public static CompraDTO getInstancia(String cadenaXmlObjetos) throws Exception {
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
     * <code>CompraDTO</code>. Se supone que el documento contiene informacion
     * de un Compra.
     *
     * @return La instancia de <code>CompraDTO</code>.
     */
    private static CompraDTO getInstancia(Document documento) throws Exception {
        return getInstancia(documento.getRootElement().getChild("Compra"));
    }

    /**
     * Retorna una instancia de
     * <code>CompraDTO</code> dado un elemento de Compra.
     *
     * @param elemento El elemento del documento.
     *
     * @return La instancia de <code>CompraDTO</code>.
     */
    private static CompraDTO getInstancia(Element elemento) throws Exception {
        CompraDTO objetoVO = new CompraDTO();
        objetoVO.setCompraId(elemento.getAttributeValue("compraId"));
        if (elemento.getAttributeValue("fechaInicial") != null) {
            objetoVO.setFechaInicial(new Date(Long.parseLong(elemento.getAttributeValue("fechaInicial"))));
        }
        if (elemento.getAttributeValue("fechaFinal") != null) {
            objetoVO.setFechaFinal(new Date(Long.parseLong(elemento.getAttributeValue("fechaFinal"))));
        }
        objetoVO.setCantidad(Integer.parseInt(elemento.getAttributeValue("cantidad")));
        objetoVO.setValorUnidad(Float.parseFloat(elemento.getAttributeValue("valorUnidad")));
        objetoVO.setPorcentajeComision(Float.parseFloat(elemento.getAttributeValue("porcentajeComision")));
        objetoVO.setPorcentajeImpuestos(Float.parseFloat(elemento.getAttributeValue("porcentajeImpuestos")));
        objetoVO.setGastos(Float.parseFloat(elemento.getAttributeValue("gastos")));
        objetoVO.setObservaciones(elemento.getAttributeValue("observaciones"));
        objetoVO.setEstado(Integer.parseInt(elemento.getAttributeValue("estado")));
        objetoVO.setAccionId(elemento.getAttributeValue("accionId"));
        objetoVO.setPortafolioId(Integer.parseInt(elemento.getAttributeValue("portafolioId")));
        return objetoVO;
    }

    /**
     * Convierte una cadena que representa un XML en una coleccion de instancias
     * de
     * <code>CompraDTO</code>.
     *
     * @return La colecci�n de instancias de <code>CompraDTO</code>.
     */
    public static List<CompraDTO> getInstancias(String cadenaXmlObjetos) throws Exception {
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
     * <code>CompraDTO</code>.
     *
     * @return La colecci�n de instancias de <code>CompraDTO</code>.
     */
    private static List<CompraDTO> getInstancias(Document documento) throws Exception {
        List<CompraDTO> list = new ArrayList<CompraDTO>();
        List<Element> elementos = documento.getRootElement().getChildren("Compra");
        for (Element elemento : elementos) {
            list.add(getInstancia(elemento));
        }
        return list;
    }
}
