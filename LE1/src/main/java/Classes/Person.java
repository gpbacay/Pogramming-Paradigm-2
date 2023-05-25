/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Person {
    private int ID;
    private String LName, FName, MName, Address, Age, Sex;
   
    public Person() {
        this.ID = 000000;
        this.LName = "";
        this.FName = "";
        this.MName = "";
        this.Address = "";
        this.Age = "";
        this.Sex = "";
    }
   
    public Person(int ID, String LName, String FName, String MName, String Address, String Age, String Sex) {
        this.ID = ID;
        this.LName = LName;
        this.FName = FName;
        this.MName = MName;
        this.Address = Address;
        this.Age = Age;
        this.Sex = Sex;
    }
   
    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setLName(String LName) {
       this.LName = LName;
    }
    public void setFName(String FName) {
       this.FName = FName;
    }
    public void setMName(String MName) {
       this.MName = MName;
    }
    public void setAddress(String Address) {
       this.Address = Address;
    }
    public void setAge(String Age) {
        this.Age = Age;
    }
    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    //Getters
    public int getID() {
        return ID;
    }
    public String getLName() {
       return LName;
    }
    public String getFName() {
       return FName;
    }public String getMName() {
       return MName;
    }
    public String getAddress() {
       return Address;
    }
    public String getAge() {
        return Age;
    }
    public String getSex() {
        return Sex;
    }
    
    public String getCName() {
       String CName = LName + ", " + FName + " " + MName;
       return CName;
    }
}
