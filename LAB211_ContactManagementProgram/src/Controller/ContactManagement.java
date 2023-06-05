package Controller;

import java.util.ArrayList;

import Common.FunctionsLibrary;
import Common.InputLibrary;
import Common.Validation;
import Model.Contact;

public class ContactManagement {
    FunctionsLibrary functionsLibrary = new FunctionsLibrary();
    InputLibrary inputLibrary = new InputLibrary();
    Validation validator = new Validation();

    ArrayList<Contact> contactList = new ArrayList<>();

    public void handleInputContact() {
        String status = "";
        do {
            contactList.add(functionsLibrary.inputContactInfo());
            System.out.println("Do you want to continue?");
            status = inputLibrary.setStringValue("Enter yY-YES or nN-NO: ", "^(Y|y|N|n|YES|yes|NO|no)$").toUpperCase();

        } while (status.equalsIgnoreCase("Y") || status.equalsIgnoreCase("YES"));
    }

    public void handleDisplayContactList() {
        if (contactList.isEmpty()) {
            System.out.println("EMPTY LIST! CANNOT DISPLAY!");
        } else {
            functionsLibrary.displayListOfCotact(contactList,
                    "--------------------------------------CONTACT LIST--------------------------------------");
        }
    }

    public void handleRemoveContact() {
        if (contactList.isEmpty()) {
            System.out.println("EMPTY LIST! CANNOT IMPLEMENT THIS FUNCTION");
        } else {
            functionsLibrary.deleteContact(contactList);
            functionsLibrary.displayListOfCotact(contactList,
                    "--------------------------------------UPDATED CONTACT LIST--------------------------------------");
        }
    }
}
