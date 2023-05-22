package Controller;

import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class ManagementService {
    private final ArrayList<Candidate> candidatesList = new ArrayList<>();
    private final Validator validator = new Validator();
    private static final Scanner input = new Scanner(System.in);

    public ArrayList<Experience> returnExperienceCandidates() {
        ArrayList<Experience> experiences = new ArrayList<>();
        for(Candidate candidate: candidatesList) {
            if(candidate instanceof Experience) {
                experiences.add((Experience) candidate);
            }
        }
        return experiences;
    }
    public ArrayList<Fresher> returnFresherCandidates() {
        ArrayList<Fresher> freshers = new ArrayList<>();
        for(Candidate candidate: candidatesList) {
            if(candidate instanceof Fresher) {
                freshers.add((Fresher) candidate);
            }
        }
        return freshers;
    }
    public ArrayList<Intern> returnInternCandidates() {
        ArrayList<Intern> interns = new ArrayList<>();
        for(Candidate candidate: candidatesList) {
            if(candidate instanceof Intern) {
                interns.add((Intern) candidate);
            }
        }
        return interns;
    }
    public void displayExperienceCandidates(ArrayList<Experience> list, String msg) {
        System.out.println("===============" + msg + "=================");
        for(Experience candidate: list) {
            System.out.format(" %15s ", candidate.getFirstName() +  " " + candidate.getLastName());
//            System.out.println("\n" + candidate);
        }
    }
    public void displayFresherCandidates(ArrayList<Fresher> list, String msg) {
        System.out.println("\n===============" + msg + "=================");
        for(Fresher candidate: list) {
            System.out.format(" %15s ", candidate.getFirstName() + candidate.getLastName());
//            System.out.println("\n" + candidate);
        }
    }
    public void displayInternCandidates(ArrayList<Intern> list, String msg) {
        System.out.println("\n===============" + msg + "=================");
        for(Intern candidate: list) {
            System.out.format(" %15s ", candidate.getFirstName() + candidate.getLastName());
//            System.out.println("\n" + candidate);
        }
    }

    public void addExperienceCandidate() {
        String candidateId ;
        String firstName;
        String lastName;
        int birthDate;
        String address;
        String phone;
        String email;
        Integer candidateType = 0;
        int explnYear;
        String proSkill;

        String choice;
        do {
            System.out.println("Enter candidate's ID: ");
            candidateId = input.nextLine();
            System.out.println("Enter candidate's first name: ");
            firstName = input.nextLine();
            System.out.println("Enter candidate's last name: ");
            lastName = input.nextLine();
            System.out.println("Enter candidate's date of birth (yyyy): ");
            birthDate = Integer.parseInt(input.nextLine());
            System.out.println("Enter candidate's address: ");
            address = input.nextLine();
            System.out.println("Enter candidate's phone number: ");
            phone = input.nextLine();
            System.out.println("Enter candidate's email address: ");
            email = input.nextLine();
            System.out.println("Enter experience years: : ");
            explnYear = Integer.parseInt(input.nextLine());
            System.out.println("Enter professional skill ");
            proSkill = input.nextLine();

            if (validator.validateDateOfBirth(Integer.toString(birthDate)) && validator.validatePhoneNumber(phone) && validator.validateEmail(email) && validator.validateYearsOfExperience(Integer.toString(explnYear))) {
                System.out.println("Candidate data enters successfully!");
                Experience experience = new Experience(candidateId,firstName,lastName,birthDate,address,phone,email,candidateType,explnYear,proSkill);
                candidatesList.add(experience);
            } else {
                System.out.println("Candidate data is invalid.");
            }

            System.out.println("Do you want to continue (Y/N)?");
            choice = input.nextLine();
        } while (choice.equalsIgnoreCase("Y"));
    }
    public void addFresherCandidate() {
        String candidateId;
        String firstName;
        String lastName;
        int birthDate ;
        String address;
        String phone;
        String email;
        Integer candidateType = 1;
        int graduateDate;
        String graduateRank;
        String education;

        String choice;
        do {
            System.out.println("Enter candidate's ID: ");
            candidateId = input.nextLine();
            System.out.println("Enter candidate's first name: ");
            firstName = input.nextLine();
            System.out.println("Enter candidate's last name: ");
            lastName = input.nextLine();
            System.out.println("Enter candidate's date of birth (yyyy): ");
            birthDate = Integer.parseInt(input.nextLine());
            System.out.println("Enter candidate's address: ");
            address = input.nextLine();
            System.out.println("Enter candidate's phone number: ");
            phone = input.nextLine();
            System.out.println("Enter candidate's email address: ");
            email = input.nextLine();
            System.out.println("Enter graduate date: ");
            graduateDate = Integer.parseInt(input.nextLine());
            System.out.println("Enter enter graduate rank (Excellence, Good, Fair, Poor): ");
            graduateRank = input.nextLine();
            System.out.println("Enter Education: ");
            education = input.nextLine();
            if (validator.validateDateOfBirth(Integer.toString(birthDate)) && validator.validatePhoneNumber(phone) && validator.validateEmail(email) && validator.validateRankOfGraduation(graduateRank)) {
                System.out.println("Candidate data enters successfully!");
                Fresher fresher = new Fresher(candidateId,firstName,lastName,birthDate,address,phone,email,candidateType,graduateDate,graduateRank, education);
                candidatesList.add(fresher);
            } else {
                System.out.println("Candidate data is invalid.");
            }
            System.out.println("Do you want to continue (Y/N)?");
            choice = input.nextLine();
        } while (choice.equalsIgnoreCase("Y"));
    }
    public void addInternCandidate() {
        String candidateId ;
        String firstName ;
        String lastName ;
        int birthDate ;
        String address ;
        String phone ;
        String email ;
        Integer candidateType = 2;
        String major ;
        int semester ;
        String universityName;

        String choice;
        do {
            System.out.println("Enter candidate's ID: ");
            candidateId = input.nextLine();
            System.out.println("Enter candidate's first name: ");
            firstName = input.nextLine();
            System.out.println("Enter candidate's last name: ");
            lastName = input.nextLine();
            System.out.println("Enter candidate's date of birth (yyyy): ");
            birthDate = Integer.parseInt(input.nextLine());
            System.out.println("Enter candidate's address: ");
            address = input.nextLine();
            System.out.println("Enter candidate's phone number: ");
            phone = input.nextLine();
            System.out.println("Enter candidate's email address: ");
            email = input.nextLine();
            System.out.println("Enter candidate major: ");
            major = input.nextLine();
            System.out.println("Enter candidate semester(number): " );
            semester = Integer.parseInt(input.nextLine());
            System.out.println("Enter candidate university name: ");
            universityName = input.nextLine();

            if (validator.validateDateOfBirth(Integer.toString(birthDate)) && validator.validatePhoneNumber(phone) && validator.validateEmail(email)) {
                System.out.println("Candidate data enters successfully!");
                Intern intern = new Intern(candidateId,firstName,lastName,birthDate,address,phone,email,candidateType, major, semester, universityName);
                candidatesList.add(intern);
            } else {
                System.out.println("Candidate data is invalid.");
            }

            System.out.println("Do you want to continue (Y/N)?");
            choice = input.nextLine();
        } while (choice.equalsIgnoreCase("Y"));
    }
    public ArrayList<Candidate> returnCandidatesList() {
        return candidatesList;
    }
    public ArrayList<Candidate> searchCandidate() {
        ArrayList<Candidate> temp = new ArrayList<>();
        String candidateName;
        System.out.println("Input Candidate name (First name or Last name):");
        candidateName = input.nextLine();
        int candidateType;
        System.out.println("Input type of candidate:");
        candidateType = Integer.parseInt(input.nextLine());

        for(Candidate candidate: candidatesList) {
            if((candidate.getFirstName().contains(candidateName) || candidate.getLastName().contains(candidateName)) && candidate.getCandidateType() == candidateType) {
                temp.add(candidate);
            }
        }
        return temp;
    }
    public ArrayList<Candidate> search (Predicate<Candidate> cd) {
        ArrayList<Candidate>  tempList = new ArrayList<>();
        for(Candidate candidate: candidatesList) {
            if(cd.test(candidate)) tempList.add(candidate);
        }
        return tempList;
    }
    public void displayAll() {
        displayExperienceCandidates(returnExperienceCandidates(), "EXPERIENCE CANDIDATE");
        displayFresherCandidates(returnFresherCandidates(), "FRESHER CANDIDATE");
        displayInternCandidates(returnInternCandidates(), "INTERN CANDIDATE");
    }
    public void displayList(ArrayList<Candidate> candidates) {
        for(Candidate candidate: candidates) {
            System.out.format("| %15s | %15d | %20s | %20s | %20s | %5d |" , candidate.getFirstName() + " " + candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getCandidateType());
        }
    }
}
