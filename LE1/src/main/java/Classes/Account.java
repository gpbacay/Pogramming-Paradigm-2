/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Account {
    private static String ID, password, name;
    
    public Account() {
        Account.ID = "";
        Account.password = "";
        Account.name = "";
    }
    
    public Account(String ID, String password, String name) {
        Account.ID = ID;
        Account.password = password;
        Account.name = name;
    }

    public void setID(String ID) {
        Account.ID = ID;
    }

    public void setPassword(String password) {
        Account.password = password;
    }
    
    public void setName(String name) {
        Account.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }  
    public String getName() {
        return name;
    }
}
