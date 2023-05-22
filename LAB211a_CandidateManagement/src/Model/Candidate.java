package Model;

public abstract class Candidate {
    private String candidateId;
    private String firstName;
    private String lastName;
    private Integer birthDate;
    private String address;
    private String phone;
    private String email;
    private Integer candidateType;

    public String getCandidateId() {
        return candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCandidateType() {
        return candidateType;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCandidateType(Integer candidateType) {
        this.candidateType = candidateType;
    }

    public Candidate(String candidateId, String firstName, String lastName, Integer birthDate, String address, String phone, String email, Integer candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId='" + candidateId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", candidateType=" + candidateType +
                '}';
    }
}
