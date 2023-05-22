package Model;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    private Integer semester;
    private ArrayList<String> courseName = null;
    private Integer totalCourse;
    
    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public Integer getSemester() {
        return semester;
    }
    public ArrayList<String> getCourseName() {
        return courseName;
    }
    public Integer getTotalCourse() {
        return totalCourse;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setSemester(Integer semester) {
        this.semester = semester;
    }
    public void setCourseName(ArrayList<String> courseName) {
        this.courseName = courseName;
    }
    public void setTotalCourse(Integer totalCourse) {
        this.totalCourse = totalCourse;
    }

    public Student(String studentId, String studentName, Integer semester) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = new ArrayList<String>();
    }
    public void addCourse(String course) {
        this.courseName.add(course);
    }
    public void addCourse(ArrayList<String> course) {
        this.courseName = course;
    }
    public void removeCourse(String course) {
        this.courseName.remove(course);
    }
    public void calculateTotalOfCourse() {
        this.totalCourse = this.getCourseName().size();
    }
    @Override
    public String toString() {
        return "[studentId=" + studentId + ", studentName=" + studentName + ", semester=" + semester
                + ", courseName=" + courseName + "]";
    }
}
