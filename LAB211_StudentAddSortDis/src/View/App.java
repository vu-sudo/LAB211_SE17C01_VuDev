package View;

import Controller.StudentManagement;

public class App {
    public static void main(String[] args) throws Exception {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.handleManagement();
    }
}
