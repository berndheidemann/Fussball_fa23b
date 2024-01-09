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

    public void increaseHomeGoals() {
        this.homeGoals++;
    }

    public void increaseAwayGoals() {
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

}
