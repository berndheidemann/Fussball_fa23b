package de.szut.soccer;

import java.util.StringJoiner;

public class Game {

    private Team home;
    private Team away;
    private int homeGoals;
    private int awayGoals;

    public Game(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    private void increaseHomeGoals() {
        this.homeGoals++;
    }

    private void increaseAwayGoals() {
        this.awayGoals++;
    }

    public String toString() {
        return this.home.getName() + " - " + this.away.getName();
    }

    public String getScore() {
        StringJoiner joined = new StringJoiner(" ");
        joined.add(this.home.getName());
        joined.add(Integer.toString(this.homeGoals));
        joined.add(" - ");
        joined.add(Integer.toString(this.awayGoals));
        joined.add(this.away.getName());
        return joined.toString();
    }

    public void goalScored(Team team) {
        if (home == team) {
            increaseHomeGoals();
        } else {
            increaseAwayGoals();
        }
    }

    public Team getHome() {
        return this.home;
    }

    public Team getAway() {
        return away;
    }
}
