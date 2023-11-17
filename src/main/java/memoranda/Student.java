package main.java.memoranda;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private BeltRank.Rank beltRank;
    private BeltRank.Rank trainingRank;

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getAge() { return this.age; }
    public BeltRank.Rank getBeltRank() { return this.beltRank; }
    public BeltRank.Rank getTrainingRank() { return this.trainingRank; }


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
    public Student(String inputLastName, String inputFirstName){
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
    public Student(String inputLastName, String inputFirstName, int inputAge, BeltRank.Rank inputBeltRank, BeltRank.Rank inputTrainingRank){
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
        this.age = inputAge;
        this.beltRank = inputBeltRank;
        this.trainingRank = inputTrainingRank;
    }
}
