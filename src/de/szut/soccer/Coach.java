package de.szut.soccer;

public class Coach extends Person {

    private int experience;

    // Standardkonstruktor
    // der hier macht gar nix

    public Coach(String name, int age, int experience) {
        // Aufruf des Konstruktors von Person
        super(name, age);
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "\nCoach\n" +
                "name: " + this.name +
                "\nage: " + this.age +
                "\nexperience: " + this.experience;
    }


}
