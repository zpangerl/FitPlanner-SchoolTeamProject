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

    public Student(String inputLastName, String inputFirstName){
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
    }

    public Student(String inputLastName, String inputFirstName, int inputAge, BeltRank.Rank inputBeltRank, BeltRank.Rank inputTrainingRank){
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
        this.age = inputAge;
        this.belt_rank = inputBeltRank;
        this.training_rank = inputTrainingRank;
    }
}
