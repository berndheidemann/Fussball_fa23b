package de.szut.soccer;

import java.util.Random;

public class Goalkeeper extends Player {

    private int reaction;

    public Goalkeeper(String name,
                      int age,
                      int force,
                      int powerAtGoalKick,
                      int motivation,
                      int reaction
    ) {
        // wir rufen hier den Konstruktor von Player auf und übergeben alle relevanten Variablen
        // JEDER Goalkeeper muss auch ein valider Player sein, darum muss der Konstruktor aufgerufen werden
        super(name, age, force, powerAtGoalKick, motivation, 0);
        this.reaction = validate(reaction);
    }


    @Override
    public String toString() {
        return "\nGoalkeeper\n" +
                "name: " + this.name +
                "\nage: " + this.age +
                "\nforce: " + this.force +
                "\npowerAtGoalKick: " + this.powerAtGoalKick +
                "\nmotivation: " + this.motivation +
                "\nnumberOfGoals: " + this.numberOfGoals +
                "\nreaction: " + this.reaction;
    }

    public boolean ballHold(int powerAtGoalKick) {
        int currentReaction = this.reaction;
        Random rnd = new Random();
        //                        -1 , 0 , 1
        currentReaction += rnd.nextInt(3) - 1;
        if (currentReaction >= powerAtGoalKick) {
            return true;
        } else {
            return false;
        }
    }


}
