package Model;

public class Doctor {
    private String doctorName;
    private String doctorSpecialization;
    private Integer doctorAvailability;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public Integer getDoctorAvailability() {
        return doctorAvailability;
    }

    public void setDoctorAvailability(Integer doctorAvailability) {
        this.doctorAvailability = doctorAvailability;
    }

    public Doctor(String doctorName, String doctorSpecialization, Integer doctorAvailability) {
        this.doctorName = doctorName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorAvailability = doctorAvailability;
    }

    @Override
    public String toString() {
        return "Doctor Name: " + doctorName + ", Specialization: " + doctorSpecialization
                + ", Availability: " + doctorAvailability;
    }

    

}