
import java.util.ArrayList;
import java.util.List;

public class MedicationTrackingSystem {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    // Constructor
    public MedicationTrackingSystem() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    }

    // Method to add a doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to add a patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Method to add a medication
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Method to add a prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Method to remove a doctor
    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    // Method to remove a patient

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // Method to remove a medication
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    // Method to remove a prescription
    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

   



}