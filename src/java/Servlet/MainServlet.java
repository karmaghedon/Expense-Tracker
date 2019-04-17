/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UserDao;
import DAO.NewExpenseDao;
import DBManagement.DbConnectionManagement;
import Models.Expenses;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolaenastas
 */
public class MainServlet extends HttpServlet {

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
        User user;
        try{
            
            
            //if(request.getParameter("submit") != null){
               // connection();
               response.setContentType("text/html");
               DbConnectionManagement connection = new DbConnectionManagement(request);
                Connection con = (Connection) getServletContext().getAttribute("DBConnection");
         //       User logIn = new User(String.valueOf(request.getParameter("username")),
         //                                         String.valueOf(request.getParameter("password")) );
            UserDao userDao = new UserDao();
            User logIn =  userDao.getLogin(con,request.getParameter("username"), request.getParameter("password"));
 
                            
           // PrintWriter out = response.getWriter();  
           if(logIn != null){
                           String n= logIn.getUserId();   
            Cookie ck=new Cookie("uname",URLEncoder.encode(n, "UTF-8"));//creating cookie object  
            response.addCookie(ck);//adding cookie in the response
                
                //User logIn = new User();
                RequestDispatcher dispatcher=request.getRequestDispatcher("JspModels/DashboardPanel.jsp");
                request.setAttribute("LogIn",logIn);
                dispatcher.forward(request, response);
           }else{
               PrintWriter write = response.getWriter();
               String errorMsg = "Authorisation Failed";
               //write.println("<font color=red>"+errorMsg+"</font>");
               write.println("<script type = \"text/javascript\">");
               write.println("alert('User or Password incorrect');");
               write.println("location = 'JspModels/LogIn.jsp';");
               write.println("</script>");
               
               
               
               // getServletContext().getRequestDispatcher("JspModels/LogIn.jsp").forward(request, response);
           }
           

            //}
        }catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
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

//        public void connection() throws ClassNotFoundException, SQLException, 
//                            InstantiationException, IllegalAccessException{
//                                ServletContext  cxt = getServletContext();
//                String dbURL = cxt.getInitParameter("dbURL");
//                String dbUser = cxt.getInitParameter("dbUser");
//                String dbPassword = cxt.getInitParameter("dbPassword");
//                
//                DbConnectionManagement connection = new DbConnectionManagement(dbURL, dbUser, dbPassword);
//                cxt.setAttribute("DBConnection", connection.getConnection());
//
//    }

    
}
