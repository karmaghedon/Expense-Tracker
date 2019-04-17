<%-- 
    Document   : ViewExpenses
    Created on : 6-Nov-2018, 3:45:03 PM
    Author     : nicolaenastas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Models.Expenses"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String servletPath = request.getContextPath()+"/ViewExpenseServlet";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        
    </head>
    <script>
        //  $(document).ready(function () {
            
//            function editClick().click(function (ex) {
//                document.forms[0].action = "expenseId";
//                document.forms[0].submit();
//         });
         
         
             function editClick(){
               //  alarm($('#expenseId').val());
               // val exp =  $('#expenseId').val();
               
                document.forms["ViewExpenses"].submit();
                
            }

  //});
    </script>
    <body>
        <%@include file = "../HeaderFooter/HeaderAndFooter.jsp" %>
                      <div id="header">
            <c:import url = "../HeaderFooter/Header.jsp"/>
        </div>
        <form action=<%=servletPath%> method="post" name = "ViewExpenses">
            <table>
                <tr>
                    <th id = "row">Date</th>
                    <th id = "row">Amount</th>
                    <th id = "row">Method of Payment</th>
                    <th id = "row">Comments</th>
                    <th id="row">Edit</th>
                    <th id="row">Delete</th>
                </tr>
               
                    
                    <c:forEach var = "expense" items = "${expensesList}" varStatus = "index">
                        <input type="hidden" name="expenseId${index.index}" value="${expense.iD}">
                        <input type="hidden" name="date${index.index}" value="${expense.date}">
                        <input type="hidden" name="amount${index.index}" value="${expense.amount}">
                        <input type="hidden" name="methodPayment${index.index}" value="${expense.methodPayment}">
                        <input type="hidden" name="comments${index.index}" value="${expense.comments}">
                         <tr>
                            <td id = "row">${expense.date}</td>
                            <td id = "row">${expense.amount}</td>
                            <td id = "row">${expense.methodPayment}</td>
                            <td id = "row">${expense.comments}</td>
                            <td id = "row">
                                <input type="submit" name="editExpense${index.index}" value="Edit" id="editExpense${index.index}">
                            <input type="hidden" name="expenseId" value="${expense.iD}" id="expenseId">
                        </td>
                        <td id = "row">
                                <input type="submit" name="deleteExpense${index.index}" value="Delete" id="deleteExpense${index.index}">
                            
                        </td>
                        </tr>
                    </c:forEach>
                <input type="submit" name="back" value="Back">
            </table>
                             <div id="footer">
            <c:import url = "../HeaderFooter/Footer.jsp"/>
        </div>
        </form>
    </body>
</html>
