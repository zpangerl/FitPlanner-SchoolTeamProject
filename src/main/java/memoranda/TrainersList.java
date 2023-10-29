package main.java.memoranda;

import nu.xom.Document;

import java.util.Vector;

public interface TrainersList {
    Vector getAllTrainers();
    Trainer getTrainer(String name);

    void addTrainer(String name, String position);
    void removeTrainer(String name);
    int getAllTrainersCount();
    Document getXMLContent();
}
