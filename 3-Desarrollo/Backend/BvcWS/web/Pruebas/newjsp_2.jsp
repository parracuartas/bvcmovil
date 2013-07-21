<%-- 
    Document   : index
    Created on : 17-nov-2012, 20:02:15
    Author     : HansO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    <script src="jquery.min.js"></script>
    <script>
    
        var webServiceURL = 'http://localhost:8080/BvcWS/MovilWS';
    
        var soapMessage =
            "<?xml version='1.0' encoding='UTF-8'?>" +
            "<S:Envelope xmlns:S='http://schemas.xmlsoap.org/soap/envelope/'>" +
            "<S:Header/>" +
            "<S:Body>" +
            "<ns2:crearOrdenCompra xmlns:ns2='http://ws.bvc.com/'>" +
            " <compraId>COM001</compraId>" +
            " <fechaInicial>1332306000000</fechaInicial>" +
            " <fechaFinal>1332306000000</fechaFinal>" +
            " <cantidad>10</cantidad>" +
            " <valorUnidad>500</valorUnidad>" +
            " <porcentajeComision>4.0</porcentajeComision>" +
            " <porcentajeImpuestos>16.0</porcentajeImpuestos>" +
            " <gastos>15000</gastos>" +
            " <observaciones>Esto es una prueba</observaciones>" +
            " <accionId>1</accionId>" +
            " <portafolioId>1</portafolioId>" +
            "</ns2:crearOrdenCompra>" +
            "</S:Body>" +
            "</S:Envelope>";

        function CallService() {
            $.ajax({
                url: webServiceURL,
                type: "POST",
                dataType: "xml",
                data: soapMessage,
                contentType: "text/xml; charset=\"utf-8\"",
                complete: OnSuccess,
                error: OnError
            });

            return false;
        }

        function OnSuccess(xmlHttpRequest, status) {
            var sys_id = $(xmlHttpRequest.responseXML).text();
            alert(sys_id)
        }

        function OnError(request, status, error) {
            alert(status);
        }

        $(document).ready(function () {
            jQuery.support.cors = true;
        });

        CallService();
    
    </script>
</html>