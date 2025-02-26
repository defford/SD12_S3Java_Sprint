
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    // Doctor inherits from Person
    private String specialization;
    private List<Patient> patients;
   

    // Constructor
    public Doctor(int id, String name, int age, String PhoneNumber, String specialization, List<Patient> patients) {
        super(id, name, age, PhoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Method to add a patient
    public void addPatient(Patient patient) 
    {
        patients.add(patient);
    }

    // Method to get patients
    public List<Patient> getPatients() {
        return patients;
    }

    // Method to remove a patient
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // Getters
    public String getSpecialization() {
        return specialization;
    }
    

    // Setters
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    // toString
    @Override
    public String toString() {
        return "Doctor [specialization=" + specialization + ", patients=" + patients + "]";
    }
    
}