package TASK4_BACAY;

public class Patient {
    private String FName, LName, CName, Address, Age, Sex;
   
    //constructors
    public Patient() {
        FName = " ";
        LName = " ";
        CName = FName + " " + LName;
        Address = " ";
        Age = " ";
        Sex = " ";
    }
   
    public Patient(String FName, String LName, String Address, String Age, String Sex) {
        this.FName = FName;
        this.LName = LName;
        this.Address = Address;
        this.Age = Age;
        this.Sex = Sex;
    }
   
    public Patient(Patient copy) {
        this.FName = copy.FName;
        this.LName = copy.LName;
        this.Address = copy.Address;
        this.Age = copy.Age;
        this.Sex = copy.Sex;
    }
   
    //setters
    public void setFName(String FName) {
        this.FName = FName;
    }
    public void setLName(String LName) {
        this.LName = LName;
    }
    public String generateCName() {
        CName = FName + " " + LName;
        return CName;
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
   
    //getters
    public String getFName() {
        return FName;
    }
    public String getLName() {
        return LName;
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
        return CName;
    }
}
