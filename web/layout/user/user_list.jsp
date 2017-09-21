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
                    <p>User List</p>
                    <div class="btn_right"><s:a action="user_new" cssClass="btn">new</s:a></div>
                    </div>

                    <div class="bottom">
                        <div class="list-view">
                        <s:if test="%{userList.size()>0}">
                            <table class="tbl_list">
                                <thead>
                                <th>email</th>
                                <th>type</th>
                                <th>status</th>
                                <th class="fix-width">description</th>
                                <th><a class="btn" disabled>del</a></th>
                                </thead>
                                <tbody>
                                    <s:iterator value="userList" >
                                        <tr>
                                            <td><s:a action="user_detail">
                                                    <s:param name="id">
                                                        <s:property value="id"/>
                                                    </s:param>
                                                    <s:property value="email"/>
                                                </s:a>
                                            </td>
                                            <td><s:property value="type"/></td>
                                            <td><s:property value="status"/></td>
                                            <td class="fix-width"><s:property value="description"/></td>
                                            <td>
                                                <s:a action="user_delete" cssClass="btn">
                                                    <s:param name="id">
                                                        <s:property value="id"/>
                                                    </s:param>
                                                    del
                                                </s:a>
                                            </td>

                                            <%--<s:submit action="delete" value="del"/>--%>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                        </s:if>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
