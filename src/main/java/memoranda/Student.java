package main.java.memoranda;

public class Student {
    private String firstName;
    private String lastName;
    private BeltRank.Rank belt_color;
    private BeltRank.Rank training_rank;

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public BeltRank.Rank getBeltColor() { return this.belt_color; }
    public BeltRank.Rank getTrainingRank() { return this.training_rank; }

    public void setFirstName(String inputFirstName) {
        this.firstName = inputFirstName;
    }
    public void setLastName(String inputLastName) {
        this.lastName = inputLastName;
    }
    public void setBeltColor(BeltRank.Rank inputColor) {
        this.belt_color = inputColor;
    }
    public void setTrainingRank(BeltRank.Rank inputRank) {
        this.training_rank = inputRank;
    }

    public Student(String inputLastName, String inputFirstName){
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
    }

    public Student(String inputLastName, String inputFirstName, BeltRank.Rank inputBeltColor, BeltRank.Rank inputTrainingRank){
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
        this.belt_color = inputBeltColor;
        this.training_rank = inputTrainingRank;
    }
}
