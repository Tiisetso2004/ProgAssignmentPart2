package org.example;

public class CreateAnimal {

    // Variables with encapsulated access modifiers (protected)
    protected String name;
    protected int age;
    protected String species;
    protected String habitat;

    // Initialised constructor
    public CreateAnimal(String name, int age, String species, String habitat) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.habitat = habitat;
    }

    // Addition of getters to safely access protected variables
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getSpecies() { return species; }
    public String getHabitat() { return habitat;}

}
