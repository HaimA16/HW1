/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza
 */
package System;
import java.util.Scanner;
import Animals.*;
import Olympics.*;

public class AnimalAttributes {
    String name;
    Animal.Gender gender;
    double weight;
    double speed;
    Medal[] medals;

public void input(AnimalAttributes attributes) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter animal name: ");
    attributes.name = sc.next();

    while (true) {
        try {
            System.out.print("Enter animal gender (Male, Female, Hermaphrodite): ");
            String genderStr = sc.next();
            attributes.gender = Animal.Gender.valueOf(genderStr.toUpperCase());
            break;
        } catch (Exception e) {
            System.out.println("Invalid gender. Please enter 'Male', 'Female', or 'Hermaphrodite'.");
        }
    }

    while (true) {
        try {
            System.out.print("Enter animal weight: ");
            attributes.weight = sc.nextDouble();
            if (attributes.weight <= 0) {
                System.out.println("Weight must be positive.");
                continue;
            }
            break;
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid weight.");
            sc.next();
        }
    }

    while (true) {
        try {
            System.out.print("Enter animal speed: ");
            attributes.speed = sc.nextDouble();
            if (attributes.speed <= 0) {
                System.out.println("Speed must be positive.");
                continue;
            }
            break;
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid speed.");
            sc.next();
        }
    }

    int numMedals;

    while (true) {
        try {
            System.out.print("Enter number of medals: ");
            numMedals = sc.nextInt();
            if (numMedals < 0) {
                System.out.println("Number of medals cannot be negative.");
                continue;
            }
            break;
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number of medals.");
            sc.next();
        }
    }

    attributes.medals = new Medal[numMedals];

    for (int j = 0; j < numMedals; j++) {
        while (true) {
            try {
                System.out.print("Enter medal type (BRONZE, SILVER, GOLD): ");
                String medalStr = sc.next().toUpperCase();
                Medal.MedalType medalType = Medal.MedalType.valueOf(medalStr);
                System.out.print("Enter tournament: ");
                String tournament = sc.next();
                int year;
                while (true) {
                    try {
                        System.out.print("Enter year: ");
                        year = sc.nextInt();
                        if (year < 1900 || year > 2024) {
                            System.out.println("Year must be between 1900 and 2024.");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid year.");
                        sc.next();
                    }
                }
                attributes.medals[j] = new Medal(medalType, tournament, year);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input for medal. Please try again.");
                sc.next();
            }
        }
    }
 }
}



