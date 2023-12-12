package de.szut.soccer;

public class SoccerUI {
    public static void main(String[] args) {

        Coach coach = new Coach("Heidemann", 10, 3);
        //System.out.println(coach)

        coach.name = "Foo";
        Player p = new Player("Meier", 33, 8, 7, 1, 0);
        //System.out.println(p);
        p.addGoal();
        //System.out.println(p);

        // System.out.println("ShootAtGoal: " + p.shootAtGoal());


        Goalkeeper keeper = new Goalkeeper("Max", 21, 99, -20, 8, 7);
        System.out.println(keeper);

        // wir bekommen die aktuelle Schussstärke des Spielers p
        int shotPower = p.shootAtGoal();
        // wir übergeben die Schussstärke an den Torwart keeper
        // und bekommen einen boolean zurück
        boolean hold = keeper.ballHold(shotPower);
        if (hold) {
            System.out.println("gehalten");
        } else {
            System.out.println("nicht gehalten");
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(keeper.ballHold(p.shootAtGoal()) ? "gehalten" : "Toooor!!!!");
        }

    }
}