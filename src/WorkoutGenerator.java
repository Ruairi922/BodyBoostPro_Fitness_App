import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class responsible for generating personalized workout plans
public class WorkoutGenerator {
    //REQUIRED INFO TO GENERATE PROGRAM
    /*
        days Per Week
        Age
        Fitness Goals, (Give list of 3-4 different options) - 1) Muscle Gain, 2) Weight Loss, 3) Improved Cardiovascular Health, 4) Functional Fitness
        favourite type of cardio (running, cycling, swimming, boxing, skipping)
        Access to a gym (If not - bodyweight exercises)
     */
    // Array of bodyweight cardio exercises


    // Generates a personalized workout plan based on user information
    public static String workoutGenerator(UserInfo user, int goalIndex, int gymAccess) {
        int age = user.getAge();
        int days = user.getDaysPerWeek();
        StringBuilder workout = new StringBuilder("The following is a personalized workout plan for you:\n");

        if(gymAccess == 1){
            String[] bodyweightCardio = {"running", "skipping", "Burpees", "Jumping Jacks"};

            // Arrays of bodyweight strength exercises for different muscle groups
            String[] bodyweightPush = {"Push ups", "Pike Push ups", "Diamond Push ups"};
            String[] bodyweightPull = {"Pull up", "Chin ups", "Inverted Rows"};
            String[] bodyweightLegs = {"Squats (Bodyweight)", "Single Leg Squat", "Lunges", "Step-ups", "Bodyweight Squats"};
            String[] bodyweightCore = {"Sit ups", "Plank", "Side Plank", "Bicycle Crunches", "Leg Raises", "Russian Twists"};

            List<String> selectedCardioNoGym = new ArrayList<>(List.of(bodyweightCardio));
            List<String> selectedStrengthPushNoGym  = new ArrayList<>(List.of(bodyweightPush));
            List<String> selectedStrengthPullNoGym  = new ArrayList<>(List.of(bodyweightPull));
            List<String> selectedStrengthLegsNoGym  = new ArrayList<>(List.of(bodyweightLegs));
            List<String> selectedStrengthCoreNoGym  = new ArrayList<>(List.of(bodyweightCore));
            Random random = new Random();
            if (days == 1){

                workout.append("Day 1:");
                workout.append(getRandomExercise(selectedStrengthPushNoGym, random)).append(", "); // Add a random push exercise
                workout.append(getRandomExercise(selectedStrengthPullNoGym, random)).append(", "); // Add a random pull exercise
                workout.append(getRandomExercise(selectedStrengthCoreNoGym, random)).append(", "); // Add a random pull exercise
                workout.append(getRandomExercise(selectedStrengthLegsNoGym, random)).append("\n"); // Add a random leg exercise
                workout.append(getRandomExercise(selectedCardioNoGym, random)).append(", "); // Add a random cardio exercise

            } else if (days == 2) { // Full body workouts for efficient strength and fitness gain
                for (int i = 0; i < days; i++) {
                    workout.append("Day ").append(i + 1).append(": ");
                    workout.append(getRandomExercise(selectedStrengthPushNoGym, random)).append(", "); // Add a random push exercise
                    workout.append(getRandomExercise(selectedStrengthPullNoGym, random)).append(", "); // Add a random pull exercise
                    workout.append(getRandomExercise(selectedStrengthCoreNoGym, random)).append(", "); // Add a random pull exercise
                    workout.append(getRandomExercise(selectedStrengthLegsNoGym, random)).append("\n"); // Add a random leg exercise
                    //workout.append(getRandomExercise(selectedCardio, random)).append(", "); // Add a random cardio exercise
                }
            } else if (days == 3) { // Push pull legs split for hitting every muscle group
                workout.append("Day 1: ").append(getRandomExercise(selectedStrengthPushNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPushNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPushNoGym, random)).append("\n");
                workout.append("Day 2: ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append("\n");
                workout.append("Day 3: ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append("\n");
            } else if (days == 4) { // Upper Lower Split for hitting muscle groups twice per week
                workout.append("Day 1: ").append(getRandomExercise(selectedStrengthPushNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append("\n");
                workout.append("Day 2: ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthCoreNoGym, random)).append("\n");
                workout.append("Day 3: ").append(getRandomExercise(selectedStrengthPushNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPushNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append("\n");
                workout.append("Day 4: ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append(", ").append(getRandomExercise(selectedStrengthCoreNoGym, random)).append("\n");
            }

            workout.append("\n");
            workout.append("-------------------------------");
            workout.append("\n");

            // Append additional exercises based on fitness goals
            switch (goalIndex) {
                case 0: // Muscle Gain
                    workout.append("Additional exercises for Muscle Gain (Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedStrengthPushNoGym, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append("\n");
                    break;
                case 1: // Weight Loss
                    workout.append("Additional exercises for Weight Loss(Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedCardioNoGym, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedCardioNoGym, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedCardioNoGym, random)).append("\n");
                    break;
                case 2: // Improved Cardiovascular Health
                    workout.append("Additional exercises for Improved Cardiovascular Health(Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedCardioNoGym, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedCardioNoGym, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedCardioNoGym, random)).append("\n");
                    break;
                case 3: // Functional Fitness
                    workout.append("Additional exercises for Functional Fitness(Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedStrengthCoreNoGym, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedStrengthPullNoGym, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedStrengthLegsNoGym, random)).append("\n");
                    workout.append("Exercise 4) ").append(getRandomExercise(selectedCardioNoGym, random)).append("\n");
                    break;
                default:
                    break;
            }

            switch (goalIndex) {
                case 0: // Muscle Gain
                    workout.append("\nFor muscle gain with bodyweight exercises, focus on 3-6 sets of as many reps as possible (AMRAP).\n");
                    workout.append("Progress to more challenging variations as you improve.\n\n");
                    break;
                case 1: // Weight Loss
                    workout.append("\nFor weight loss, utilize high-intensity circuits with minimal rest.\n");
                    workout.append("Aim for 3-4 rounds, including exercises like burpees, jump squats, and mountain climbers.\n\n");
                    break;
                case 2: // Improved Cardiovascular Health
                    workout.append("\nIncorporate HIIT with bodyweight exercises for cardiovascular health.\n");
                    workout.append("Sessions can include intervals of 30 seconds of work followed by 30 seconds of rest.\n\n");
                    break;
                case 3: // Functional Fitness
                    workout.append("\nFor functional fitness, include a variety of bodyweight exercises that challenge balance, agility, and strength.\n");
                    workout.append("Aim for 2-4 sets of 8-15 reps, adjusting the exercises to increase difficulty as needed.\n\n");
                    break;
                default:
                    workout.append("\nPlease select a valid fitness goal.\n\n");
                    break;
            }
        }else{


            // Array of available cardio exercises
            String[] cardio = {"running", "boxing", "cycling", "skipping", "Burpees", "Jumping Jacks"};

            // Arrays of strength exercises for different muscle groups
            String[] strengthPush = {"Bench press", "Shoulder Press", "Push ups", "Pike Push ups", "Diamond Push ups", "Dumbbell Bench Press"};
            String[] strengthPull = {"Pull up", "Rows", "Lat pull down", "Chin ups", "Inverted Rows", "Single Arm Dumbbell Rows"};
            String[] strengthLegs = {"Squats (Bodyweight or Barbell)", "Deadlifts", "Single Leg Squat", "Lunges", "Step-ups", "Bodyweight Squats"};
            String[] strengthCore = {"Sit ups", "Plank", "Side Plank", "Bicycle Crunches", "Leg Raises", "Russian Twists"};




            // Determine user's fitness level based on age
            String fitnessLevel;
            if (age < 18) {
                fitnessLevel = "Beginner";
            } else if (age < 40) {
                fitnessLevel = "Intermediate";
            } else {
                fitnessLevel = "Advanced";
            }

            // Create lists for each exercise category
            List<String> selectedCardio = new ArrayList<>(List.of(cardio));
            List<String> selectedStrengthPush = new ArrayList<>(List.of(strengthPush));
            List<String> selectedStrengthPull = new ArrayList<>(List.of(strengthPull));
            List<String> selectedStrengthLegs = new ArrayList<>(List.of(strengthLegs));
            List<String> selectedStrengthCore = new ArrayList<>(List.of(strengthCore));

            // Design workout plan for the specified number of days per week
            Random random = new Random();
            if (days == 1){

                workout.append("Day 1:");
                workout.append(getRandomExercise(selectedStrengthPush, random)).append(", "); // Add a random push exercise
                workout.append(getRandomExercise(selectedStrengthPull, random)).append(", "); // Add a random pull exercise
                workout.append(getRandomExercise(selectedStrengthCore, random)).append(", "); // Add a random pull exercise
                workout.append(getRandomExercise(selectedStrengthLegs, random)).append("\n"); // Add a random leg exercise
                workout.append(getRandomExercise(selectedCardio, random)).append(", "); // Add a random cardio exercise

            } else if (days == 2) { // Full body workouts for efficient strength and fitness gain
                for (int i = 0; i < days; i++) {
                    workout.append("Day ").append(i + 1).append(": ");
                    workout.append(getRandomExercise(selectedStrengthPush, random)).append(", "); // Add a random push exercise
                    workout.append(getRandomExercise(selectedStrengthPull, random)).append(", "); // Add a random pull exercise
                    workout.append(getRandomExercise(selectedStrengthCore, random)).append(", "); // Add a random pull exercise
                    workout.append(getRandomExercise(selectedStrengthLegs, random)).append("\n"); // Add a random leg exercise
                    //workout.append(getRandomExercise(selectedCardio, random)).append(", "); // Add a random cardio exercise
                }
            } else if (days == 3) { // Push pull legs split for hitting every muscle group
                workout.append("Day 1: ").append(getRandomExercise(selectedStrengthPush, random)).append(", ").append(getRandomExercise(selectedStrengthPush, random)).append(", ").append(getRandomExercise(selectedStrengthPush, random)).append("\n");
                workout.append("Day 2: ").append(getRandomExercise(selectedStrengthPull, random)).append(", ").append(getRandomExercise(selectedStrengthPull, random)).append(", ").append(getRandomExercise(selectedStrengthPull, random)).append("\n");
                workout.append("Day 3: ").append(getRandomExercise(selectedStrengthLegs, random)).append(", ").append(getRandomExercise(selectedStrengthLegs, random)).append(", ").append(getRandomExercise(selectedStrengthCore, random)).append("\n");
            } else if (days == 4) { // Upper Lower Split for hitting muscle groups twice per week
                workout.append("Day 1: ").append(getRandomExercise(selectedStrengthPush, random)).append(", ").append(getRandomExercise(selectedStrengthPull, random)).append(", ").append(getRandomExercise(selectedStrengthPull, random)).append("\n");
                workout.append("Day 2: ").append(getRandomExercise(selectedStrengthLegs, random)).append(", ").append(getRandomExercise(selectedStrengthLegs, random)).append(", ").append(getRandomExercise(selectedStrengthCore, random)).append("\n");
                workout.append("Day 3: ").append(getRandomExercise(selectedStrengthPush, random)).append(", ").append(getRandomExercise(selectedStrengthPush, random)).append(", ").append(getRandomExercise(selectedStrengthPull, random)).append("\n");
                workout.append("Day 4: ").append(getRandomExercise(selectedStrengthLegs, random)).append(", ").append(getRandomExercise(selectedStrengthLegs, random)).append(", ").append(getRandomExercise(selectedStrengthCore, random)).append("\n");
            }

            workout.append("\n");
            workout.append("-------------------------------");
            workout.append("\n");

            // Append additional exercises based on fitness goals
            switch (goalIndex) {
                case 0: // Muscle Gain
                    workout.append("Additional exercises for Muscle Gain (Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedStrengthPush, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedStrengthPull, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedStrengthLegs, random)).append("\n");
                    break;
                case 1: // Weight Loss
                    workout.append("Additional exercises for Weight Loss(Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedCardio, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedCardio, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedCardio, random)).append("\n");
                    break;
                case 2: // Improved Cardiovascular Health
                    workout.append("Additional exercises for Improved Cardiovascular Health(Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedCardio, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedCardio, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedCardio, random)).append("\n");
                    break;
                case 3: // Functional Fitness
                    workout.append("Additional exercises for Functional Fitness(Add these exercises where suitable to your program):\n");
                    workout.append("Exercise 1) ").append(getRandomExercise(selectedStrengthCore, random)).append("\n");
                    workout.append("Exercise 2) ").append(getRandomExercise(selectedStrengthPull, random)).append("\n");
                    workout.append("Exercise 3) ").append(getRandomExercise(selectedStrengthLegs, random)).append("\n");
                    workout.append("Exercise 4) ").append(getRandomExercise(selectedCardio, random)).append("\n");
                    break;
                default:
                    break;
            }

            //SETS AND REPS LOGIC
            switch (goalIndex) {
                case 0: // Muscle Gain
                    workout.append("\n");
                    workout.append("For muscle gain, aim for 3-6 sets of 8-12 reps per exercise.\n");
                    workout.append("Use weights that are challenging enough to reach muscle fatigue within this rep range.\n");
                    workout.append("Ensure to include a mix of compound and isolation exercises for balanced growth.\n\n");
                    break;
                case 1: // Weight Loss
                    workout.append("\n");
                    workout.append("For weight loss, focus on high-intensity circuit training with 3-4 sets of 10-15 reps per exercise.\n");
                    workout.append("This approach helps maximize calorie burn during and after your workout.\n");
                    workout.append("Combine strength training with cardio sessions for optimal results.\n\n");
                    break;
                case 2: // Improved Cardiovascular Health
                    workout.append("\n");
                    workout.append("For improved cardiovascular health, incorporate at least 150 minutes of moderate-intensity or 75 minutes of high-intensity cardio per week.\n");
                    workout.append("Interval training can be especially effective.\n");
                    workout.append("Strength training circuits with minimal rest can also support cardiovascular fitness.\n\n");
                    break;
                case 3: // Functional Fitness
                    workout.append("\n");
                    workout.append("For functional fitness, prioritize exercises that mimic everyday activities, aiming for 2-4 sets of 8-15 reps.\n");
                    workout.append("Focus on control and form, using a variety of exercises that enhance strength, flexibility, and balance.\n\n");
                    break;
                default:
                    workout.append("\n");
                    workout.append("Please select a valid fitness goal.\n\n");
                    break;
            }

            return workout.toString();
        }

        return workout.toString();
    }

    // Helper method to get a random exercise from a list and remove it
    private static String getRandomExercise(List<String> exercises, Random random) {
        if (exercises.isEmpty()) {
            return "Rest"; // Add a rest day if the category is empty
        }

        int randomIndex = random.nextInt(exercises.size());
        return exercises.remove(randomIndex);
    }




}



