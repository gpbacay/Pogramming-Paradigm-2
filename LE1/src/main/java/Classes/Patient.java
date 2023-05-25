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
    private String VaccineName, VaccineType, DateGiven, AdministeredBy, NextDoseDate, Allergies, Reactions;
    
    public Patient() {
        super();
        this.VaccineName = "";
        this.VaccineType = "";
        this.DateGiven = "";
        this.AdministeredBy = "";
        this.NextDoseDate = "";
        this.Allergies = "";
        this.Reactions = "";
    }
    
    public Patient(int ID, String LName, String FName, String MName, String Address, String Age, String Sex, String VaccineName, String VaccineType, String DateGiven, String AdministeredBy, String NextDoseDate, String Allergies, String Reactions) {
        super(ID, LName, FName, MName, Address, Age, Sex);
        this.VaccineName = VaccineName;
        this.VaccineType = VaccineType;
        this.DateGiven = DateGiven;
        this.AdministeredBy = AdministeredBy;
        this.NextDoseDate = NextDoseDate;
        this.Allergies = Allergies;
        this.Reactions = Reactions;
    }

    //Setters
    public void setVaccineName(String VaccineName) {
        this.VaccineName = VaccineName;
    }

    public void setVaccineType(String VaccineType) {
        this.VaccineType = VaccineType;
    }

    public void setDateGiven(String DateGiven) {
        this.DateGiven = DateGiven;
    }

    public void setAdministeredBy(String AdministeredBy) {
        this.AdministeredBy = AdministeredBy;
    }

    public void setNextDoseDate(String NextDoseDate) {
        this.NextDoseDate = NextDoseDate;
    }
    
    public void setAllergies(String Allergies) {
        this.Allergies = Allergies;
    }
    
    public void setReactions(String Reactions) {
        this.Reactions = Reactions;
    }
    
    
    //Getters

    public String getVaccineName() {
        return VaccineName;
    }

    public String getVaccineType() {
        return VaccineType;
    }

    public String getDateGiven() {
        return DateGiven;
    }

    public String getAdministeredBy() {
        return AdministeredBy;
    }

    public String getNextDoseDate() {
        return NextDoseDate;
    }
    
    public String getAllergies() {
        return Allergies;
    }
    
    public String getReactions() {
        return Reactions;
    }
}
