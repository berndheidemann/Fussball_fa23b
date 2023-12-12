package de.szut.soccer;

public class SoccerUI {
    public static void main(String[] args) {
        Coach coach = new Coach("Heidemann", 10, 3);
        System.out.println(coach);

        Player p = new Player("Meier", 33, 8, 2, 1, 0);
        System.out.println(p);
        p.addGoal();
        System.out.println(p);

        System.out.println("ShootAtGoal: " + p.shootAtGoal());
    }
}