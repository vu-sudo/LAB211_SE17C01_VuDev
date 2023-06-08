package View;

import java.util.Scanner;

import Controller.DoctorManagement;

public class DoctorManagementProgram extends Menu {
    DoctorManagement doctorManagement = new DoctorManagement();
    private final Scanner input = new Scanner(System.in);

    static String[] optionsMenu = {
            "Add a doctor.",
            "Update a doctor info.",
            "Remove a doctor.",
            "Search doctor by name.",
            "Exit."
    };

    public DoctorManagementProgram() {
        super("DOCTOR MANAGEMENT PROGRAM", optionsMenu);
    }

    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...!");
        input.nextLine();
    }

    public void execute(int number) {
        switch (number) {
            case 1:
                doctorManagement.handleAddDoctors();
                waitForPressAnyKey();
                break;
            case 2:
                doctorManagement.handleUpdateDoctorInfo();
                waitForPressAnyKey();
                break;
            case 3:
                doctorManagement.handleRemoveDoctor();
                waitForPressAnyKey();
                break;
            case 4:
                doctorManagement.handleFindDoctor();
                waitForPressAnyKey();
                break;
            case 5:
                System.out.println("PROGRAM ENDED! THANKS FOR USING!");
            default:
                System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        DoctorManagementProgram exe = new DoctorManagementProgram();
        exe.run();
    }
}
