package de.szut.soccer;

import java.util.Random;

public class Player {

    private String name;
    private int age;
    private int force;
    private int powerAtGoalKick;
    private int motivation;
    private int numberOfGoals;

    public Player(
            String name,
            int age,
            int force,
            int powerAtGoalKick,
            int motivation,
            int numberOfGoals
    ) {
        this.name = name;
        this.age = age;
        this.force = force;
        this.powerAtGoalKick = powerAtGoalKick;
        this.motivation = motivation;
        this.numberOfGoals = numberOfGoals;
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

    private int validate(int number) {
        if (number > 10) {
            return 10;
        }
        if (number < 1) {
            return 1;
        }
        return number;
    }
}
