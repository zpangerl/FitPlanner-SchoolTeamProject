package main.java.memoranda;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private BeltRank.Rank belt_rank;
    private BeltRank.Rank training_rank;

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getAge() { return this.age; }
    public BeltRank.Rank getBeltRank() { return this.belt_rank; }
    public BeltRank.Rank getTrainingRank() { return this.training_rank; }


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
        this.belt_rank = inputColor;
    }
    public void setTrainingRank(BeltRank.Rank inputRank) {
        this.training_rank = inputRank;
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
        this.belt_rank = inputBeltRank;
        this.training_rank = inputTrainingRank;
    }
}
