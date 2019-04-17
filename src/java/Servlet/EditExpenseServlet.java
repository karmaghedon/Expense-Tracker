/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.NewExpenseDao;
import DBManagement.DbConnectionManagement;
import Models.Expenses;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolaenastas
 */
public class EditExpenseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
            
        Cookie ck[] = request.getCookies();
        String userId = null;
        List<Expenses> expensesList = new ArrayList<>();
        for(Cookie cookie : ck){
            if(cookie.getName().equals("uname")){
                userId = cookie.getValue();
            }
        }
        
        try{
            int expenseId = Integer.parseInt(request.getParameter("expenseId"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("editDate"));
            int amount = Integer.parseInt(request.getParameter("editAmount"));
            String methodPaymewnt = request.getParameter("editMethod");
            String commnets = request.getParameter("editComments");
            //Expenses expens = request.getParameter(expense);
            
            DbConnectionManagement connection = new DbConnectionManagement(request);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            NewExpenseDao daoExpense= new NewExpenseDao();
            daoExpense.update(con, expenseId, date, amount, methodPaymewnt, commnets);
            expensesList = daoExpense.getAll(con);
            RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/MenuModels/ViewExpenses.jsp");
            request.setAttribute("expensesList",expensesList);
            dispatcher.forward(request, response);
        }      
        catch (ClassNotFoundException ex) {
            Logger.getLogger(AddExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
