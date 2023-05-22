package Controller;

import java.nio.file.Paths;
import java.util.ArrayList;

import Model.Student;

public class StudentManageService {
    private ArrayList<Student> studentsList = new ArrayList<>();
    private ManageFunctions manageFunctions = new ManageFunctions();
    private InputFunctions inputFunctions = new InputFunctions();
    

    public ArrayList<Student> returnStudentsList() {
        return studentsList;
    }
    public void handleLoadDataAndSaveData() {
        manageFunctions.loadDataAndSaveData(studentsList);
    }
    public void handleAddStudents() {
        manageFunctions.addStudentList(studentsList);
        manageFunctions.displayStudentsList("LIST OF STUDENT: ", studentsList);
    }
    public void handleFindStudent() {
        manageFunctions.displayStudentsList("LIST OF STUDENTS: ", studentsList);
        String searchName = inputFunctions.inputString("Enter student name to find: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$" );
        ArrayList<Student> tempArrayList = manageFunctions.search(studentsList, student -> (student.getStudentName().contains(searchName)));
        if(tempArrayList.isEmpty()) {
            System.out.println("Do not have any student have the name " + searchName + " !");
        } else {
            manageFunctions.displayStudentsList("LIST OF STUDENT HAS THE NAME: " + searchName.toUpperCase(), tempArrayList);
        }
    }
    public void handleUpdateAndDelete() {
        manageFunctions.updateAndDelete(studentsList);
    }
    public void report() {
        manageFunctions.displayStudentsReport("REPORT LIST OF STUDENTS: ", studentsList);
    }

}
