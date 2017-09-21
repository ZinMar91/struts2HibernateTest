<%-- 
    Document   : index
    Created on : Sep 21, 2017, 9:17:57 AM
    Author     : Admin
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OP Myanmar | Login</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h5>Login</h5>

        <s:form action="action" method="post">
            <s:textfield name="email" label="e-mail"/>
            <s:textfield name="password" label="e-mail"/>
            <s:submit value="Login"/>
        </s:form>
</body>
</html>
