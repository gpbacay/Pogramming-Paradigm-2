public class Person {
   private String FName, LName, CName, Address;
   
   //constructors
   public Person() {
      FName = " ";
      LName = " ";
      Address = " ";
   }
   
   public Person(String FName, String LName, String Address) {
      this.FName = FName;
      this.LName = LName;
      this.Address = Address;
   }
   
   public Person(Person copy) {
      this.FName = copy.FName;
      this.LName = copy.LName;
      this.Address = copy.Address;
   }
   
   
   //setters
   public void setFName(String FName) {
      this.FName = FName;
   }
   public void setLName(String LName) {
      this.LName = LName;
   }
   private String generateCName() {
      CName = FName + " " + LName;
      return CName;
   }
   public void setAddress(String Address) {
      this.Address = Address;
   }
   
   //getters
   public String getFName() {
      return FName;
   }
   public String getLName() {
      return LName;
   }
   public String getCName() {
      return generateCName();
   }
   public String getAddress() {
      return Address;
   }

}