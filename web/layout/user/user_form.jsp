<%-- 
    Document   : user_list
    Created on : Sep 21, 2017, 10:13:49 AM
    Author     : Admin
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OP Myanmar | User</title>
        <link href="<%=request.getContextPath()%>/resources/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="left">
                <%@include file="../common/menu.jsp"%>
            </div>

            <div class="right-side">
                <div class="top">
                    <p>User add / update</p>
                </div>
                <div class="bottom">
                    <s:form action="user_save" method="post">
                        <s:hidden name="update_flag"/>
                        <s:hidden name="user.id"/>
                        <s:textfield name="user.email" label="e-mail"/>
                        <s:textfield name="user.password" label="pass"/><br/>

                        <s:select name="user.type" list="{'admin','user'}" label="type"/>
                        <s:select name="user.status" list="{'active','noactive'}" label="status"/>

                        <s:textarea name="user.description" label="description"></s:textarea>
                        <div class="btn_group">
                        <s:submit cssClass="btn-left"  value="up"/>
                        <s:submit action="delete" cssClass="btn-right" value="del"/>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>
    </body>
</html>