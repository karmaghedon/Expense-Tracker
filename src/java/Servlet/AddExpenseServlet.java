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
public class AddExpenseServlet extends HttpServlet {

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
            List<Expenses> addExpensList = new ArrayList<>();    
        Expenses expense = null;
        Cookie ck[] = request.getCookies();
        String userId = null;
        for(Cookie cookie : ck){
            if(cookie.getName().equals("uname")){
                userId = cookie.getValue();
            }
        }
        
                if(request.getParameter("back") != null){
             RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/DashboardPanel.jsp");

                dispatcher.forward(request, response);
        }
        
        
        try {
            int count = Integer.parseInt(request.getParameter("tableCount"));
            for(int i = 0; i < count; i++){
                String par1 = String.format("%s%d", "date",i+1);
                String par2 = String.format("%s%d", "amount",i+1);
                String par3 = String.format("%s%d", "methodOfPayment",i+1);
                String par4 = String.format("%s%d", "comments",i+1);
                Date date = null;
                try{
                 date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter(par1));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                expense = new Expenses(date,
                        Integer.parseInt(request.getParameter(par2)),
                        String.valueOf(request.getParameter(par3)),
                        String.valueOf(request.getParameter(par4)));
                addExpensList.add(expense);
            }
            DbConnectionManagement connection = new DbConnectionManagement(request);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            NewExpenseDao daoExpense= new NewExpenseDao();
            daoExpense.addList(con, addExpensList, userId);
            RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/DashboardPanel.jsp");
            // srequest.setAttribute("expense",expense);
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
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
            Logger.getLogger(AddExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddExpenseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
