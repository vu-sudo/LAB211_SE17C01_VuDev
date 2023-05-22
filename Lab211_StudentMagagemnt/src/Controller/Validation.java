package Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Student;

public class Validation {

    public boolean validatePattern(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public Student search(String string, ArrayList<Student> studentsList) {
        string = string.trim().toUpperCase();
        for(Student student: studentsList ) {
            if(student.getStudentId().equals(string)) {
                return student;
            }   
        }
        return null;
    }
    
    public String searchInArray(String string, ArrayList<String> checkArrayList) {
        string = string.trim();
        for(String str: checkArrayList) {
            System.out.println(checkArrayList);
            System.out.println(str);
            System.out.println(string);
            if(str.equals(string)) {
                return str;
            }
        }
        return null;
    }
    
    public boolean isDuplicated(String string, ArrayList<Student> studentsList) {
        string = string.trim().toUpperCase();
        return search(string, studentsList) != null;
    }
    public boolean isDuplicatedValueInArray(String string, ArrayList<String> checkArrayList) {
        string = string.trim();
        return searchInArray(string,checkArrayList ) != null;
    }
}
