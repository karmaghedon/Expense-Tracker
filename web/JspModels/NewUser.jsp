<%-- 
    Document   : NewUser
    Created on : 7-Nov-2018, 2:12:10 PM
    Author     : nicolaenastas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
             String servletPath = request.getContextPath()+"/NewUserServlet";
        %>
        <title>JSP Page</title>
        <c:import url = "HeaderFooter/HeaderAndFooter.jsp"/>
    </head>
    <body>
    <div id="header">
        <c:import url = "HeaderFooter/Header.jsp"/>
    </div>
    <div>
        <form action=<%=servletPath%> method="post" name = "createUser">
            <table style="border: solid">
                <tr>
                    <td><h2>Create Account</h2></td>
                </tr>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="fName" required="true" ></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lName" required="true" ></td>
                </tr>
                <tr>
                    <td>User Id: </td>
                    <td><input type="text" name="userId" required="true" ></td>
                </tr>
                <tr>
                    <td>E-Mail Address: </td>
                    <td><input type="text" name="eMail" required="true" ></td>
                </tr>  
                <tr>
                    <td>Password: </td>
                    <td><input type="text" name="password1" required="true" ></td>
                </tr> 
                <tr>
                    <td>Retype Password: </td>
                    <td><input type="text" name="password2" required="true" ></td>
                </tr> 
                <tr>
                    <td ><input type="submit" name="newUser" value="Submit" 
                         ></td>
                </tr>
            </table>
            <a href="LogIn.jsp"> Return to Sign-In Page</a>
        </form>
    </div>
    <div id="footer">
        <c:import url = "HeaderFooter/Footer.jsp"/>
    </div>
    </body>
</html>
