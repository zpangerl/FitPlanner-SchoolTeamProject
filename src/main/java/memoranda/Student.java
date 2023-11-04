package main.java.memoranda;

public class Student {
    private String firstName;
    private String lastName;
    private BeltRank belt_color;
    private BeltRank training_rank;

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public BeltRank getBeltColor() { return this.belt_color; }
    public BeltRank getTrainingRank() { return this.training_rank; }

    public void setFirstName(String inputFirstName) { this.firstName = inputFirstName; }
    public void setLastName(String inputLastName) { this.lastName = inputLastName; }
    public void setBeltColor(BeltRank inputColor) { this.belt_color = inputColor; }
    public void setTrainingRank(BeltRank inputRank) { this.training_rank = inputRank; }

    public Student(String inputLastName, String inputFirstName){
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
    }

    public Student(String inputLastName, String inputFirstName, BeltRank inputBeltColor, BeltRank inputTrainingRank){
        this.lastName = inputLastName;
        this.firstName = inputFirstName;
        this.belt_color = inputBeltColor;
        this.training_rank = inputTrainingRank;
    }
}
