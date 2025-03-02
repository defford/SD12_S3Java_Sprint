import java.util.Date;
import java.util.Calendar;

public class Prescription {
    private static int counter = 1;
    private final int id;    
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private Date prescriptionExpiryDate;

    // Constructor with expiration date provided
    public Prescription(Doctor doctor, Patient patient, Medication medication, Date prescriptionExpiryDate) {
        this.id = counter++;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiryDate = prescriptionExpiryDate;
    }
    
    // Constructor with default 1-year expiration
    public Prescription(Doctor doctor, Patient patient, Medication medication) {
        this.id = counter++;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        
        // Set default expiry to one year from now
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        this.prescriptionExpiryDate = calendar.getTime();
    }

    // Getters
    public int getId() {
        return id;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public Medication getMedication() {
        return medication;
    }   
    public Date getPrescriptionExpiryDate() {
        return prescriptionExpiryDate;
    }

    // Setters

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public void setPrescriptionExpiryDate(Date prescriptionExpiryDate) {
        this.prescriptionExpiryDate = prescriptionExpiryDate;
    }

    // toString
    @Override
    public String toString() {
        return String.format("""
                \nID: %d
                Doctor: %s
                Patient: %s
                Medication: %s
                Prescription Expiry Date: %s""",
                getId(), getDoctor().getFullName(), getPatient().getFullName(), getMedication().getName(), getPrescriptionExpiryDate().toString());
    }
    
}
