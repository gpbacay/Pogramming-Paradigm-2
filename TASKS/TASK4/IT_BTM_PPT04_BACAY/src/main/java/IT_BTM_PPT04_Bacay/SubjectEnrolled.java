/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IT_BTM_PPT04_Bacay;

/**
 *
 * @author Gianne Bacay
 */
public class SubjectEnrolled {
    Student student;
    Teacher teacher;
    Subject subject;
    private String studentID, teacherID, subjectTC;
    private double grade;

    //Constructors
    SubjectEnrolled() {
       this.studentID = student.getID();
       this.teacherID = teacher.getID();
       this.subjectTC = subject.getTitleCode();
       this.grade = 0.0;
    }

    SubjectEnrolled(String studentID, String teacherID, String subjectTC, double grade) {
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
    public void setGrade(double grade) {
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
    public double getGrade() {
       return grade;
    }
}
