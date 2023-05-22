package Model;

public class Experience extends Candidate {
    private Integer explnYear;
    private String proSkill;

    public Experience(String candidateId, String firstName, String lastName, Integer birthDate, String address, String phone, String email, Integer candidateType) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
    }

    public Experience(String candidateId, String firstName, String lastName, Integer birthDate, String address, String phone, String email, Integer candidateType, Integer explnYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() +  "Experience{" +
                "explnYear=" + explnYear +
                ", proSkill='" + proSkill + '\'' +
                '}';
    }
}
