/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author nicolaenastas
 */
public class User {
    private String fName;
    private String lName;
    private String userId;
    private String eMail;
    private String password1;
    private String password2;

    public User() {
    }

    public User(String eMail, String password1) {
        this.eMail = eMail;
        this.password1 = password1;
    }

    
    public User(String fName, String lName, String userId, String eMail, String password1, String password2) {
        this.fName = fName;
        this.lName = lName;
        this.userId = userId;
        this.eMail = eMail;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    
    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    

    @Override
    public String toString() {
        return  fName + " " + lName;
    }
    
    
}
