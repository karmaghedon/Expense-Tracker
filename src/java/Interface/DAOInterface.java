/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.User;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nicolaenastas
 */
public interface DAOInterface<T> {
    
    public void add(Connection con, T user);
        
    public List<T> get(Connection con, int id);

    public List<T>getAll(Connection con);

    public void update(Connection con, int id, Date date, int amount, 
                            String methodPauyment, String comments);
    
    public void delete(Connection con, int id);
        
    
        
    
    
}
