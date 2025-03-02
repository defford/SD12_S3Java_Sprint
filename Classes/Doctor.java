import java.util.List;
import java.util.ArrayList;

public class Doctor extends Person {
    private String specialization;
    private List<Patient> patients;
   
    // Constructor with patients list
    public Doctor(String firstName, String lastName, int age, String PhoneNumber, String specialization, List<Patient> patients) {
        super(firstName, lastName, age, PhoneNumber);
        this.specialization = specialization;
        this.patients = patients;
    }

    // Constructor without patients list (initializes empty list)
    public Doctor(String firstName, String lastName, int age, String PhoneNumber, String specialization) {
        super(firstName, lastName, age, PhoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Getters
    public String getSpecialization() {
        return specialization;
    }
    
    public List<Patient> getPatients() {
        return patients;
    }
    
    // Setters
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    public void addPatient(Patient patient) 
    {
        patients.add(patient);
    }
    
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    @Override
    public String toString() {
        return String.format("""
                \nID: %s
                Name: %s
                Age: %d
                Phone Number: %s
                Specialization: %s
                Patients: %s""",
                getId(), getFullName(), getAge(), getPhoneNumber(), specialization, patients);
    }
    
}