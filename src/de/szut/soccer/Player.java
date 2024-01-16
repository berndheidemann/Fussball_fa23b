package de.szut.soccer;

import java.util.Random;

public class Player extends Person {


    protected int force;
    protected int powerAtGoalKick;
    protected int motivation;
    protected int numberOfGoals;

    public Player(
            String name,
            int age,
            int force,
            int powerAtGoalKick,
            int motivation,
            int numberOfGoals
    ) {
        super(name, age);

        this.force = validate(force);
        this.powerAtGoalKick = validate(powerAtGoalKick);
        this.motivation = validate(motivation);
        this.numberOfGoals = numberOfGoals;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public void goalScored() {
        this.numberOfGoals++;
    }


    public int getMotivation() {
        return motivation;
    }

    @Override
    public String toString() {
        return "\nPlayer\n" +
                "name: " + this.name +
                "\nage: " + this.age +
                "\nforce: " + this.force +
                "\npowerAtGoalKick: " + this.powerAtGoalKick +
                "\nmotivation: " + this.motivation +
                "\nnumberOfGoals: " + this.numberOfGoals;
    }

    public void addGoal() {
        this.numberOfGoals++;
    }

    public int shootAtGoal() {
        int currentPowerAtGoalKick = this.powerAtGoalKick;
        // verändere den Torschuss um -2 bis +1
        // 0, 1, 2, 3 --> -2
        // -2, -1, 0, 1
        Random rnd = new Random();
        int rndDigit = rnd.nextInt(4);
        rndDigit = rndDigit - 2;
        currentPowerAtGoalKick = currentPowerAtGoalKick + rndDigit;
        return validate(currentPowerAtGoalKick);
    }

    protected int validate(int number) {
        if (number > 10) {
            return 10;
        }
        if (number < 1) {
            return 1;
        }
        return number;
    }

    public int getForce() {
        return this.force;
    }
}
