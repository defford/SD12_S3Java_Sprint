import java.util.Date;

public class Medication {
    private int id;
    private String name;
    private String dose;
    private int quantity;
    private Date expiryDate;

    // Constructor
    public Medication(int id, String name, String dose, int quantity, Date expiryDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }       
    public String getDose() {
        return dose;
    }
    public int getQuantity() {
        return quantity;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDose(String dose) {
        this.dose = dose;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }       

    // toString
    @Override
    public String toString() {
        return "Medication [id=" + id + ", name=" + name + ", dose=" + dose + ", quantity=" + quantity + ", expiryDate=" + expiryDate + "]";
    }


}