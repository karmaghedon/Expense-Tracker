<%-- 
    Document   : LogIn
    Created on : 6-Nov-2018, 12:21:27 PM
    Author     : nicolaenastas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url = "HeaderFooter/HeaderAndFooter.jsp"/>
        <%
             String servletPath = request.getContextPath()+"/MainServlet";
        %>
        
    </head>
    <body>
    <div id="header">
        <c:import url = "HeaderFooter/Header.jsp"/>
    </div>
    <div>
    <form action=<%=servletPath%> method="post" name = "logInForm">
        <h1>Expense Tracker</h1> 
        
        <div>
            <input type="submit" value="Create New User"
                   onclick="document.forms[0].action = 'JspModels/NewUser.jsp'; return true;">                       
        </div>
    
        <center>
        <div>
            <table id="logInTable">
                    <tr>
                        <td><h2>Sign-up Details</h2> </td>
                    </tr>
                    <tr>
                        <td>Username:<input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>Password:<input type="password" name="password"></td>
                    </tr>
                    <tr  align="center">
                        <td><input type="submit" name ="submit" value="Submit"></td>                                                
                    </tr>

                </table>
        </div>
        </center>
    </form>
    </div>
    <div id="footer">
        <c:import url = "HeaderFooter/Footer.jsp"/>
    </div>
</body>
</html>
