import java.util.List;
import java.util.ArrayList;

public class Patient extends Person { 
    // Patient inherits from Person
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    // Constructor  
    public Patient(int id, String name, int age, String PhoneNumber, List medication, List prescriptions) {
        super(id, name, age, PhoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Getters
    public List getMedications() {
        return medications;
    }
    public List getPrescriptions() {
        return prescriptions;
    }

    // Method to add a medication
    public void addMedication(Medication medication) {
        medications.add(medication);
    }   

    // Method to add a prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Method to remove a medication
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    // Method to remove a prescription
    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    // toString
    @Override
    public String toString() {
        return "Patient [medications=" + medications + ", prescriptions=" + prescriptions + "]";
    }
    

} 