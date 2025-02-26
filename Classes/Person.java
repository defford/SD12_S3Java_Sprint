public class Person {
    private int id;
    private String name;
    private int age;
    private String PhoneNumber;

    // Constructor
    public Person(int id, String name, int age, String PhoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.PhoneNumber = PhoneNumber;
    }

    // Getters
    public int getId() {
        return id;
    }   
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
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
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", PhoneNumber=" + PhoneNumber + "]";
    }
    

}