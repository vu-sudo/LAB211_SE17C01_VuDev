package View;

import Controller.ManagementService;
import Model.Candidate;

import java.util.ArrayList;
import java.util.Scanner;

public class CandidateManagement extends Menu{
    ManagementService managementService = new ManagementService();
    private static final Scanner input = new Scanner(System.in);

    static String[] options = {
            "Experience",
            "Fresher",
            "Intern",
            "Search",
            "Exit"
    };
    public CandidateManagement() {
        super("CANDIDATE MANAGEMENT SYSTEM", options);
    }
    @Override
    public void execute(int number) {
        switch (number) {
            case 1:
                managementService.addExperienceCandidate();
                managementService.displayExperienceCandidates(managementService.returnExperienceCandidates(), "EXPERIENCE CANDIDATE");
                break;
            case 2:
                managementService.addFresherCandidate();
                managementService.displayFresherCandidates(managementService.returnFresherCandidates(), "FRESHER CANDIDATE");
                break;
            case 3:
                managementService.addInternCandidate();
                managementService.displayInternCandidates(managementService.returnInternCandidates(), "INTERN CANDIDATE");
                break;
            case 4:
                if(managementService.returnCandidatesList().isEmpty()) {
                    System.out.println("Empty List! Cant execute this function!");
                } else {
                    searchingCandidate();
                }
                break;
            case 5:
                System.out.println("EXIT PROGRAM!");
            default:
                System.exit(0);
        }
    }
    public void searchingCandidate() {
        managementService.displayAll();
        ArrayList<Candidate> temp = null;
        System.out.println("\nInput Candidate name (First name or Last name): ");
        String searchName = input.nextLine();
        System.out.println("Input type of candidate: ");
        String searchType = input.nextLine();
        temp = managementService.search(ls -> (ls.getFirstName().contains(searchName) || ls.getLastName().contains(searchName)) && ls.getCandidateType().toString().equals(searchType));
        temp.forEach(c -> System.out.println(c.getFirstName() + c.getLastName() + " | " + c.getBirthDate() + " | " + c.getAddress() + " | " + c.getPhone() + " | " + c.getEmail() + " | " + c.getCandidateType()));
    }
    public static void main(String[] args) {
        CandidateManagement exe = new CandidateManagement();
        exe.run();
    }
}