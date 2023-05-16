public class Person
{
   private String FName, LName, CName, identification, address;
   
   Person() {
      this.FName = "";
      this.LName = "";
      this.identification = "";
      this.address = "";
   }
   
   Person(String FName, String LName, String Identification, String address) {
      this.FName = FName;
      this.LName = LName;
      this.identification = identification;
      this.address = address;
   }
   
   //Setters
   public void setFName(String FName) {
      this.FName = FName;
   }
   public void setLName(String LName) {
      this.LName = LName;
   }
   public void setID(String identification) {
      this.identification = identification;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   
   //Getters
   public String getFName() {
      return FName;
   }
   public String getLName() {
      return LName;
   }
   public String getID() {
      return identification;
   }
   public String getAddress() {
      return address;
   }
   public String toString() {
      CName = FName + " " + LName;
      return CName;
   }
}