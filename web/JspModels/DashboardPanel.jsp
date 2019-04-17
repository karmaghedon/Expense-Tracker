<%-- 
    Document   : DashboardPanel
    Created on : 6-Nov-2018, 12:34:19 PM
    Author     : nicolaenastas
--%>

<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<% 
    User logIn = (User) request.getAttribute("LogIn"); 
%>
<%
    String servletPath = request.getContextPath()+"/DashBoardServlet";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <c:import url = "HeaderFooter/HeaderAndFooter.jsp"/>
    </head>
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script>
       $(document).ready(function(){
        $('#displayExpenses__button').click(function(){
         $("#displayData").load("JspModel/MenuModels/ViewExpenses.jsp");
        });
       });
    </script>
    <body>
        <div id="header">
            <c:import url = "HeaderFooter/Header.jsp"/>
        </div>
        <div>
        
            <form action=<%=servletPath%> method="post" name = "DashBoard" style="display: flex; height: 600px">

                <div style="border: solid; width: 15%; height: 600px; display: inline-block">
                    <div align="center">
                    <table colspan="2" >
                    <tr align="center">
                        <td style="width: 100%; height: 50px">User Name</td>
                    </tr>
                    <tr>

                        <td align="center" style="width: 100%; height: 50px">   
                        <p><c:out value="${cookie['uname'].getValue()}" /></p></td>
                    </tr>
                    <tr>
                       <td align = "center">
                            <select name="UserMenu" style="width: 100%; height: 50px" >
                                <option>User Profile</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align = "center"><input style="width: 100%; height: 50px" type="submit" value="Add Expenses"
                          onclick="document.forms[0].action = 'JspModels/MenuModels/AddExpenses.jsp'; return true;"></td>                        
                    </tr>
                    <tr>
                        <td align = "center"><input id="displayExpenses__button" style="width: 100%; height: 50px" type="submit" name="homeButton" value="View Expenses"></td>                        
                    </tr>
                    <tr>
                        <td align = "center"><input style="width: 100%; height: 50px" type="submit" name="homeButton" value="Budget History "></td>
                    </tr>
                    <tr>
                        <td align = "center"><input style="width: 100%; height: 50px" type="submit" name="homeButton" value="Add Bill "></td>                        
                    </tr>
                    <tr>
                        <td align = "center"><input style="width: 100%; height: 50px" type="submit" name="homeButton" value="Delete Bill"></td>
                    </tr>
                    <tr>
                        <td align = "center"><input style="width: 100%; height: 50px" type="submit" name="homeButton" value="Track Report"></td>                        
                    </tr>
                    <tr>
                        <td align = "center"><input style="width: 100%; height: 50px" type="submit" name="homeButton" value="Settle up "></td>
                    </tr>
                </table>
                    </div>
                </div>     

            <div id="displayData" style="border: solid; width: 85%; height: 600px; display: inline-block">
                <table>
                    <c:if test="${switcher = 'abc'}">
                        <tr>                        
                         <td><jsp:include page="MenuModels/ViewExpenses.jsp" flush="true"></jsp:include></td>
                        </tr> 
                    </c:if>

                </table>
            </div>



            </form>
       
        </div>
         <div id="footer">
            <c:import url = "HeaderFooter/Footer.jsp"/>
        </div>
     </body>
</html>
