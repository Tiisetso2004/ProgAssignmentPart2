package org.example;

import java.util.Scanner;

// Instantiation of the  CreateAnimal class with the super constructor
public class ZooAnimal extends CreateAnimal implements iAnimal {

    public ZooAnimal() {
        super("", 0, "", ""); // Placeholder values will be overridden
    }

    /**
     * This method enables the user to verify input (species)
     * It formats the name variable input to ensure it is not empty
     * and does not contain any digits
     */

    @Override
    public String nameVerification() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the animal's name:");
            String input = scanner.nextLine();
            if (input.isEmpty() || input.matches(".*\\d.*")) {
                System.out.println("Invalid name entry. Try again.");
            } else {
                this.name = input;
                System.out.println("Name successfully captured.");
                return name;
            }
        }
    }

    /**
     * This method enables the user to verify input (age)
     * Ensures nothing other than a positive integer is passed as an age variable
     * Returns appropriate error messaging if otherwise
     */

    @Override
    public int ageVerification() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the animal's age:");
            String input = scanner.nextLine();
            try {
                int parsedAge = Integer.parseInt(input);
                if (parsedAge < 0) {
                    System.out.println("Invalid age entry. Try again.");
                } else {
                    this.age = parsedAge;
                    System.out.println("Age successfully captured.");
                    return age;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * This method enables the user to verify input (species)
     * Prevents the species name from being blank (whitespace characters)
     * Ensures the species name does not contain any digits
     */

    @Override
    public String speciesVerification() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the animal's species:");
            String input = scanner.nextLine();
            if (input.isBlank()|| input.length()<4||input.matches(".*\\d.*")) {
                System.out.println("Species name cannot be empty or contain a number or be too short. Try again.");
            } else {
                this.species = input;
                System.out.println("Species successfully captured.");
                return species;
            }
        }
    }

    /**
     * This method enables the verification of the habitat entry
     * Validifies the length and the variable type and valid inputs
     * Prohibits the use of special characters
     * Prevents the field from being empty
     */

    @Override
    public String habitatVerification() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the animal's habitat:");
            String input = scanner.nextLine();
            if (input.isEmpty() || input.matches(".*\\d.*") ||input.contains("`~@#$%^&()_=+{}:;'<>,./?")) {
                System.out.println("Invalid habitat entry. Input cannot contain special characters or be empty .");
            } else {
                this.habitat = input;
                System.out.println("Habitat successfully captured.");
                return habitat;
            }
        }
    }

    /**
     * This method is responsible for printing out a simply formatted report
     * Retrieves the correctly assigned variables using getters and setters
     */

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nAge: " + getAge() +
                "\nSpecies: " + getSpecies() +
                "\nHabitat: " + getHabitat() +
                "\n***************************";
    }
}

