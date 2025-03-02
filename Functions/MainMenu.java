import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Pharmacy Management System =====");
            System.out.println("1. Manage Records (Patients/Doctors/Medications)");
            System.out.println("2. Manage Prescriptions");
            System.out.println("3. Generate Reports");
            System.out.println("4. Inventory Management");
            System.out.println("5. Load Test Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int mainChoice = scanner.nextInt();
            
            switch (mainChoice) {
                case 1:
                    showManageRecordsMenu(scanner, system);
                    break;
                case 2:
                    showPrescriptionMenu(scanner, system);
                    break;
                case 3:
                    showReportsMenu(scanner, system);
                    break;
                case 4:
                    showInventoryMenu(scanner, system);
                    break;
                case 5:
                    system.loadTestData();
                    break;
                case 6:
                    System.out.println("Thank you for using the Pharmacy Management System!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showManageRecordsMenu(Scanner scanner, MedicationTrackingSystem system) {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Manage Records =====");
            System.out.println("1. Add New Record");
            System.out.println("2. Edit Existing Record");
            System.out.println("3. Search Records");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("\n----- Add New Record -----");
                    System.out.println("1. Add Patient");
                    System.out.println("2. Add Doctor");
                    System.out.println("3. Add Medication");
                    System.out.println("4. Back");
                    System.out.print("Enter your choice: ");
                    int addChoice = scanner.nextInt();
                    switch (addChoice) {
                        case 1:
                            system.addPatient(scanner);
                            break;
                        case 2:
                            system.addDoctor(scanner);
                            break;
                        case 3:
                            system.addMedication(scanner);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("\n----- Edit Record -----");
                    System.out.println("1. Edit Patient Details");
                    System.out.println("2. Edit Doctor Details");
                    System.out.println("3. Edit Medication Details");
                    System.out.println("4. Back");
                    System.out.print("Enter your choice: ");
                    int editChoice = scanner.nextInt();
                    switch (editChoice) {
                        case 1:
                            System.out.print("\nPlease choose a patient: \n");
                            for (Patient patient : system.getPatients()) {
                                System.out.println(patient.getId() + ": " + patient.getFullName());
                            }
                            System.out.print("\nSelect patient by ID: ");
                            int patientId = scanner.nextInt();
                            Patient selectedPatient = system.getPatientById(patientId);
                            if (selectedPatient == null) {
                                System.out.println("Patient not found!");
                                break;
                            }
                            system.editPatient(selectedPatient, scanner);
                            break;
                        case 2:
                            System.out.print("\nPlease choose a doctor: \n");
                            for (Doctor doctor : system.getDoctors()) {
                                System.out.println(doctor.getId() + ": " + doctor.getFullName());
                            }
                            System.out.print("\nSelect doctor by ID: ");
                            int doctorId = scanner.nextInt();
                            Doctor selectedDoctor = system.getDoctorById(doctorId);
                            if (selectedDoctor == null) {
                                System.out.println("Doctor not found!");
                                break;
                            }
                            system.editDoctor(selectedDoctor, scanner);
                            break;
                        case 3:
                            System.out.print("\nPlease choose a medication: \n");
                            for (Medication medication : system.getMedications()) {
                                System.out.println(medication.getId() + ": " + medication.getName());
                            }
                            System.out.print("\nSelect medication by ID: ");
                            int medicationId = scanner.nextInt();
                            Medication selectedMedication = system.getMedicationById(medicationId);
                            if (selectedMedication == null) {
                                System.out.println("Medication not found!");
                                break;
                            }
                            system.editMedication(selectedMedication, scanner);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("\n----- Search Records -----");
                    System.out.println("1. Search Patient");
                    System.out.println("2. Search Doctor");
                    System.out.println("3. Search Medication");
                    System.out.println("4. Back");
                    System.out.print("Enter your choice: ");
                    int searchChoice = scanner.nextInt();
                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter patient name: ");
                            scanner.nextLine(); // Clear the buffer
                            String name = scanner.nextLine();
                            system.searchPatientByName(name);
                            break;
                        case 2:
                            System.out.print("Enter doctor name: ");
                            scanner.nextLine(); // Clear the buffer
                            name = scanner.nextLine();
                            system.searchDoctorByName(name);
                            break;
                        case 3:
                            System.out.print("Enter medication name: ");
                            scanner.nextLine(); // Clear the buffer
                            name = scanner.nextLine();
                            system.searchMedicationByName(name);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showPrescriptionMenu(Scanner scanner, MedicationTrackingSystem system) {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Prescription Management =====");
            System.out.println("1. Process New Prescription");
            System.out.println("2. Assign Patient to Doctor");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    system.addPrescription(scanner);
                    break;
                case 2:
                    // Search through entries for patients and doctors, and select their ID
                    System.out.print("\nPlease choose a patient: \n");
                    for (Patient patient : system.getPatients()) {
                        System.out.println(patient.getId() + ": " + patient.getFullName());
                    }
                    System.out.print("\nSelect patient's ID: ");
                    int patientId = scanner.nextInt();
                    Patient patient = system.getPatientById(patientId);
                    if (patient == null) {
                        System.out.println("\nPatient not found!");
                        break;
                    }

                    System.out.print("\nPlease choose a doctor: \n");
                    for (Doctor doctor : system.getDoctors()) {
                        System.out.println(doctor.getId() + ": " + doctor.getFullName());
                    }
                    System.out.print("\nSelect doctor by ID: ");
                    int doctorId = scanner.nextInt();
                    Doctor doctor = system.getDoctorById(doctorId);
                    if (doctor == null) {
                        System.out.println("\nDoctor not found!");
                        break;
                    }
                    
                    system.addPatientToDoctor(patient, doctor);
                    System.out.println("\nPatient " + patient.getFullName() + " added to Dr. " + doctor.getFullName() + " successfully!");
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void showReportsMenu(Scanner scanner, MedicationTrackingSystem system) {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Generate Reports =====");
            System.out.println("1. System Summary Report");
            System.out.println("2. Expired Medications Report");
            System.out.println("3. Doctor's Prescriptions Report");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    system.generateSystemReport();
                    break;
                case 2:
                    // MedicationFunctions.checkExpiredMedications(system);
                    break;
                case 3:
                    // PrescriptionFunctions.printPrescriptionsForDoctor(system);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showInventoryMenu(Scanner scanner, MedicationTrackingSystem system) {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Inventory Management =====");
            System.out.println("1. Restock All Medications (Random)");
            System.out.println("2. Restock a Single Medication (Specify Amount)");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    system.restockDrugs();
                    System.out.println("All medications have been randomly restocked!");
                    break;
                    
                case 2:
                    system.restockSingleMedication(scanner);
                    break;
                    
                case 3:
                    back = true;
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
}
