package Model;

public class Contact {
    private Integer contactId;
    private String contactFullName;
    private String contactGroup;
    private String contactAddress;
    private String contactPhone;
    private String contactLastName;
    private String contactFirstName;

    private static int defaultId = 0;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactFullName() {
        return contactFullName;
    }

    public void setContactFullName(String contactFullName) {
        this.contactFullName = contactFullName;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    // public void setContactLastName(String contactLastName) {
    // this.contactLastName = contactLastName;
    // }

    public String getContactFirstName() {
        return contactFirstName;
    }

    // public void setContactFirstName(String contactFirstName) {
    // this.contactFirstName = contactFirstName;
    // }

    public Contact(String contactFullName, String contactGroup, String contactAddress,
            String contactPhone) {
        this.contactId = ++defaultId;
        this.contactFullName = contactFullName;
        this.contactGroup = contactGroup;
        this.contactAddress = contactAddress;
        this.contactPhone = contactPhone;
        String[] nameParts = this.contactFullName.split(" ");
        this.contactFirstName = nameParts[0];
        this.contactLastName = nameParts[nameParts.length - 1];
    }
}
