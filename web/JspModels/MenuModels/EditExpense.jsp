<%-- 
    Document   : EditExpense
    Created on : 3-Dec-2018, 1:28:34 PM
    Author     : nicolaenastas
--%>

<%@page import="java.util.List"%>
<%@page import="Models.Expenses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String servletPath = request.getContextPath()+"/EditExpenseServlet";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "../HeaderFooter/HeaderAndFooter.jsp" %>
    </head>
    <body>
                <div id="header">
            <c:import url = "../HeaderFooter/Header.jsp"/>
        </div>
                <form action=<%=servletPath%> method="post" name = "EditExpenses">
             <table>
                <tr>
                    <th id = "row">Date</th>
                    <th id = "row">Amount</th>
                    <th id = "row">Method of Payment</th>
                    <th id = "row">Comments</th>
                </tr>
               
                    
                    <c:forEach var = "expense" items = "${expensesList}" varStatus = "index">
                        <input type="hidden" name="expenseId" value="${expense.iD}">
                         <tr>
                             <td id = "row"><input type="text" name="editDate"  value="${expense.date}"/></td>
                            <td id = "row"><input type="text" name="editAmount" value="${expense.amount}"/></td>
                            <td id = "row"><input type="text" name="editMethod" value="${expense.methodPayment}"/></td>
                            <td id = "row"><input type="text" name="editComments" value="${expense.comments}"/></td>
                        </tr>
                    </c:forEach>
                
            </table>
            <input type="submit" name="submitExpense" value="Update" id="submitExpense">
            <input type="hidden" name="expenseId" value="${expense.iD}" id="expenseId">
        </form>
                 <div id="footer">
            <c:import url = "../HeaderFooter/Footer.jsp"/>
        </div>
    </body>
</html>
