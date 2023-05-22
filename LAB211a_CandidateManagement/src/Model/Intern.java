package Model;

public class Intern extends Candidate{
    private String major;
    private Integer semester;
    private String universityName;
    public Intern(String candidateId, String firstName, String lastName, Integer birthDate, String address, String phone, String email, Integer candidateType) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
    }

    public Intern(String candidateId, String firstName, String lastName, Integer birthDate, String address, String phone, String email, Integer candidateType, String major, Integer semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + "Intern{" +
                "major='" + major + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
