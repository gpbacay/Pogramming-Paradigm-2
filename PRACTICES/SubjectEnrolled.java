public class SubjectEnrolled
{
   Student student;
   Teacher teacher;
   Subject subject;
   private String studentID, teacherID, subjectTC, grade;
   
   //Constructors
   SubjectEnrolled() {
      this.studentID = student.getID();
      this.teacherID = teacher.getID();
      this.subjectTC = subject.getTitleCode();
      this.grade = "";
   }
   
   SubjectEnrolled(String studentID, String teacherID, String subjectTC, String grade) {
      this.studentID = studentID;
      this.teacherID = teacherID;
      this.subjectTC = subjectTC;
      this.grade = grade;
   }
   
   //Setters
   public void setStudentID(String studentID) {
      this.studentID = studentID;
   }
   public void setTeacherID(String teacherID) {
      this.teacherID = teacherID;
   }
   public void setSubjectTC(String subjectTC) {
      this.subjectTC = subjectTC;
   }
   public void setGrade(String grade) {
      this.grade = grade;
   }
   
   //Getters
   public String getStudentID() {
      return studentID;
   }
   public String getTeacherID() {
      return teacherID;
   }
   public String getSubjectTC() {
      return subjectTC;
   }
   public String getGrade() {
      return grade;
   }
}