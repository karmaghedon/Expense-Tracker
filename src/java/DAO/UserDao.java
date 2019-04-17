/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBManagement.DbConnectionManagement;
import Interface.DAOInterface;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolaenastas
 */
public class UserDao implements DAOInterface<User>{

    public UserDao() {
    }
    

    @Override
    public void add(Connection con, User user) {
        try {
            //Connection con = DbConnectionManagement.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (userid,"
                                                        + "fname,lname,password,email) values(?,?,?,?,?)");
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getfName());
            ps.setString(3, user.getlName());
            ps.setString(4, user.getPassword1());
            ps.setString(5, user.geteMail());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> get(Connection con, int id) {
        return null;
    }
    
    public User getLogin(Connection con, String id, String password) {  
        User logIn = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement("Select userid, email,password From users "
                                                        + "WHERE email = ? AND password = ?" );
            ps.setString(1, id);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs != null && rs.next()){
                    String userId = rs.getString("userid");
                    String email = rs.getString("email");
                    String pswd = rs.getString("password");
                    logIn = new User();
                    logIn.setUserId(userId);
                    logIn.seteMail(email); 
                    logIn.setPassword1(pswd);
            }            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return logIn;
    }
    
    @Override
    public List<User> getAll(Connection con) {
       return null;
    }

    @Override
    public void delete(Connection con, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection con, int id, Date date, int amount, String methodPauyment, String comments) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
