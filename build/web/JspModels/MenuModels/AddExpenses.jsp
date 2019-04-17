<%-- 
    Document   : AddExpences
    Created on : 6-Nov-2018, 4:29:53 PM
    Author     : nicolaenastas
--%>

<%@page import="Models.Expenses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Expenses expense = (Expenses) request.getAttribute("expense");
%>
<%
    String servletPath = request.getContextPath()+"/AddExpenseServlet";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
         <%@include file = "../HeaderFooter/HeaderAndFooter.jsp" %>
    </head>
    <script type="text/javascript" src="jquery-1.3.2.min.js"></script>
            <script type="text/javascript">
        
        $(document).ready(function() {
            
            var max_fields      = 10; //maximum input boxes allowed
            var wrapper         = $(".input_fields_wrap"); //Fields wrapper
            var add_button      = $(".add_field_button"); //Add button ID

            var x = 1; //initlal text box count
            $(add_button).click(function(e){ //on add input button click
                e.preventDefault();
                if(x < max_fields){ //max input box allowed
                    x++; //text box increment
                    $(wrapper).append('<tr><td id = "row"><input type="text" id="date'+ x +'"name="date'+ x +'" maxlength="50"></td>\n\
                                       <td id = "row"><input type="text" id="amount'+x+'" name="amount'+ x +'" maxlength="50"></td>\n\
                                       <td id = "row"><input type="text" id="methodOfPayment'+x+'" name="methodOfPayment'+ x +'" maxlength="50"></td>\n\
                                       <td id = "row"><input type="text" id="comments'+x+'" name="comments'+ x +'" maxlength="50"></td></tr>\n\
                                       '); //add input box  <a href="#" class="remove_field">Remove</a>
                
            }});
            $(submitExpense).click(function (ex){
                $('#count').val(x);
                document.forms["expenseForm"].submit();
            });
          /*(  $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
                e.preventDefault(); $(this).parent('div').remove(); x--;
            });*/
        });       
    </script>
    <body>
        <div id="header">
            <c:import url = "../HeaderFooter/Header.jsp"/>
        </div>
        
        <form action=<%=servletPath%> method="post" name = "createExpense" id="expenseForm">
            <table class="input_fields_wrap">
                <tr>
                    <th id = "row">Date</th>
                    <th id = "row">Amount</th>
                    <th id = "row">Method of Payment</th>
                    <th id = "row">Comments</th>
                </tr>
                <tr>
                    <td id = "row"><input type="text" id="date1" name="date1" maxlength="50"></td>
                    <td id = "row"><input type="text" id="amount1" name="amount1" maxlength="50"></td>
                    <td id = "row"><input type="text" id="methodOfPayment1" name="methodOfPayment1" maxlength="50"></td>
                    <td id = "row"><input type="text" id="comments1" name="comments1" maxlength="50"></td>
                </tr>
            </table>
            <input type="button" name="submitExpense" value="Submit Expense" id="submitExpense">
            <input type="hidden" name="tableCount" id="count">
            <input type="submit" class="add_field_button" value="Add More Fields">
            <input type="submit" name="back" value="Back">
            
        </form>
         <div id="footer">
            <c:import url = "../HeaderFooter/Footer.jsp"/>
        </div>
    </body>

</html>
