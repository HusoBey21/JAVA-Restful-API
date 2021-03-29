<%-- 
    Document   : index
    Created on : 27 Mar 2021, 21:11:16
    Author     : huseyin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Kayıt Tamamlandı</h1>
    <jsp:useBean id="Yeni" scope="session" class="com.mycompany.huseyincansimsek.kisi"/>
    <jsp:setProperty name="Yeni" property="ad" param="Adı"/>
    
    Merhaba
    <jsp:getProperty name="Yeni" property="ad"/>
</body>
</html>
