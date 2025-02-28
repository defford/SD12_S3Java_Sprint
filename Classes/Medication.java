import java.util.Date;
import java.util.Calendar;
import java.util.Random;

public class Medication {
    private final int id;
    private static int counter = 1;
    private String name;
    private String dose;
    private int quantity;
    private Date expiryDate;

    // Constructor with specific expiry date
    public Medication(String name, String dose, int quantity, Date expiryDate) {
        this.id = counter++;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }
    
    // Constructor with random expiry date (could be in the past or future)
    public Medication(String name, String dose, int quantity) {
        this.id = counter++;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = generateRandomExpiryDate();
    }
    
    // Method to generate a random expiry date (could be in the past or future)
    private Date generateRandomExpiryDate() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        
        // Generate a random amount of days between -365 (1 year in the past) and 730 (2 years in the future)
        int randomDays = random.nextInt(1096) - 365; // -365 to 730 days
        
        calendar.add(Calendar.DAY_OF_YEAR, randomDays);
        return calendar.getTime();
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
        return String.format("""
                \nMedication Details:
                ID: %d
                Name: %s
                Dose: %s
                Quantity: %d
                Expiry Date: %s""",
                getId(), getName(), getDose(), getQuantity(), getExpiryDate().toString());
    }
}