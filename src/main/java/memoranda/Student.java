package main.java.memoranda;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private BeltRank.Rank beltRank;
    private BeltRank.Rank trainingRank;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public BeltRank.Rank getBeltRank() {
        return this.beltRank;
    }

    public BeltRank.Rank getTrainingRank() {
        return this.trainingRank;
    }

    public void setFirstName(String inputFirstName) {
        this.firstName = inputFirstName;
    }

    public void setLastName(String inputLastName) {
        this.lastName = inputLastName;
    }

    public void setAge(int inputAge) {
        this.age = inputAge;
    }

    public void setBeltColor(BeltRank.Rank inputColor) {
        this.beltRank = inputColor;
    }

    public void setTrainingRank(BeltRank.Rank inputRank) {
        this.trainingRank = inputRank;
    }

    /**
     * Constructor using only the students first and last name.
     * @param inputLastName Last name of student.
     * @param inputFirstName First name of student.
     */
    public Student(String inputLastName, String inputFirstName) {
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
    }

    /**
     * Constructor that takes all student attributes as input.
     *
     * @param inputLastName Students last name.
     * @param inputFirstName Students first name.
     * @param inputAge Students age in years.
     * @param inputBeltRank Students current belt rank.
     * @param inputTrainingRank Students current training rank.
     */
    public Student(
            String inputLastName,
            String inputFirstName,
            int inputAge,
            BeltRank.Rank inputBeltRank,
            BeltRank.Rank inputTrainingRank
    ) {
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
        this.age = inputAge;
        this.beltRank = inputBeltRank;
        this.trainingRank = inputTrainingRank;
    }

    // Reference: Trainer.java (Stovall).
    /**
     * Edit student details and validate to ensure quality input.
     * Some or all of the following may be modified.
     * @param firstName String modified first name to update.
     * @param lastName String modified last name to update.
     * @param age int modified age to update.
     * @param trainingRank BeltRank.Rank modified trainingRank.
     * @param beltRank BeltRank.Rank modified beltRank.
     * @return "" empty if no error, or an error message if validation fails.
     */
    public String editStudent(String firstName, String lastName, int age,
                              BeltRank.Rank trainingRank,
                              BeltRank.Rank beltRank) {
        // validate firstname
        String errorMessage = "";
        errorMessage += validateName(firstName, "firstName");
        errorMessage += validateName(lastName, "lastName");

        // save if validation passes
        if (errorMessage.isEmpty()) {
            setFirstName(firstName);
            setLastName(lastName);
            setBeltColor(beltRank);
            setTrainingRank(trainingRank);
        }

        return errorMessage;
    }

    // Reference: Trainer.java (Stovall)
    /**
     * Validates that name only contains letters (a-z).
     * @param name String to validate.
     * @param parameterName String identifier for error message.
     * @return "" empty if no error, or an error message if validation fails.
     */
    public String validateName(String name, String parameterName) {
        // must not be null
        if (name == null) {
            return parameterName + " must not be null\n";
        }

        // must be between 1-12 characters
        if (name.isEmpty() || name.length() > 12) {
            return parameterName + " must be between 1-12 characters\n";
        }

        // name must only contain letters
        // reference:
        // https://stackoverflow.com/questions/24086968/tell-if-string-contains-a-z-chars
        for (char character : name.toCharArray()) {
            if (!Character.isLetter(character)) {
                return parameterName + " must only contain letters\n";
            }
        }

        return ""; // no issues found
    }
}
