/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.DAOInterface;
import Models.Expenses;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolaenastas
 */
public class NewExpenseDao implements DAOInterface<Expenses>{
    
    @Override
    public void add(Connection con, Expenses user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public void addList(Connection con, List<Expenses> addExpensList, String userId) {
        PreparedStatement ps = null;
       // "(SELECT MAX(userid) from users WHERE email = ?)
        try {
             ps = con.prepareStatement("INSERT INTO expenses (userid, expensedate,"
                                       + "amount,methodPayment,comments) values( ? , ?, ?, ?, ?)");
            for(Expenses expense: addExpensList){
                
           
            ps.setString(1, userId);
            ps.setDate(2, new java.sql.Date(expense.getDate().getTime()));
            ps.setInt(3, expense.getAmount());
            ps.setString(4, expense.getMethodPayment());
            ps.setString(5, expense.getComments());
            ps.addBatch();
            
            }
            if(ps != null){
             ps.executeBatch();
             ps.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Expenses> get(Connection con, int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Expenses expense;
        List<Expenses> expenseList = new ArrayList<Expenses>();
        try {           
            ps = con.prepareStatement("SELECT * FROM expenses Where expenseid = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    expense = new Expenses();
                    expense.setiD(rs.getInt("expenseid"));
                    expense.setDate(rs.getDate("expensedate"));
                    expense.setAmount(rs.getInt("amount"));         
                    expense.setMethodPayment(rs.getString("methodPayment"));
                    expense.setComments(rs.getString("comments"));
                    
                    expenseList.add(expense);
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewExpenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return expenseList;
    }

    @Override
    public List<Expenses> getAll(Connection con) {
        PreparedStatement ps = null;
        ResultSet rs = null;
                    Expenses expense;
            List<Expenses> expenseList = new ArrayList<Expenses>();
        try {           
            ps = con.prepareStatement("SELECT * FROM expenses ");
            rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    expense = new Expenses();
                    expense.setiD(rs.getInt("expenseid"));
                    expense.setDate(rs.getDate("expensedate"));
                    expense.setAmount(rs.getInt("amount"));         
                    expense.setMethodPayment(rs.getString("methodPayment"));
                    expense.setComments(rs.getString("comments"));
                    
                    expenseList.add(expense);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewExpenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return expenseList;
    }
    @Override
    public void update(Connection con, int id, Date date, int amount, String methodPauyment, String comments) {
        PreparedStatement ps;
        ResultSet rs = null;
        Expenses expense;
        List<Expenses> expenseList = new ArrayList<Expenses>();
        try {
            ps = con.prepareStatement("Update expenses Set expensedate = ?, amount = ?, methodPayment = ?,"
            +"comments = ? Where expenseid = ?");
            ps.setDate(1, new java.sql.Date(date.getTime()));
           // ps.setDate(1, (java.sql.Date) date);
            ps.setInt(2, amount);
            ps.setString(3, methodPauyment);
            ps.setString(4,comments);
            ps.setInt(5, id);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewExpenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }      
    
    }
    

    @Override
    public void delete(Connection con, int id) {
        PreparedStatement ps;
        ResultSet rs = null;
        try{
             ps = con.prepareStatement("Delete FROM expenses "
                                        +"WHERE expenseid = ?");
             ps.setInt(1, id);
             ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewExpenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }




    
}
