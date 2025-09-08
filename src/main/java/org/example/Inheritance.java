package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inheritance {

    public static void main(String[] args) {
        // Scanner for user input

        Scanner scanner = new Scanner(System.in);

        // Instantiation of the array list to store every object alongside its attributes

        List<ZooAnimal> zooAnimals = new ArrayList<>();
        System.out.println();

        // User will be prompted to choose preferred amount of objects per session

        System.out.println("**************************************");
        System.out.println("How many animals do you want to enter?");
        System.out.println("**************************************");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // This loop iterates the creation of the amount of objects declared by the user earlier

        for (int i = 0; i < count; i++) {
            ZooAnimal animal = new ZooAnimal();
            animal.nameVerification();
            animal.ageVerification();
            animal.speciesVerification();
            animal.habitatVerification();
            zooAnimals.add(animal); // Addition of new animal object to array list
        }

        // Formatted printing of all the objects declared during the session

        System.out.println();
        System.out.println("*************************");
        System.out.println("All Animal Information:");
        System.out.println("*************************");
        for (ZooAnimal animal : zooAnimals) {
            System.out.println(animal);
        }

        scanner.close();
    }
}
