/*
  File: Trainer.Java
  Author: Rhett Harrison (original code)
  Author: Steven Stovall (modified: US86, Task117 - simplified memoranda code)
  Version: 2023.11.04

  Description: Stores Trainer an associated attributes to be used in TrainersList.java
*/
package main.java.memoranda;

/**
 Class:	Trainer

 Description: Stores Trainer attributes first name, last name, training rank, and belt ranking
 */
public class Trainer {
    // class variables
    private String firstName;
    private String lastName;
    private BeltRank.Rank trainingRank;
    private BeltRank.Rank beltRank;

    /**
     * default constructor
     */
    public Trainer() {

    }
    /**
     * Constructor to create new Trainer
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
     * Returns first name of trainer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name of trainer
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return full name (firstName lastName)
     * @return full name with combined first and last name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Return training rank
     * @return BeltRank training rank
     */
    public BeltRank.Rank getTrainingRank() {
        return trainingRank;
    }

    /**
     * Return belt rank
     * @return BeltRank belt rank
     */
    public BeltRank.Rank getBeltRank() {
        return beltRank;
    }

    /**
     * Set first name
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set last name
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set training rank
     * @param trainingRank training rank
     */
    public void setTrainingRank(BeltRank.Rank trainingRank) {
        this.trainingRank = trainingRank;
    }

    /**
     * Set belt rank
     * @param beltRank belt rank
     */
    public void setBeltRank(BeltRank.Rank beltRank) {
        this.beltRank = beltRank;
    }

}
