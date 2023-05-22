package Model;

public class Fresher extends Candidate{
    private Integer graduateDate;
    private String graduateRank;
    private String education;
    public Fresher(String candidateId, String firstName, String lastName, Integer birthDate, String address, String phone, String email, Integer candidateType) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
    }

    public Fresher(String candidateId, String firstName, String lastName, Integer birthDate, String address, String phone, String email, Integer candidateType, Integer graduateDate, String graduateRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduateDate = graduateDate;
        this.graduateRank = graduateRank;
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + "Fresher{" +
                "graduateDate=" + graduateDate +
                ", graduateRank='" + graduateRank + '\'' +
                '}';
    }
}
