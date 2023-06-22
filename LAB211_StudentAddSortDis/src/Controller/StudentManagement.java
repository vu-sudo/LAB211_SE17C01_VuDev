package Controller;

import java.util.ArrayList;

import Common.FunctionsLibrary;
import Model.Student;

public class StudentManagement {
    private FunctionsLibrary functionsLibrary = new FunctionsLibrary();
    ArrayList<Student> studentsList = new ArrayList<>();

    public void handleManagement() {
        functionsLibrary.addStudent(studentsList);
        functionsLibrary.sortStudent(studentsList);
        functionsLibrary.displayStudent(studentsList, "============Student List============");
    }
}
