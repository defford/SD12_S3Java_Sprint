public class Person {
    private static int counter = 1;
    private final int id;
    private String firstName;
    private String lastName;
    private int age;
    private String PhoneNumber;

    // Constructor
    public Person(String firstName, String lastName, int age, String PhoneNumber) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.PhoneNumber = PhoneNumber;
    }

    // Getters
    public int getId() {
        return id;
    }   
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }       

    // toString
    @Override   
    public String toString() {
        return "Person [id=" + id + ", name=" + getFullName() + ", age=" + age + ", PhoneNumber=" + PhoneNumber + "]";
    }
}