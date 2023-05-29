/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class HealthWorker extends Person{
    private static String password;
    
    public HealthWorker() {
        super();
        HealthWorker.password = "";
    }
    
    public HealthWorker(int ID, String Name, String Address, String Age, String Sex, String password) {
        super(ID, Name, Address, Age, Sex);
        HealthWorker.password = password;
    }

    public void setPassword(String password) {
        HealthWorker.password = password;
    }

    public String getPassword() {
        return password;
    }
}
