public class Person {
   private String FName, LName, Address, Age, Sex, ID;
   
   //Constructors
   public Person(){
      FName = "";
      LName = "";
      Address = "";
      Age = "";
      Sex = "";
   }
   
   public Person(String FName, String LName, String Address, String Age, String Sex) {
      this.FName = FName;
      this.LName = LName;
      this.Address = Address;
      this.Age = Age;
      this.Sex = Sex;
   }
   
   //Setters
   public void setFName(String FName) {
      this.FName = FName;
   }
   public void setLName(String LName) {
      this.LName = LName;
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
   
   
}