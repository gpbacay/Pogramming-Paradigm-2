public class Student extends Person
{
   private String course, yearLevel;
   
   Student() {
      super();
      course = "";
      yearLevel = "";
   }
   
   Student(String FName, String LName, String Identification, String Address, String course, String yearLevel) {
      super(FName, LName, Identification, Address);
      this.course = course;
      this.yearLevel = yearLevel;
   }
   
   //Setters
   public void setCourse(String course) {
      this.course = course;
   }
   public void setYearLevel(String yearLevel) {
      this.yearLevel = yearLevel;
   }
   
   //Getters
   public String getCourse() {
      return course;
   }
   public String getYearLevel() {
      return yearLevel;
   }
   
//    public String toString() {
//       String str;
//       str = super.toString();
//       return str + "Course: " + course + "\nYear Level: " + yearLevel;
//    }

}