public class UserInfo {
    // Attributes
    public String name;
    public double height;
    private double weight;
    public int age;
    private String activity;
    private int daysPerWeek;
    private String gender;

    // Constructor
    public UserInfo(String name, double height, double weight, int age, String activity, int daysPerWeek, String gender) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.activity = activity;
        this.daysPerWeek = daysPerWeek;
        this.gender = gender;
    }

    // Getter and setter methods for activity level
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    // Getter and setter methods for days per week
    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public void setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Getter and setter methods for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getter and setter methods for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and setter methods for gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}