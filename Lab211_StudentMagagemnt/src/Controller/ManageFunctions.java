package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

import Model.Student;
import View.Menu;

public class ManageFunctions {
    InputFunctions inputtFunctions = new InputFunctions();
    Validation validation = new Validation();
    private boolean isLoadFile = false; 

    // lado data from file
    public void loadData(String fname, ArrayList<Student> studentsList) {
        File file = new File(fname);
        if (!file.exists())
            throw new RuntimeException("File is not exist!");
        String line = "";
        try {
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fname)))) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lStrings = line.split(";");
                    String[] courseString = lStrings[2].split(",");
                    ArrayList<String> tempCourseList = new ArrayList<>();
                    tempCourseList.addAll(Arrays.asList(courseString));
                    Student student = new Student(lStrings[0], lStrings[1], Integer.parseInt(lStrings[3]));
                    student.addCourse(tempCourseList);
                    student.calculateTotalOfCourse();
                    studentsList.add(student);
                }
            }
        } catch (Exception e) {
            System.err.println("Load file error!");
        }
        System.out.println("LOAD FILE SUCESSFUALLY!");
    }
    public void loadDataFromFile(ArrayList<Student> studentsList) {
        if(isLoadFile) {
            System.out.println("FILE IS LOADED! CANT LOAD AGAIN!");
        } else {
            String path = Paths.get("").toAbsolutePath().toString();
            loadData(path + "/src/Data/studentSource.txt", studentsList);
            isLoadFile = true;
            displayStudentsList("LIST OF STUDENT: ", studentsList);
        }
    }

    public void savaData(ArrayList<Student> studentsList) {
        try {
            String path = Paths.get("").toAbsolutePath().toString();
			FileWriter wf = new FileWriter(path + "/src/Data/SavingData.txt");
			for (Student student: studentsList) {
				wf.write(student + System.lineSeparator());

			}
			wf.close();
			System.out.println("Successfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("AN ERROR OCCORED!");
            e.printStackTrace();
        }
    }
    public void saveDataToFile(ArrayList<Student> studentsList) {
        if(studentsList.isEmpty()) {
            System.out.println("LIST OF STUDENT IS EMPTY!");
        } else {
            savaData(studentsList);
        }
    }
    // add one student
    public void addStudentInformation(ArrayList<Student> studentsList) {
        String studentId = inputtFunctions.inputId("Enter student ID <D...>: ", studentsList);
        String studentName = inputtFunctions.inputName("Enter student name: ");
        Integer sesmester = inputtFunctions.inputSesmeseter("Enter sesmester (0-9): ");
        String courseName = inputtFunctions.inputCourse("Enter student course (Java, .Net, C/C++): ");
        Student student = new Student(studentId, studentName, sesmester);
        student.addCourse(courseName);
        student.calculateTotalOfCourse();
        studentsList.add(student);
    }

    // add list of student
    public void addStudentList(ArrayList<Student> studentsList) {
        int number = inputtFunctions.inputNumber("Enter number of student you want to enter: ");
        String choice = "";
        if (number >= 10) {
            System.out.println("Are you sure you want to import more than 10 students at once? (YES|NO): ");
            choice = inputtFunctions.inputString("Enter Y-YES | N-NO: ", "^(Y|y|N|n|YES|yes|NO|no)$").toUpperCase();
        }
        if (choice.equals("Y")) {
            for (int i = 0; i < number; i++) {
                System.out.println("Enter information of student [" + (i + 1) + "]: ");
                addStudentInformation(studentsList);
            }
        }
        if (number < 10) {
            for (int i = 0; i < number; i++) {
                System.out.println("Enter information of student [" + (i + 1) + "]: ");
                addStudentInformation(studentsList);
            }
        }
    }
    // find and sort student
    public ArrayList<Student> search(ArrayList<Student> studentsList, Predicate<Student> suPredicate) {
        ArrayList<Student> tempArrayList = new ArrayList<>();
        for (Student student : studentsList) {
            if (suPredicate.test(student))
                tempArrayList.add(student);
        }
        Collections.sort(tempArrayList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
        return tempArrayList;
    }
    //update student
    public void updateStudent(Student student, ArrayList<Student> studentsList) {
        String[] eMenu = {
                "Update Name",
                "Update Sesmester",
                "Update Courses"
        };
        Menu menu = new Menu("What do you want to update for this student?", eMenu) {
            @Override
            public void execute(int number) {
                switch (number) {
                    case 1:
                        String newName = inputtFunctions.inputName("Old name: " + student.getStudentName() + ", New name: ");
                        student.setStudentName(newName);
                        System.out.println("Change sucessfull! => " + student);
                        break;
                    case 2:
                        Integer newSesmester = inputtFunctions.inputSesmeseter("Old sesmester " + student.getSemester() + ", New sesmester: ");
                        student.setSemester(newSesmester);
                        System.out.println("Change sucessfull! => " + student);
                        break;
                    case 3:
                        String[] eMenu = {
                                "Add course",
                                "Remove course"
                        };
                        Menu subMenu = new Menu("CHOOSE OPTION YOU NEED!", eMenu) {
                            @Override
                            public void execute(int number) {
                                switch (number) {
                                    case 1:
                                        String newCourse = inputtFunctions.inputCourse("Old course: " + student.getCourseName() + ", New course (Java, .Net, C++): ", student);
                                        student.addCourse(newCourse);
                                        student.calculateTotalOfCourse();
                                        break;
                                    case 2:
                                        String delCourse = inputtFunctions.inputCourse("Old course: " + student.getCourseName() + ", Delete course (Java, .Net, C++): ");
                                        student.removeCourse(delCourse);
                                        student.calculateTotalOfCourse();
                                        break;
                                    default:
                                        System.out.println("Backed to main menu!");
                                        return;
                                }
                            }
                        };
                        subMenu.run();
                        System.out.println("Changed sucessfull! => " + student);
                        break;
                    default:
                        System.out.println("Backed to main menu!");
                        return;
                }
            }
        };
        menu.run();
    }   
    //delete student
    public void deleteStudent(Student student, ArrayList<Student> studentsList) {
        studentsList.remove(student);
    }

    public void updateAndDelete(ArrayList<Student> studentsList) {
        String status = "";
        Student student = null;
        String searchId = null;
        if (studentsList.isEmpty()) {
            System.out.println("LIST OF STUDENT IS EMPTY!");
        } else {
            searchId = inputtFunctions.inputString("Enter ID of student you want to <D...>: ", "^(?:[dD][eE])?\\d+$");
            student = validation.search(searchId, studentsList);
            if (student == null) {
                System.out.println("Student " + searchId + " doesnt exist!");
            } else {
                System.out.println("FOUND STUDENT: " + student);
                System.out.println("Do you want to update (U) or delete (D) student?");
                status = inputtFunctions.inputString("Enter (U) to update, (D) to delete: ", "^(U|u|D|d)$")
                        .toUpperCase();
            }
        }
        if (status.equals("U")) {
            updateStudent(student, studentsList);
            System.out.println("Update changed => " + student);
        } else if (status.equals("D")) {
            deleteStudent(student, studentsList);
            displayStudentsList("LIST OF STUDENT AFTER DELETE STUDENT ID: " + searchId + " : ", studentsList);
        }
    }
    public void loadDataAndSaveData(ArrayList<Student> studentsList) {
            String[] options = {
                "Load data from file",
                "Save data to file 'SavingData.txt'"
            };
            Menu eMenu = new Menu("CHOOSE OPTION YOU NEED!", options) {
                @Override
                public void execute(int number) {
                    switch(number) {
                        case 1: 
                            loadDataFromFile(studentsList);
                            break;
                        case 2:
                            saveDataToFile(studentsList);
                            break;
                        default:
                            System.out.println("Backed to main menu!");
                            return;
                    }
                }
            };
            eMenu.run();
    }
    public void displayStudentsList(String msg, ArrayList<Student> studentsList) {
        if (studentsList.isEmpty()) {
            System.out.println("LIST OF STUDENT IS EMPTY!");
        } else {
            System.out.println("\n" + msg);
            System.out.println("------------------------------------------------------------------------");
            System.out.format("| %8s | %20s | %8s | %22s | \n", "ID", "Student Name", "Sesmester", "Course");
            System.out.println("------------------------------------------------------------------------");
            for (Student student : studentsList) {
                System.out.format("| %5s | %20s | %9d | %22s |\n", student.getStudentId(), student.getStudentName(),
                        student.getSemester(), student.getCourseName());
                System.out.println("------------------------------------------------------------------------");
            }
        }
    }

    public void displayStudentsReport(String msg, ArrayList<Student> studentsList) {
        if (studentsList.isEmpty()) {
            System.out.println("LIST OF STUDENT IS EMPTY!");
        } else {
            System.out.println("\n" + msg);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.format("| %8s | %20s | %8s | %22s | %10s |\n", "ID", "Student Name", "Sesmester", "Course",
                    "Total");
            System.out.println("-------------------------------------------------------------------------------------");
            for (Student student : studentsList) {
                System.out.format("| %5s | %20s | %9d | %22s | %10d |\n", student.getStudentId(),
                        student.getStudentName(), student.getSemester(), student.getCourseName(),
                        student.getTotalCourse());
                System.out.println("-------------------------------------------------------------------------------------");
            }
        }
    }
}
