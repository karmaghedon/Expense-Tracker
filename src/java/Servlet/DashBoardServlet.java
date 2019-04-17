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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolaenastas
 */
public class DashBoardServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String menuButton = request.getParameter("homeButton"); 
        
        switch(menuButton){
            case "View Expenses":{
                List<Expenses> expensesList = new ArrayList<>();
                try {
                    request.setAttribute("switcher", "abc");
                    DbConnectionManagement connection = new DbConnectionManagement(request);
                    Connection con = (Connection) getServletContext().getAttribute("DBConnection");
                    NewExpenseDao expenses = new NewExpenseDao();
                    expensesList = expenses.getAll(con);
                    RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/MenuModels/ViewExpenses.jsp");
                    request.setAttribute("expensesList", expensesList);
                    dispatcher.forward(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            }
            case "Budget History":{
                String expensesList = null;
                
                RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/MenuModels/BudgetHistory.jsp");
                request.setAttribute("expensesList", expensesList);
                dispatcher.forward(request, response);
            }
                
        }

        
//            if(request.getParameter("viewExpenses") != null){
//            List<Expenses> expensesList = new ArrayList<>();
//            try {
//                DbConnectionManagement connection = new DbConnectionManagement(request);
//                Connection con = (Connection) getServletContext().getAttribute("DBConnection");
//                NewExpenseDao expenses = new NewExpenseDao();
//                expensesList = expenses.getAll(con);
//                RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/MenuModels/ViewExpenses.jsp");
//                request.setAttribute("expensesList", expensesList);
//                dispatcher.forward(request, response);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }else if(request.getParameter("button2") != null){
//        String expensesList = null;
//        request.setAttribute("switcher", "abc");
//                RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/MenuModels/BudgetHistory.jsp");
//                request.setAttribute("expensesList", expensesList);
//                dispatcher.forward(request, response);
//    }
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
