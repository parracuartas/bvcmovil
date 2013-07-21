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
        "<ns2:obtenerAcciones xmlns:ns2='http://ws.bvc.com/'/>" +
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