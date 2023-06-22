package Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.Student;

public class FunctionsLibrary implements StudentManagementInterface {
    InputLibrary inputLibrary = new InputLibrary();

    public void addStudent(ArrayList<Student> studenstList) {
        String choice = "";
        do {
            String name = inputLibrary.inputStringValue("Enter student name: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
            Float mark = inputLibrary.inputMark("Enter student mark: ");
            String className = inputLibrary.inputStringValue("Enter student class: ", "^FU\\d+$");
            Student student = new Student(name, mark, className);
            studenstList.add(student);
            choice = inputLibrary.inputStringValue("Do you want to add more student? (Y|N|y|n|Yes|No|yes|no|YES|NO)",
                    "^(Y|y|N|n|YES|yes|NO|no)$").toUpperCase();
        } while (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"));
    }

    public void sortStudent(ArrayList<Student> studentsList) {
        Collections.sort(studentsList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void displayStudent(ArrayList<Student> studentsList, String msg) {
        if (studentsList.isEmpty()) {
            System.out.println("THERE WAS NO STUDENT IN THE LIST!");
        } else {
            System.out.println("\n" + msg);
            System.out.println(
                    "\n========================================");
            System.out.format("| %15s | %7s | %8s |", "NAME", "MARK", "CLASSES");
            System.out.println(
                    "\n========================================");
            for (Student student : studentsList) {
                System.out.format("| %15s | %7.2f | %8s |", student.getName(), student.getMark(), student.getClasses());
                System.out.println(
                        "\n----------------------------------------");
            }
        }
    }

}
