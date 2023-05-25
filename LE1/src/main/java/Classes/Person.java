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
    private String Name, Address, Age, Sex;
   
    public Person() {
        this.ID = 000000;
        this.Name = "";
        this.Address = "";
        this.Age = "";
        this.Sex = "";
    }
   
    public Person(int ID, String Name, String Address, String Age, String Sex) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Age = Age;
        this.Sex = Sex;
    }
   
    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String Name) {
       this.Name = Name;
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
    public String getName() {
       return Name;
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
}
