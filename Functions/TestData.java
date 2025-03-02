import java.util.ArrayList;
import java.util.List;

public class TestData {
    // Create Medications
    Medication med1 = new Medication("Amoxicillin", "500mg", 100);
    Medication med2 = new Medication("Lisinopril", "10mg", 200);
    Medication med3 = new Medication("Metformin", "1000mg", 150);
    Medication med4 = new Medication("Sertraline", "50mg", 80);
    Medication med5 = new Medication("Ibuprofen", "400mg", 300);

    // Create Doctors
    Doctor doc1 = new Doctor("John", "Smith", 45, "555-0101", "Cardiology");
    Doctor doc2 = new Doctor("Sarah", "Johnson", 38, "555-0102", "Pediatrics");
    Doctor doc3 = new Doctor("Michael", "Brown", 52, "555-0103", "Internal Medicine");
    Doctor doc4 = new Doctor("Emily", "Davis", 41, "555-0104", "Neurology");
    Doctor doc5 = new Doctor("David", "Wilson", 49, "555-0105", "Psychiatry");

    // Create Patients (with empty medication and prescription lists that will be populated later)
    Patient pat1 = new Patient("Alice", "Thompson", 35, "555-1001", new ArrayList<>(), new ArrayList<>());
    Patient pat2 = new Patient("Bob", "Anderson", 62, "555-1002", new ArrayList<>(), new ArrayList<>());
    Patient pat3 = new Patient("Carol", "Martinez", 28, "555-1003", new ArrayList<>(), new ArrayList<>());
    Patient pat4 = new Patient("Daniel", "Taylor", 45, "555-1004", new ArrayList<>(), new ArrayList<>());
    Patient pat5 = new Patient("Emma", "White", 53, "555-1005", new ArrayList<>(), new ArrayList<>());

    // Create Prescriptions
    Prescription pres1 = new Prescription(doc1, pat1, med1);
    Prescription pres2 = new Prescription(doc2, pat2, med2);
    Prescription pres3 = new Prescription(doc3, pat3, med3);
    Prescription pres4 = new Prescription(doc4, pat4, med4);
    Prescription pres5 = new Prescription(doc5, pat5, med5);

    public void addPatientsToDoctors(List<Doctor> doctors, List<Patient> patients) {
        for (int i = 0; i < doctors.size(); i++) {
            doctors.get(i).addPatient(patients.get(i));
        }
    }
}
