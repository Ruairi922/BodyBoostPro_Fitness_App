// Main.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel mainScreen;
    private JPanel findBmiAndCalorieScreen;
    private JPanel createWorkoutScreen;


    public JTextField heightField, weightField, ageField, nameField, genderField, activityField;
    public JButton calculateButton, workoutPlanButton;
    public JTextArea resultArea, calorieArea, workoutDescription;









// MAIN-----------------------------------------------------------------------------------------------------------------

    public Main() {
        setTitle("BodyBoost Pro");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        mainScreen = createMainScreen();
        findBmiAndCalorieScreen = createBmiAndCalorieScreen();
        createWorkoutScreen = createWorkoutScreen();


        cardPanel.add(mainScreen, "MainScreen");
        cardPanel.add(findBmiAndCalorieScreen, "findBmiAndCalorieScreen");
        cardPanel.add(createWorkoutScreen, "CreateWorkoutScreen");

        add(cardPanel);


        // Show the Main screen initially
        cardLayout.show(cardPanel, "MainScreen");

        setVisible(true);
    }













    // MAIN SCREEN -----------------------------------------------------------------------------------------------------

    private JPanel createMainScreen() {
        JPanel mainScreen = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(85, 10, 140); // Dark base color for the galaxy effect
                Color color2 = new Color(5, 3, 30); // Lighter galaxy color
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainScreen.setBackground(new Color(0, 0, 0)); // Fallback background

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // Make buttonPanel transparent to show the mainScreen background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton findBmiButton = new JButton("Find BMI");
        findBmiButton.setBackground(new Color(72, 209, 204)); // Neon green
        findBmiButton.setForeground(Color.DARK_GRAY);
        findBmiButton.setFont(new Font("Arial", Font.BOLD, 16));
        findBmiButton.setFocusPainted(false);
        findBmiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "findBmiAndCalorieScreen");
            }
        });

        JButton createWorkoutButton = new JButton("Create Workout");
        createWorkoutButton.setBackground(new Color(72, 209, 204)); // Electric Blue
        createWorkoutButton.setForeground(Color.DARK_GRAY);
        createWorkoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        createWorkoutButton.setFocusPainted(false);
        createWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "CreateWorkoutScreen");
            }
        });

        buttonPanel.add(findBmiButton, gbc);
        gbc.gridy++;
        buttonPanel.add(createWorkoutButton, gbc);

        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setOpaque(false); // Make descriptionPanel transparent
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setForeground(new Color(255, 255, 255)); // White text
        descriptionArea.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        descriptionArea.setFont(new Font("Open Sans", Font.ITALIC, 14));
        descriptionArea.setText("Welcome to the BodyBoost Pro Application!\n\n"
                + "This application is designed to help you track your health and fitness goals. "
                + "You can use it to calculate your BMI, create personalized workout programs, "
                + "and even calculate your daily calorie needs.\n\n"
                + "To get started, simply click on one of the buttons above to access the respective feature.\n\n"
                + "Remember, maintaining a healthy lifestyle is essential for overall well-being. "
                + "Make sure to eat a balanced diet, stay hydrated, and engage in regular physical activity. "
                + "Consult with a healthcare professional before starting any new fitness program or diet plan.\n\n"
                + "Start your journey to a healthier you today!");
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        descriptionPanel.add(descriptionArea, BorderLayout.CENTER);

        mainScreen.add(buttonPanel, BorderLayout.NORTH);
        mainScreen.add(descriptionPanel, BorderLayout.CENTER);

        return mainScreen;
    }



    // BMI AND CALORIE SCREEN ------------------------------------------------------------------------------------------


    private JPanel createBmiAndCalorieScreen() {
        JPanel findBmiPanel = new JPanel(new BorderLayout());
        findBmiPanel.setBackground(new Color(5, 3, 45)); // Light yellow background

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(5, 3, 45)); // Light purple background


        JLabel nameLabel = new JLabel("Enter Name: ");
        JLabel heightLabel = new JLabel("Height (cm):");
        JLabel weightLabel = new JLabel("Weight (kg):");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel activityLabel = new JLabel("Activity Level:");
        Color textColor = new Color(255, 255, 255); // White color, for example

        nameLabel.setForeground(textColor);
        heightLabel.setForeground(textColor);
        weightLabel.setForeground(textColor);
        ageLabel.setForeground(textColor);
        genderLabel.setForeground(textColor);
        activityLabel.setForeground(textColor);

        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        ageField = new JTextField(10);


        Color backgroundColor = new Color(30, 30, 30); // Dark background color, for contrast
        Font textFont = new Font("Arial", Font.PLAIN, 14); // Example font settings
        Font textAreaFont = new Font("Arial Rounded MT Bold", Font.ITALIC, 14);

        nameField.setForeground(textColor);
        nameField.setBackground(backgroundColor);
        nameField.setFont(textFont);

        heightField.setForeground(textColor);
        heightField.setBackground(backgroundColor);
        heightField.setFont(textFont);

        weightField.setForeground(textColor);
        weightField.setBackground(backgroundColor);
        weightField.setFont(textFont);

        ageField.setForeground(textColor);
        ageField.setBackground(backgroundColor);
        ageField.setFont(textFont);

        // Options for gender selection
        String[] genders = {"Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genders);

        // Options for activity level selection
        String[] activityLevels = {"Sedentary", "Lightly Active", "Moderately Active", "Very Active", "Extremely Active"};
        JComboBox<String> activityComboBox = new JComboBox<>(activityLevels);

        calculateButton = new JButton("Calculate BMI");
        calculateButton.setBackground(new Color(72, 209, 204));
        calculateButton.setForeground(Color.BLACK);
        calculateButton.addActionListener(new InputHandler());

        JButton calorieButton = new JButton("Calculate Maintenance Calories");
        calorieButton.setBackground(new Color(72, 209, 204)); // Blue
        calorieButton.setForeground(Color.BLACK);
        calorieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());
                    int age = Integer.parseInt(ageField.getText());
                    String gender = (String) genderComboBox.getSelectedItem();
                    String activityLevel = (String) activityComboBox.getSelectedItem();

                    UserInfo user = new UserInfo(name, height, weight, age, activityLevel, 0, gender);

                    double calories = BmiAndCalories.calorieCalculator(user);
                    String calorieMessage = String.format(
                            "Results:%n" +
                                    "Maintain Weight: %.2f cal%n" +
                                    "Lose Weight: %.2f cal (Reduces by 300 cal/day)%n" +
                                    "Gain Weight: %.2f cal (Increases by 300 cal/day)%n%n" +
                                    "These adjustments aim for a safe weight change of 0.5-1 lb per week.\n " +
                                    "Monitor your progress and adjust as needed. Consult a healthcare provider for personalized advice.",
                            calories, // Maintain Weight
                            calories - 300, // Weight Loss
                            calories + 300 // Weight Gain
                    );
                    calorieArea.setText(calorieMessage);
                    //calorieArea.setText(String.format("%.2f Maintain Weight: %nWeight Loss: %.2f%n", calories, calories - 300));

                } catch (NumberFormatException ex) {
                    calorieArea.setText("Invalid input. Please enter valid numbers.");
                }
            }
        });
        //calorieButton.addActionListener(new InputHandler());

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(255, 82, 82)); // Coral
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainScreen");
            }
        });

        // Result area divided into two sections
        JSplitPane resultSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        resultSplitPane.setDividerLocation(0.5); // Initial divider location

        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);
        resultArea.setFont(textAreaFont);
        resultArea.setBackground(new Color(255, 255, 255));
        resultArea.setForeground(Color.BLACK);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);

        calorieArea = new JTextArea(10, 20);
        calorieArea.setEditable(false);
        calorieArea.setFont(textAreaFont);
        calorieArea.setBackground(new Color(255, 255, 255));
        calorieArea.setForeground(Color.BLACK);
        JScrollPane calorieScrollPane = new JScrollPane(calorieArea);

        resultSplitPane.setLeftComponent(resultScrollPane);
        resultSplitPane.setRightComponent(calorieScrollPane);

        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(nameLabel);
        leftPanel.add(nameField);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(heightLabel);
        leftPanel.add(heightField);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(weightLabel);
        leftPanel.add(weightField);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(ageLabel);
        leftPanel.add(ageField);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(genderLabel);
        leftPanel.add(genderComboBox); // Add gender dropdown menu
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(activityLabel);
        leftPanel.add(activityComboBox); // Add activity level dropdown menu
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(calculateButton);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(calorieButton);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(exitButton);
        leftPanel.add(Box.createVerticalStrut(10));

        findBmiPanel.add(leftPanel, BorderLayout.CENTER);
        findBmiPanel.add(resultSplitPane, BorderLayout.SOUTH); // Add result area

        return findBmiPanel;
    }











    // WORKOUT GENERATOR SCREEN-----------------------------------------------------------------------------------------



    private JPanel createWorkoutScreen() {
        JPanel createWorkoutPanel = new JPanel(new BorderLayout(10, 10));
        // Set the background to match the main screen gradient effect
        createWorkoutPanel.setOpaque(false);

        // Input Panel Setup
        JPanel inputPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(85, 10, 140); // Dark base color
                Color color2 = new Color(5, 3, 30); // Lighter color
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        inputPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Margins around components

        // Components setup with the modified color scheme
        Color textColor = Color.WHITE; // White text color
        Color textColor2 = Color.BLACK; // White text color
        Color fieldColor = new Color(55, 0, 95); // Field background color, slightly darker
        Font textAreaFont = new Font("Arial Rounded MT Bold", Font.ITALIC, 14); // Modern, readable, and stylish

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(10);
        ageField.setBackground(fieldColor);
        ageField.setForeground(textColor);

        JLabel daysLabel = new JLabel("Days per Week (1-4):");
        JTextField daysField = new JTextField(10);
        daysField.setBackground(fieldColor);
        daysField.setForeground(textColor);

        JLabel goalLabel = new JLabel("Fitness Goals:");
        JComboBox<String> goalComboBox = new JComboBox<>(new String[]{"Muscle Gain", "Weight Loss", "Improved Cardiovascular Health", "Functional Fitness"});
        goalComboBox.setBackground(fieldColor);
        goalComboBox.setForeground(textColor);

        JLabel gymAccessLabel = new JLabel("Do you have access to a gym:");
        JComboBox<String> gymComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        gymComboBox.setBackground(fieldColor);
        gymComboBox.setForeground(textColor);

        // Set the foreground color for JLabels to white
        ageLabel.setForeground(textColor);
        daysLabel.setForeground(textColor);
        goalLabel.setForeground(textColor);
        gymAccessLabel.setForeground(textColor);

        // Adding components to the inputPanel
        addInputComponent(inputPanel, gbc, ageLabel, ageField, 0);
        addInputComponent(inputPanel, gbc, daysLabel, daysField, 1);
        addInputComponent(inputPanel, gbc, goalLabel, goalComboBox, 2);
        addInputComponent(inputPanel, gbc, gymAccessLabel, gymComboBox, 3);

        // Result Display with adjusted colors to match the main screen
        JTextArea workoutDescription = new JTextArea("Workout plan will be displayed here.");
        workoutDescription.setFont(textAreaFont); // Apply the font to the JTextArea
        workoutDescription.setEditable(false);
        workoutDescription.setForeground(textColor2);
        workoutDescription.setBackground(new Color(220, 220, 220, 128)); // Dark gray with 50% transparency
        workoutDescription.setBorder(BorderFactory.createLineBorder(new Color(85, 10, 140)));
        JScrollPane scrollPane = new JScrollPane(workoutDescription);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // Button Panel Setup with adjustments for transparency
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setOpaque(false); // Adjusted to match the main screen

        JButton generateWorkoutButton = new JButton("Generate Workout Plan");
        customizeButton1(generateWorkoutButton, new Color(72, 209, 204), Color.DARK_GRAY);

        JButton exitButton = new JButton("Exit");
        customizeButton1(exitButton, new Color(255, 102, 102), Color.WHITE);

        generateWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int age = Integer.parseInt(ageField.getText());
                    int daysPerWeek = Integer.parseInt(daysField.getText());
                    // Assuming necessary variables and logic to determine the workout plan...
                    // String workoutPlan = ...; // Logic to generate the workout plan

                    int goalIndex = goalComboBox.getSelectedIndex(); // Get the selected goal index
                    int gymAccess = gymComboBox.getSelectedIndex(); // Get the selected goal index
                    String gender = "male";

                    // Assuming UserInfo and WorkoutGenerator classes exist and work as before
                    UserInfo user = new UserInfo("", 0, 0, age, "", daysPerWeek, gender);
                    String workoutPlan = WorkoutGenerator.workoutGenerator(user, goalIndex, gymAccess);
                    workoutDescription.setText(workoutPlan);

                    // Update the workout description text area

                    // Revalidate and repaint the panel or its parent to reflect changes
                    createWorkoutPanel.revalidate();
                    createWorkoutPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(createWorkoutPanel, "Invalid input. Please enter valid numbers.");
                }
            }
        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainScreen");
            }
        });

        buttonPanel.add(generateWorkoutButton);
        buttonPanel.add(exitButton);

        // Adding components to the main panel
        createWorkoutPanel.add(inputPanel, BorderLayout.NORTH);
        createWorkoutPanel.add(buttonPanel, BorderLayout.SOUTH);
        createWorkoutPanel.add(scrollPane, BorderLayout.CENTER);

        return createWorkoutPanel;
    }

    private void addInputComponent(JPanel panel, GridBagConstraints gbc, Component label, Component component, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(component, gbc);
    }

    private void customizeButton1(JButton button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setFocusPainted(false);
    }






    // INPUT HANDLER CLASS----------------------------------------------------------------------------------------------


    private class InputHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                // Retrieve user inputs
                String name = nameField.getText();
                double height = Double.parseDouble(heightField.getText()) / 100;
                double weight = Double.parseDouble(weightField.getText());
                int age = Integer.parseInt(ageField.getText());
                String fitnessLevel = "";//(String) activityComboBox.getSelectedItem();
                int daysPerWeek = 0; // Retrieve days per week input
                String gender = "";//(String) genderComboBox.getSelectedItem();;

                // Additional input fields for fitness level and days per week
                // ...

                UserInfo user = new UserInfo(name, height, weight, age, fitnessLevel, daysPerWeek, gender);

                // Calculate BMI
                double bmi = BmiAndCalories.calculateBMI(user);
                double calories = BmiAndCalories.calorieCalculator(user);
                // Display results
                String bmiMessage = "Your BMI is: " + String.format("%.2f", bmi) + ", which classifies you as\n";
                if (bmi < 18.5) {
                    bmiMessage += "Underweight. Consider increasing caloric intake and consult\n with a nutritionist for a balanced diet plan.";
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    bmiMessage += "Normal. Maintain your current lifestyle for continued health.";
                } else if (bmi >= 25 && bmi < 30) {
                    bmiMessage += "Overweight. A moderate reduction in caloric intake\n and increased physical activity is recommended.";
                } else if (bmi >= 30) {
                    bmiMessage += "Obese. It's advisable to consult with a healthcare\n provider for guidance on achieving a healthier weight.";
                }

                // Display results in resultArea
                resultArea.setText(name + ",\n" + bmiMessage);


            } catch (NumberFormatException ex) {
                resultArea.setText("Invalid input. Please enter valid numbers.");
            }
        }
    }

    // MAIN METHOD------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}