package Common;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import Model.Doctor;
import View.Menu;

public class FunctionsLibrary {
    InputLibrary inputLibrary = new InputLibrary();
    Validation validator = new Validation();

    public void addDoctor(HashMap<String, Doctor> map) {
        String choice = "";
        do {
            String id = inputLibrary.setStringValue("Enter doctor code: ", "^[dD]\\d+$").toUpperCase();
            try {
                if (map.containsKey(id)) {
                    throw new IllegalArgumentException("ID already exists in the database");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            String name = validator.normalizeFullName(
                    inputLibrary.setStringValue("Enter doctor name: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
            String specialization = validator.normalizeFullName(
                    inputLibrary.setStringValue("Enter doctor specialization: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
            Integer availability = inputLibrary.setIntegerValue("Enter doctor availability: ");

            Doctor doctor = new Doctor(name, specialization, availability);
            map.put(id, doctor);

            choice = inputLibrary
                    .setStringValue("Do you want to add more doctor? (yY-YES or nN-NO):", "^(Y|y|N|n|YES|yes|NO|no)$")
                    .toUpperCase();
        } while (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"));
    }

    public void displayDoctor(HashMap<String, Doctor> map, String msg) {
        if (map.isEmpty()) {
            System.out.println("DOCTOR DATABSE IS EMPTY! PLEASE INPUT DOCTOR TO USE THIS FUNCTION!");
        } else {
            System.out.println("\n" + msg);
            System.out.println(
                    "\n--------------------------------------------------------------------");
            System.out.format("| %5s | %20s | %15s | %15s |", "ID", "FULLNAME", "SPECIALIZATION", "AVAILABILITY");
            System.out.println(
                    "\n--------------------------------------------------------------------");
            for (String id : map.keySet()) {
                Doctor doctor = map.get(id);
                System.out.format("| %5s | %20s | %15s | %15d |", id, doctor.getDoctorName(),
                        doctor.getDoctorSpecialization(), doctor.getDoctorAvailability());
                System.out.println(
                        "\n--------------------------------------------------------------------");
            }
        }
    }

    public Doctor search(String searchId, HashMap<String, Doctor> map) {
        if (map.containsKey(searchId)) {
            return map.get(searchId);
        }
        return null;
    }

    public void updateDoctorInfo(HashMap<String, Doctor> map) {
        String searchId = null;
        Doctor doctor = null;
        if (map.isEmpty()) {
            System.out.println("DOCTOR DATABASE IS EMPTY!");
        } else {
            searchId = inputLibrary.setStringValue("Enter doctor code to search: ", "^[dD]\\d+$").toUpperCase();
            doctor = search(searchId, map);
            if (doctor == null) {
                System.out.println("Doctor " + searchId + " doesn't exist!");
            } else {
                updateMenu(doctor);
            }
        }

    }

    public void updateMenu(Doctor doctor) {
        String[] eMenu = {
                "Update Name.",
                "Update Specialization.",
                "Update Availability."
        };
        Menu menu = new Menu("What do you want to update for this doctor?", eMenu) {
            @Override
            public void execute(int number) {
                switch (number) {
                    case 1:
                        String newName = validator.normalizeFullName(
                                inputLibrary.setStringValue(
                                        "Old doctor name: " + doctor.getDoctorName() + " New doctor name: ",
                                        "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
                        doctor.setDoctorName(newName);
                        System.out.println("Update successfully! => " + doctor);
                        break;
                    case 2:
                        String newSpecialization = validator.normalizeFullName(
                                inputLibrary
                                        .setStringValue(
                                                "Old doctor specializtion: " + doctor.getDoctorSpecialization()
                                                        + " New doctor specialization: ",
                                                "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
                        doctor.setDoctorSpecialization(newSpecialization);
                        System.out.println("Update successfully! => " + doctor);
                        break;
                    case 3:
                        Integer newAvailability = inputLibrary.setIntegerValue("Old doctor availability: "
                                + doctor.getDoctorAvailability() + " New doctor availability: ");
                        doctor.setDoctorAvailability(newAvailability);
                        System.out.println("Update successfully! => " + doctor);
                    default:
                        System.out.println("BACK TO MAIN MENU!");
                        return;
                }
            }
        };
        menu.run();
    }

    public void removeDoctor(HashMap<String, Doctor> map) {
        String searchId = null;
        Doctor doctor = null;
        if (map.isEmpty()) {
            System.out.println("DOCTOR DATABASE IS EMPTY!");
        } else {
            searchId = inputLibrary.setStringValue("Enter doctor code to remove: ", "^[dD]\\d+$").toUpperCase();
            doctor = search(searchId, map);
            if (doctor == null) {
                System.out.println("Doctor " + searchId + " doesn't exist!");
            } else {
                map.remove(searchId);
            }
        }

    }

    public HashMap<String, Doctor> searchDoctor(HashMap<String, Doctor> map, Predicate<Doctor> suPredicate) {
        HashMap<String, Doctor> tempMap = new HashMap<>();
        for (Map.Entry<String, Doctor> entry : map.entrySet()) {
            if (suPredicate.test(entry.getValue()))
                tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}
