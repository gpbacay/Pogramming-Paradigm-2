/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Patient extends Person{
    private String Height, Weight, vaccineStatus, vaccineName;
    
    public Patient() {
        super();
        this.Height = "";
        this.Weight = "";
        this.vaccineStatus = "";
        this.vaccineName = "";
    }
    
    Patient(int ID, String LName, String FName, String MName, String Address, String Age, String Sex, String Height, String Weight, String vaccineStatus, String vaccineName) {
        super(ID, LName, FName, MName, Address, Age, Sex);
        this.Height = Height;
        this.Weight = Weight;
        this.vaccineStatus = vaccineStatus;
        this.vaccineName = vaccineName;
    }
    
    //Setters
    public void setHeight(String Height) {
        this.Height = Height;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    public void setVaccineStatus(String vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    
    //Getters

    public String getHeight() {
        return Height;
    }

    public String getWeight() {
        return Weight;
    }

    public String getVaccineStatus() {
        return vaccineStatus;
    }

    public String getVaccineName() {
        return vaccineName;
    }
    
    
}
