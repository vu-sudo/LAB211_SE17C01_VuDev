package Common;

import java.util.ArrayList;

import Model.Student;

public interface StudentManagementInterface {
    public void addStudent(ArrayList<Student> studenstList);
    public void sortStudent(ArrayList<Student> studentsList);
    public void displayStudent(ArrayList<Student> studentsList, String msg);
}
