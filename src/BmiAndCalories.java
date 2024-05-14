public class BmiAndCalories {

    public static double calculateBMI(UserInfo user) {
        double weight = user.getWeight();
        double height = user.getHeight();
        return weight / (height * height);
    }

    public static double calorieCalculator(UserInfo user){
        double bmr = 0.0;

        double weight = user.getWeight();
        double height = user.getHeight();
        int age = user.getAge();
        String gender = user.getGender();
        String activity = user.getActivity();

        if(gender.equalsIgnoreCase("male")){
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else if(gender.equalsIgnoreCase("female")){
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        switch (activity) {
            case "Sedentary":
                return bmr * 1.2;
            case "Lightly Active":
                return bmr * 1.375;
            case "Moderately Active":
                return bmr * 1.55;
            case "Very Active":
                return bmr * 1.725;
            case "Extremely Active":
                return bmr * 1.9;
            default:
                return bmr; // Default case, should not happen ideally
        }
    }
}