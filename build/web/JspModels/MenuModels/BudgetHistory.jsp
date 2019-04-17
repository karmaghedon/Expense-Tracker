<%-- 
    Document   : BudgetHistory
    Created on : 15-Nov-2018, 1:54:02 PM
    Author     : nicolaenastas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Models.Expenses"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String servletPath = request.getContextPath()+"/DashBoardServlet";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<%=servletPath%>" method="post" name="budgetHistory">
            <input type="date" name="dateSelect">
            <input type="submit" name="retrieve" value="Retrieve">
        </form>
    </body>
</html>
