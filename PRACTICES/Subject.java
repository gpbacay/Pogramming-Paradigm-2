public class Subject 
{
   private String titleCode, description, subjectCName, schedule, unit;
   
   //Constructors
   Subject() {
      this.titleCode = "";
      this.description = "";
      this.schedule = "";
      this.unit = "";
   }
   
   Subject(String titleCode, String description, String schedule, String unit) {
      this.titleCode = titleCode;
      this.description = description;
      this.schedule = schedule;
      this.unit = unit;
   }
   
   //Setters
   public void setTitleCode(String titleCode) {
      this.titleCode = titleCode;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public void setSchedule(String schedule) {
      this.schedule = schedule;
   }
   public void setUnit(String unit) {
      this.unit = unit;
   }
   
   //Getters
   public String getTitleCode() {
      return titleCode;
   }
   public String getDescription() {
      return description;
   }
   public String getSchedule() {
      return schedule;
   }
   public String getUnit() {
      return unit;
   }
   public String toString() {
      subjectCName = titleCode + " " + description;
      return subjectCName;
   }
}