/*
  File:	Trainer.Java
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
    //private BeltRank beltRank; // TODO: waiting for US87
    //private BeltRank trainingRank; // TODO: waiting for US87

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
     * Stores first name of trainer
     * @param firstName of trainer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Stores last name of trainer
     * @param lastName of trainer
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * No parameters
     * @return full name with combined first and last name
     */
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String name;
    private String position;
    // default constructor

    public Trainer() {

    }
    public Trainer(String name, String position) {
        this.name = name;
        this.position = position;
    }

}
