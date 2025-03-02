import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    // Get Methods
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public Medication getMedicationById(int id) {
        for (Medication medication : medications) {
            if (medication.getId() == id) {
                return medication;
            }
        }
        return null;
    }

    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        return null;
    }

    // Add Methods
    public void addDoctor(Scanner scanner) {
        System.out.println("\n===== Add New Doctor =====");
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();
        
        System.out.print("Enter specialization: ");
        scanner.nextLine(); // Clear the buffer
        String specialization = scanner.nextLine();
        
        Doctor newDoctor = new Doctor(firstName, lastName, age, phoneNumber, specialization);
        doctors.add(newDoctor);
        System.out.println("\nDoctor " + newDoctor.getFullName() + " added successfully!");
    }

    public void addPatient(Scanner scanner) {
        System.out.println("\n===== Add New Patient =====");
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();
        
        Patient newPatient = new Patient(firstName, lastName, age, phoneNumber, 
                                       new ArrayList<>(), new ArrayList<>());
        patients.add(newPatient);
        System.out.println("\nPatient " + newPatient.getFullName() + " added successfully!");
    }

    public void addMedication(Scanner scanner) {
        System.out.println("\n===== Add New Medication =====");
        System.out.print("Enter medication name: ");
        String name = scanner.next();
        
        System.out.print("Enter dose (e.g., '500mg'): ");
        String dose = scanner.next();
        
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        
        Medication newMedication = new Medication(name, dose, quantity);
        medications.add(newMedication);
        System.out.println("\nMedication " + newMedication.getName() + " added successfully!");
    }

    public void addPrescription(Scanner scanner) {
        System.out.println("\n===== Add New Prescription =====");
        
        // Select Doctor
        System.out.println("\nAvailable Doctors:");
        for (Doctor doc : doctors) {
            System.out.println(doc.getId() + ": " + doc.getFullName() + " (" + doc.getSpecialization() + ")");
        }
        System.out.print("Enter doctor ID: ");
        int doctorId = scanner.nextInt();
        Doctor selectedDoctor = doctors.stream()
            .filter(d -> d.getId() == doctorId)
            .findFirst()
            .orElse(null);
        
        if (selectedDoctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        // Select Patient
        System.out.println("\nAvailable Patients:");
        for (Patient pat : patients) {
            System.out.println(pat.getId() + ": " + pat.getFullName());
        }
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        Patient selectedPatient = patients.stream()
            .filter(p -> p.getId() == patientId)
            .findFirst()
            .orElse(null);
        
        if (selectedPatient == null) {
            System.out.println("Patient not found!");
            return;
        }

        // Select Medication
        System.out.println("\nAvailable Medications:");
        for (Medication med : medications) {
            System.out.println(med.getId() + ": " + med.getName() + " (" + med.getDose() + ")");
        }
        System.out.print("Enter medication ID: ");
        int medicationId = scanner.nextInt();
        Medication selectedMedication = medications.stream()
            .filter(m -> m.getId() == medicationId)
            .findFirst()
            .orElse(null);
        
        if (selectedMedication == null) {
            System.out.println("Medication not found!");
            return;
        }

        // Create prescription with default 1-year expiry
        Prescription newPrescription = new Prescription(selectedDoctor, selectedPatient, selectedMedication);
        prescriptions.add(newPrescription);
        selectedPatient.addPrescription(newPrescription);
        System.out.println("\nPrescription created successfully!");
        System.out.println("Doctor: " + selectedDoctor.getFullName());
        System.out.println("Patient: " + selectedPatient.getFullName());
        System.out.println("Medication: " + selectedMedication.getName() + " (" + selectedMedication.getDose() + ")");
        System.out.println("Expires: " + newPrescription.getPrescriptionExpiryDate());
    }

    // Edit Methods
    public void editPatient(Patient patient, Scanner scanner) {
        System.out.println("\n===== Edit Patient =====");
        System.out.println("\nCurrent patient details: " + patient.toString());
        System.out.print("\nWhich patient's details would you like to edit? \n");
        System.out.print("1) First name\n2) Last name\n3) Age\n4) Phone number\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter new first name: ");
                String firstName = scanner.next();
                patient.setFirstName(firstName);
                System.out.println("Patient updated successfully!");
                break;
            case 2:
                System.out.print("Enter new last name: ");
                String lastName = scanner.next();
                patient.setLastName(lastName);
                System.out.println("Patient updated successfully!");
                break;
            case 3:
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                patient.setAge(age);
                System.out.println("Patient updated successfully!");
                break;
            case 4:
                System.out.print("Enter new phone number: ");
                String phoneNumber = scanner.next();
                patient.setPhoneNumber(phoneNumber);
                System.out.println("Patient updated successfully!");
                break;
        }
    }

    public void editDoctor(Doctor doctor, Scanner scanner) {
        System.out.println("\n===== Edit Doctor =====");
        System.out.println("\nCurrent doctor details: " + doctor.toString());
        System.out.print("\nWhich doctor's details would you like to edit? \n");
        System.out.print("1) First name\n2) Last name\n3) Age\n4) Phone number\n5) Specialization\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter new first name: ");
                String firstName = scanner.next();
                doctor.setFirstName(firstName);
                System.out.println("Doctor updated successfully!");
                break;
            case 2:
                System.out.print("Enter new last name: ");
                String lastName = scanner.next();
                doctor.setLastName(lastName);
                System.out.println("Doctor updated successfully!");
                break;
            case 3:
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                doctor.setAge(age);
                System.out.println("Doctor updated successfully!");
                break;
            case 4:
                System.out.print("Enter new phone number: ");
                String phoneNumber = scanner.next();
                doctor.setPhoneNumber(phoneNumber);
                System.out.println("Doctor updated successfully!");
                break;
            case 5:
                System.out.print("Enter new specialization: ");
                String specialization = scanner.next();
                doctor.setSpecialization(specialization);
                System.out.println("Doctor updated successfully!");
                break;
        }
    }

    public void editMedication(Medication medication, Scanner scanner) {
        System.out.println("\n===== Edit Medication =====");
        System.out.println("\nCurrent medication details: " + medication.toString());
        System.out.print("\nWhich medication's details would you like to edit? \n");
        System.out.print("1) Name\n2) Dosage\n3) Frequency\n4) Instructions\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String name = scanner.next();
                medication.setName(name);
                System.out.println("Medication updated successfully!");
                break;
            case 2:
                System.out.print("Enter new dose: ");
                String dose = scanner.next();
                medication.setDose(dose);
                System.out.println("Medication updated successfully!");
                break;
            case 3:
                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                medication.setQuantity(quantity);
                System.out.println("Medication updated successfully!");
                break;
            case 4:
                System.out.print("Enter new expiration date (dd/MM/yyyy): ");
                String expiryDateStr = scanner.next();
                medication.setExpiryDate(expiryDateStr);
                System.out.println("Medication updated successfully!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    // Remove Methods
    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    // Search Methods
    public void searchPatientByName(String searchTerm) {
        List<Patient> foundPatients = new ArrayList<>();
        String searchTermLower = searchTerm.toLowerCase();
        
        for (Patient patient : patients) {
            if (patient.getFirstName().toLowerCase().contains(searchTermLower) ||
                patient.getLastName().toLowerCase().contains(searchTermLower) ||
                patient.getFullName().toLowerCase().contains(searchTermLower)) {
                foundPatients.add(patient);
            }
        }
        if (foundPatients.isEmpty()) {
            System.out.println("No patients found!");
        } else {
            System.out.println("\nFound " + foundPatients.size() + " patients:");
            for (Patient patient : foundPatients) {
                System.out.println(patient.toString());
            };
        }
    }

    public void searchMedicationByName(String searchTerm) {
        List<Medication> foundMedications = new ArrayList<>();
        String searchTermLower = searchTerm.toLowerCase();
        
        for (Medication medication : medications) {
            if (medication.getName().toLowerCase().contains(searchTermLower)) {
                foundMedications.add(medication);
            }
        }
        if (foundMedications.isEmpty()) {
            System.out.println("No medications found!");
        } else {
            System.out.println("\nFound " + foundMedications.size() + " medications:");
            for (Medication medication : foundMedications) {
                System.out.println(medication.toString());
            }
        }
    }

    public void searchDoctorByName(String searchTerm) {
        List<Doctor> foundDoctors = new ArrayList<>();
        String searchTermLower = searchTerm.toLowerCase();
        
        for (Doctor doctor : doctors) {
            if (doctor.getFirstName().toLowerCase().contains(searchTermLower) ||
                doctor.getLastName().toLowerCase().contains(searchTermLower) ||
                doctor.getFullName().toLowerCase().contains(searchTermLower)) {
                foundDoctors.add(doctor);
            }
        }
        if (foundDoctors.isEmpty()) {
            System.out.println("No doctors found!");
        } else {
            System.out.println("\nFound " + foundDoctors.size() + " doctors:");
            for (Doctor doctor : foundDoctors) {
                System.out.println(doctor.toString());
            }
        }
    }

    public boolean addPatientToDoctor(Patient patient, Doctor doctor) {
        if (patients.contains(patient) && doctors.contains(doctor)) {
            doctor.addPatient(patient);
            return true;
        }
        return false; // Exception handling in case patient or doctor list does not contain the specified patient or doctor
    }

    // Check logic of this (Medication must be in system to create prescription?)
    public boolean acceptPrescription(Doctor doctor, Patient patient, Medication medication) {
        if (doctors.contains(doctor) && patients.contains(patient) && medications.contains(medication)) {
            Prescription prescription = new Prescription(doctor, patient, medication);
            patient.addPrescription(prescription);
            patient.addMedication(medication);
            prescriptions.add(prescription);
            return true;
        }
        return false;
    }

    public void generateSystemReport() {
        StringBuilder report = new StringBuilder();
        report.append("===== SYSTEM REPORT =====\n\n");

        report.append("PATIENTS (" + patients.size() + "):\n");
        for (Patient patient : patients) {
            report.append(patient.getId() + ": " + patient.getFullName() + "\n");
        }

        report.append("\nDOCTORS (" + doctors.size() + "):\n");
        for (Doctor doctor : doctors) {
            report.append(doctor.getId() + ": " + doctor.getFullName() + "\n");
        }

        report.append("\nMEDICATIONS (" + medications.size() + "):\n");
        for (Medication medication : medications) {
            report.append(medication.getId() + ": " + medication.getName() + " - Qty: " + medication.getQuantity() + " - Expiry: " + medication.getExpiryDate() + "\n");
        }

        report.append("\nPRESCRIPTIONS (" + prescriptions.size() + "):\n");
        for (Prescription prescription : prescriptions) {
            String doctorName = prescription.getDoctor().getFullName();
            String patientName = prescription.getPatient().getFullName();
            String medicationName = prescription.getMedication().getName();
            report.append(prescription.getId() + ": Dr. " + doctorName + " - " + patientName + " - " + medicationName + "\n");
        }

        System.out.println(report.toString());
    }

    public List<Medication> checkExpiredDrugs() {
        List<Medication> expiredMedications = new ArrayList<>();
        Date currentDate = new Date();

        for (Medication medication : medications) {
            if (medication.getExpiryDate().before(currentDate)) {
                expiredMedications.add(medication);
            }
        }

        return expiredMedications;
    }

    public List<Prescription> getDoctorPrescriptions(Doctor doctor) {
        List<Prescription> doctorPrescriptions = new ArrayList<>();

        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor().equals(doctor)) {
                doctorPrescriptions.add(prescription);
            }
        }

        return doctorPrescriptions;
    }

    public void restockDrugs() {
        Random random = new Random();
        for (Medication medication : medications) {
            // Add a random amount between 10-50 to the current quantity
            int restockAmount = random.nextInt(41) + 10; // 10-50 inclusive
            medication.setQuantity(medication.getQuantity() + restockAmount);
        }
    }

    public void restockDrug(Medication medication, int amount) {
        if (medications.contains(medication) && amount > 0) {
            medication.setQuantity(medication.getQuantity() + amount);
        }
    }

    public void restockSingleMedication(Scanner scanner) {
        System.out.println("\n===== Restock a Single Medication =====");
    
        if (this.medications.isEmpty()) {
            System.out.println("No medications in the system to restock!");
            return;
        }
    
        System.out.println("Available Medications:");
        for (Medication med : this.medications) {
            System.out.println(med.getId() + ": " + med.getName() 
                    + " (Current Qty: " + med.getQuantity() + ")");
        }
    
        System.out.print("Enter medication ID to restock: ");
        int medicationId = scanner.nextInt();
    
        Medication selectedMedication = getMedicationById(medicationId);
        if (selectedMedication == null) {
            System.out.println("Medication not found!");
            return;
        }
    
        System.out.print("Enter quantity to add: ");
        int quantityToAdd = scanner.nextInt();
        if (quantityToAdd <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }
    
        this.restockDrug(selectedMedication, quantityToAdd);
    
        System.out.println("Medication \"" + selectedMedication.getName() 
                + "\" restocked. New quantity: " + selectedMedication.getQuantity());
    }
    


    // Load test data
    public void loadTestData() {
        TestData testData = new TestData();
        
        // Add medications
        medications.add(testData.med1);
        medications.add(testData.med2);
        medications.add(testData.med3);
        medications.add(testData.med4);
        medications.add(testData.med5);
        
        // Add doctors
        doctors.add(testData.doc1);
        doctors.add(testData.doc2);
        doctors.add(testData.doc3);
        doctors.add(testData.doc4);
        doctors.add(testData.doc5);
        
        // Add patients
        patients.add(testData.pat1);
        patients.add(testData.pat2);
        patients.add(testData.pat3);
        patients.add(testData.pat4);
        patients.add(testData.pat5);
        
        // Add prescriptions
        prescriptions.add(testData.pres1);
        prescriptions.add(testData.pres2);
        prescriptions.add(testData.pres3);
        prescriptions.add(testData.pres4);
        prescriptions.add(testData.pres5);

        // Add Patients to Doctors
        testData.addPatientsToDoctors(doctors, patients);

        System.out.println("\nTest data loaded successfully!");
        System.out.println("Added: 5 medications, 5 doctors, 5 patients, and 5 prescriptions");
    }
}