/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza 208029819
 */
package System;
import java.util.Scanner;
import Animals.*;
import Mobility.Point;
import Olympics.*;

/**
 * The AnimalAttributes class handles the input and storage of various attributes for an animal.
 */
public class AnimalAttributes {
    private String name;
    private Point location;
    private Animal.Gender gender;
    private double weight;
    private double speed;
    private Medal[] medals;

    /**
     * Method to input and set the attributes for an animal.
     *
     * @param attributes The AnimalAttributes object to store the inputted attributes.
     */
    public void input(AnimalAttributes attributes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter animal name: ");
        attributes.name = sc.next();

        // Input gender with validation
        while (true) {
            try {
                System.out.println("""
                    Enter your gender:
                    1-Male
                    2-Female
                    3-Hermaphrodite""");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        attributes.gender = Animal.Gender.MALE;
                        break;
                    case 2:
                        attributes.gender = Animal.Gender.FEMALE;
                        break;
                    case 3:
                        attributes.gender = Animal.Gender.HERMAPHRODITE;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a valid gender.");
                        continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

        // Input weight with validation
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

        // Input speed with validation
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

        // Input number of medals with validation
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

        // Input medal details with validation
        for (int j = 0; j < numMedals; j++) {
            while (true) {
                try {
                    System.out.println("""
                    Enter medal type:
                     1: BRONZE.
                     2: SILVER.
                     3: GOLD.""");
                    int medalChoice = sc.nextInt();
                    Medal.MedalType medalType;

                    switch (medalChoice) {
                        case 1:
                            medalType = Medal.MedalType.BRONZE;
                            break;
                        case 2:
                            medalType = Medal.MedalType.SILVER;
                            break;
                        case 3:
                            medalType = Medal.MedalType.GOLD;
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1 for BRONZE, 2 for SILVER, or 3 for GOLD.");
                            continue;
                    }

                    System.out.print("Enter tournament: ");
                    String tournament = sc.next();
                    int year;

                    while (true) {
                        try {
                            System.out.println("Enter year: ");
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
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }
        }

        // Input location with validation
        while (true) {
            try {
                System.out.println("Enter location, x and y (non-negative integers): ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (x < 0 || y < 0) {
                    System.out.println("Location coordinates must be non-negative integers.");
                    continue;
                }
                attributes.location = new Point(x, y);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid non-negative integers for location.");
                sc.next();
            }
        }
    }

    /**
     * @return The speed of the animal.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @return The name of the animal.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The gender of the animal.
     */
    public Animal.Gender getGender() {
        return gender;
    }

    /**
     * @return The weight of the animal.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return The medals of the animal.
     */
    public Medal[] getMedals() {
        return medals;
    }

    /**
     * @return The location of the animal.
     */
    public Point getLocation() {
        return location;
    }
}
