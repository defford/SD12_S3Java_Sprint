import java.util.List;

public class Patient extends Person { 
    // Patient inherits from Person
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    // Constructor  
    public Patient(String firstName, String lastName, int age, String PhoneNumber, List<Medication> medications, List<Prescription> prescriptions) {
        super(firstName, lastName, age, PhoneNumber);
        this.medications = medications;
        this.prescriptions = prescriptions;
    }

    // Getters
    public List<Medication> getMedications() {
        return medications;
    }
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public String getMedicationsAsString() {
        String medicationsStr = "";
        for (Medication medication : getMedications()) {
            medicationsStr += medication.toString() + "\n";
        };
        return medicationsStr;
    }

    public String getPrescriptionsAsString() {
        String prescriptionsStr = "";
        for (Prescription prescription : getPrescriptions()) {
            prescriptionsStr += prescription.toString() + "\n";
        };
        return prescriptionsStr;
    }

    // Setters
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public void setPhoneNumber(String PhoneNumber) {
        super.setPhoneNumber(PhoneNumber);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }   

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    // toString
    @Override
    public String toString() {
        return String.format("""
                \nID: %s
                Name: %s
                Age: %d
                Phone Number: %s
                Medications: %s
                Prescriptions: %s""",
                getId(), getFullName(), getAge(), getPhoneNumber(), getMedicationsAsString(), getPrescriptionsAsString());
    }
    

}