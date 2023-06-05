package Common;

import java.util.ArrayList;

import Model.Contact;

public class FunctionsLibrary {
    InputLibrary inputLibrary = new InputLibrary();
    Validation validator = new Validation();

    // fullname(String), group(String), address(String), phone(String),
    public Contact inputContactInfo() {
        String contactFullName = validator.normalizeFullName(
                inputLibrary.setStringValue("Enter contact full name: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
        String contactGroup = inputLibrary.setStringValue("Enter contact group: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
        String contactAddress = validator.normalizeFullName(inputLibrary.setStringValue("Enter contact address: ",
                "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
        String contactPhone = inputLibrary.setStringValue("Enter contact phone number: ",
                "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})[ ]?(x|ext)\\.? (\\d+)$");
        return new Contact(contactFullName, contactGroup, contactAddress, contactPhone);
    }

    public void displayListOfCotact(ArrayList<Contact> contactList, String msg) {
        if (contactList.isEmpty()) {
            System.out.println("CONTACT LIST IS EMPTY! PLEASE INPUT COUNTRY TO SHOW!");
        } else {
            System.out.println("\n" + msg);
            System.out.println(
                    "\n------------------------------------------------------------------------------------------------------");
            System.out.format("| %5s | %20s | %10s | %10s | %10s | %10s | %15s |", "ID", "FULLNAME",
                    "FIRST NAME", "LAST NAME", "GROUP", "ADDRESS", "PHONE");
            System.out.println(
                    "\n------------------------------------------------------------------------------------------------------");
            for (Contact contact : contactList) {
                System.out.format("| %5d | %20s | %10s | %10s | %10s | %10s | %15s |", contact.getContactId(),
                        contact.getContactFullName(), contact.getContactFirstName(), contact.getContactLastName(),
                        contact.getContactGroup(), contact.getContactAddress(), contact.getContactPhone());
                System.out.println(
                        "\n------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public Contact search(Integer searchId, ArrayList<Contact> contactList) {
        for (Contact contact : contactList) {
            if (contact.getContactId() == searchId) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact(ArrayList<Contact> contactList) {
        Contact contact = null;
        Integer removeId = null;
        if (contactList.isEmpty()) {
            System.out.println("LIST OF CONTACT IS EMPTY!");
        } else {
            removeId = inputLibrary.setIntegerValue("Enter contact ID to remove: ");
            contact = search(removeId, contactList);
            if (contact == null) {
                System.out.println("Contact " + removeId + " doesn't exist!");
            } else {
                contactList.remove(contact);
                System.out.println("Remove successfully!");
                for (int i = 0; i < contactList.size(); i++) {
                    contactList.get(i).setContactId(i + 1);
                }
            }
        }
    }
}
