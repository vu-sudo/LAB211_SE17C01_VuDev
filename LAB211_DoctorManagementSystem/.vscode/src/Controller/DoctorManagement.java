package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Common.FunctionsLibrary;
import Common.Validation;
import Common.InputLibrary;
import Model.Doctor;

public class DoctorManagement {
    FunctionsLibrary functionsLibrary = new FunctionsLibrary();
    Validation validator = new Validation();
    InputLibrary inputLibrary = new InputLibrary();
    HashMap<String, Doctor> doctorMap = new HashMap<>();

    public HashMap<String, Doctor> returnDoctorHashMap() {
        return doctorMap;
    }

    public void handleAddDoctors() {
        functionsLibrary.addDoctor(doctorMap);
        functionsLibrary.displayDoctor(doctorMap, "--------------------------DOCTOR DATABASE---------------------");
    }

    public void handleUpdateDoctorInfo() {
        functionsLibrary.updateDoctorInfo(doctorMap);
    }

    public void handleRemoveDoctor() {
        functionsLibrary.removeDoctor(doctorMap);
    }

    public void handleFindDoctor() {
        functionsLibrary.displayDoctor(doctorMap, "LIST OF DOCTORS");
        String searchName = validator.normalizeFullName(
                inputLibrary.setStringValue("Enter name to search: ",
                        "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
        HashMap<String, Doctor> tempMap = functionsLibrary.searchDoctor(doctorMap,
                doctor -> doctor.getDoctorName().contains(searchName));
        if (tempMap.isEmpty())
            System.out.println("Result not found!");
        else
            functionsLibrary.displayDoctor(tempMap, "---------------List of Doctor---------------");
    }

}
