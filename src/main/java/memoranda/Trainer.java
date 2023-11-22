/*
  File: Trainer.Java
  Author: Rhett Harrison (original code)
  Author: Steven Stovall (modified: US86, Task117 - simplified memoranda code)
  Version: 2023.11.04

  Description: Stores Trainer an associated attributes to be used in TrainersList.java.
*/

package main.java.memoranda;

import java.io.Serializable;

/**
 Class: Trainer

 Description: Stores Trainer attributes first name, last name, training rank, and belt ranking.
 */
public class Trainer implements Serializable {
    // class variables
    private String firstName;
    private String lastName;
    private BeltRank.Rank trainingRank;
    private BeltRank.Rank beltRank;

    /**
     * default constructor.
     */
    public Trainer() {

    }

    /**
     * Constructor to create new Trainer.
     * @param firstName first name of trainer
     * @param lastName last name of trainer
     * @param trainingRank training rank
     * @param beltRank belt rank
     */
    public Trainer(String firstName, String lastName,
                   BeltRank.Rank trainingRank, BeltRank.Rank beltRank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.trainingRank = trainingRank;
        this.beltRank = beltRank;
    }

    /**
     * Returns first name of trainer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name of trainer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return full name (firstName lastName).
     * @return full name with combined first and last name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Return training rank.
     * @return BeltRank training rank
     */
    public BeltRank.Rank getTrainingRank() {
        return trainingRank;
    }

    /**
     * Return belt rank.
     * @return BeltRank belt rank
     */
    public BeltRank.Rank getBeltRank() {
        return beltRank;
    }

    /**
     * Set first name.
     * @param firstName first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set last name.
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set training rank.
     * @param trainingRank training rank
     */
    public void setTrainingRank(BeltRank.Rank trainingRank) {
        this.trainingRank = trainingRank;
    }

    /**
     * Set belt rank.
     * @param beltRank belt rank
     */
    public void setBeltRank(BeltRank.Rank beltRank) {
        this.beltRank = beltRank;
    }

    /**
     * Edit trainer details and validate to ensure quality input.
     * Some or all of the following may be modified.
     * @param firstName String modified first name to update.
     * @param lastName String modified last name to update.
     * @param trainingRank BeltRank.Rank modified trainingRank.
     * @param beltRank BeltRank.Rank modified beltRank.
     * @return "" empty if no error, or an error message if validation fails.
     */
    public String editTrainer(String firstName, String lastName,
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
            setBeltRank(beltRank);
            setTrainingRank(trainingRank);
        }

        return errorMessage;
    }

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
