/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManagement;


import Servlet.MainServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author nicolaenastas
 */
public class DbConnectionManagement {
    private Connection connection;
   
    public DbConnectionManagement(HttpServletRequest request) throws ClassNotFoundException, SQLException, 
                            InstantiationException, IllegalAccessException{
                 

          Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
           
                ServletContext  cxt = request.getServletContext();
                String dbURL = cxt.getInitParameter("dbURL");
                String dbUser = cxt.getInitParameter("dbUser");
                String dbPassword = cxt.getInitParameter("dbPassword");
                this.connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
               // DbConnectionManagement connection = new DbConnectionManagement(dbURL, dbUser, dbPassword);
                cxt.setAttribute("DBConnection", connection);

    }
    
}
