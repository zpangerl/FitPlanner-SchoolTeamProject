package main.java.memoranda.util;

public class Student {
    private String name;
    private int belt_color;
    private int training_rank;

    public String getName() { return this.name; }
    public int getBeltColor() { return this.belt_color; }
    public int getTrainingRank() { return this.training_rank; }

    public void setName(String inputName) { this.name = inputName; }
    public void setBeltColor(int inputColor) { this.belt_color = inputColor; }
    public void setTrainingRank(int inputRank) { this.training_rank = inputRank; }

    public Student(String inputName){
        this.name = inputName;
    }


}
