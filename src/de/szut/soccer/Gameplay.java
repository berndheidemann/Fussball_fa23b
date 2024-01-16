package de.szut.soccer;

import java.util.Random;

public class Gameplay {

    private static final int PLAYING_TIME = 90;
    private static final int MAX_ADDITIONAL_TIME = 5;
    private static final int MAX_DURATION_UNTIL_NEXT_ACTION = 15;

    private Game game;

    public Gameplay(Game game) {
        this.game = game;
    }

    private int calculateForceOfTheTeam(Team team) {
        int totalForce = team.getTotalMotivation() * team.getTotalForce() * team.getCoach().getExperience();

        Random rnd = new Random();
        totalForce += rnd.nextInt(7) - 3;
        if (totalForce < 1) {
            totalForce = 1;
        }
        return totalForce;
    }

    private void doGameAction(Player player, Goalkeeper goalkeeper, int minute, Team team) {
        System.out.println(minute + ". Minute: ");
        System.out.println(" Chance fuer " + team.getName() + " ...");
        System.out.println("   " + player.getName() + " zieht ab");
        if (!goalkeeper.ballHold(player.shootAtGoal())) {
            game.goalScored(team);
            player.goalScored();
            System.out.println(
                    "   TOR!!!   " +
                            this.game.getScore() +
                            " " + player.getName() +
                            "(" +
                            player.getNumberOfGoals() +
                            ")");
        } else {
            System.out.println("   " + goalkeeper.getName() + " pariert glanzvoll.");
        }
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("da ist was schief gegangen");
        }
    }

    public void play() {

        System.out.println(game);
        Random rnd = new Random();
        int timeMax = PLAYING_TIME + rnd.nextInt(MAX_ADDITIONAL_TIME + 1);
        int currentMinute = 0;
        while (currentMinute < timeMax) {
            int nextAction = rnd.nextInt(MAX_DURATION_UNTIL_NEXT_ACTION + 1);
            currentMinute += nextAction;

            int homeValue = calculateForceOfTheTeam(game.getHome());
            int awayValue = calculateForceOfTheTeam(game.getAway());

            int rndValue = rnd.nextInt(homeValue + awayValue);
            if (rndValue < homeValue) {
                // Home ist dran
                doGameAction(game.getHome().getRandomPlayer(), game.getAway().getGoalkeeper(), currentMinute, game.getHome());
            } else {
                // Auswärts ist dran
                doGameAction(game.getAway().getRandomPlayer(), game.getHome().getGoalkeeper(), currentMinute, game.getAway());

            }
            delay();


        }
        System.out.println(game.getScore());

    }


}
