package de.szut.soccer;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Team {

    private final int PLAYER_ON_FIELD = 10;
    private String name;
    private Coach coach;
    private Goalkeeper goalkeeper;
    // Arraylist gefüllt mit Player-Objekten
    // Deklaration
    private ArrayList<Player> squad;
    public Team(String name, Coach coach, Goalkeeper goalkeeper) {
        this.name = name;
        this.coach = coach;
        this.goalkeeper = goalkeeper;
        // Initialisierung
        this.squad = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.squad.add(player);
    }

    public int getTotalMotivation() {
        // Variante 1
        int sum = 0;
        for (int i = 0; i < this.squad.size(); i++) {
            sum += this.squad.get(i).getMotivation();
        }

        // Variante 2
        sum = 0;
        for (Player player : this.squad) {
            sum += player.getMotivation();
        }

        sum += this.goalkeeper.getMotivation();
        return sum / (this.squad.size() + 1);
    }

    public int getTotalForce() {
        int sum = 0;
        int playerCount = Math.min(this.squad.size(), PLAYER_ON_FIELD - 1);
        for (int i = playerCount; i > 0; i--) {
            sum += this.squad.get(i).getForce();
        }
        sum += this.goalkeeper.getForce();

        return sum / (playerCount + 1);
    }

    @Override
    public String toString() {
        StringJoiner response = new StringJoiner("\n");
        response.add("***Mannschaft***");
        response.add("Trainer: " + this.coach.getName());
        response.add("Torwart: " + this.goalkeeper.getName());
        for (Player player : this.squad) {
            response.add("Spieler: " + player.getName());
        }
        return response.toString();
    }
}
