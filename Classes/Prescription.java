import java.util.Date;

public class Prescription {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private Date prescriptionExpiryDate;

    // Constructor
    public Prescription(int id, Doctor doctor, Patient patient, Medication medication, Date prescriptionExpiryDate) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiryDate = prescriptionExpiryDate;
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
    public void setId(int id) {
        this.id = id;
    }
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
        return "Prescription [id=" + id + ", doctor=" + doctor + ", patient=" + patient + ", medication=" + medication + ", prescriptionExpiryDate=" + prescriptionExpiryDate + "]";
    }
    
}


