package de.szut.soccer;

public class Coach {

    private String name;
    private int age;
    private int experience;

    // Standardkonstruktor
    // der hier macht gar nix
    public Coach() {
    }

    public Coach(String name, int age, int experience) {
        this.name = name;
        this.age = age;
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
