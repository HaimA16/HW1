/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza
 */
package System;
import java.util.Scanner;
import Animals.*;
import Mobility.*;

public class Sys {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        while (true) {
            try {
                System.out.print("Enter number of animals: ");
                size = sc.nextInt();
                if (size <= 0) {
                    System.out.println("Number of animals must be positive.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

        Animal[] animals = new Animal[size];

        for (int i = 0; i < size; i++) {
            int type;

            while (true) {
                try {
                    System.out.print("""
                            Choose type of animal:
                            1-Air Animals
                            2-Water Animals
                            3-Terrestrial Animals
                            """);
                    type = sc.nextInt();
                    if (type < 1 || type > 3) {
                        System.out.println("Invalid animal type. Please enter a number between 1 and 3.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }

            Point location;
            AnimalAttributes attributes = new AnimalAttributes();

            switch (type) {
                case 1:
                    location = new Point(0, 100);
                    int airType;
                    while (true) {
                        try {
                            System.out.print("""
                                    Choose animal:
                                    1) Eagle
                                    2) Pigeon
                                    """);
                            airType = sc.nextInt();
                            if (airType < 1 || airType > 2) {
                                System.out.println("Invalid choice. Please enter 1 or 2.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    double span;
                    while (true) {
                        try {
                            System.out.print("Enter wing span: ");
                            span = sc.nextDouble();
                            if (span <= 0) {
                                System.out.println("Wing span must be positive.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }

                    switch (airType) {
                        case 1:
                            try {
                                attributes.input(attributes);
                                System.out.print("Enter altitude of flight: ");
                                double altitude = sc.nextDouble();
                                animals[i] = new Eagle(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, span, altitude);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                        case 2:
                            try {
                                attributes.input(attributes);
                                System.out.print("Enter family: ");
                                String family = sc.next();
                                animals[i] = new Pigeon(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, span, family);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                    }
                    break;
                case 2:
                    location = new Point(50, 0);
                    int waterType;
                    while (true) {
                        try {
                            System.out.print("""
                                    Choose animal:
                                    1) Alligator
                                    2) Whale
                                    3) Dolphin
                                    """);
                            waterType = sc.nextInt();
                            if (waterType < 1 || waterType > 3) {
                                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    double diveDepth;
                    while (true) {
                        try {
                            System.out.print("Enter dive depth: ");
                            diveDepth = sc.nextDouble();
                            if (diveDepth >= 0) {
                                System.out.println("Dive depth must be negative.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid dive depth.");
                            sc.next();
                        }
                    }
                    switch (waterType) {
                        case 1:
                            try {
                                attributes.input(attributes);
                                System.out.print("Enter area of living: ");
                                String area = sc.next();
                                animals[i] = new Alligator(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, diveDepth, area);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                        case 2:
                            try {
                                attributes.input(attributes);
                                System.out.print("Enter food type: ");
                                String food = sc.next();
                                animals[i] = new Whale(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, diveDepth, food);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                        case 3:
                            try {
                                attributes.input(attributes);
                                Dolphin.WaterType waterTypeEnum;
                                while (true) {
                                    try {
                                        System.out.print("Enter water type (SEA, SWEET): ");
                                        String waterTypeStr = sc.next().toUpperCase();
                                        waterTypeEnum = Dolphin.WaterType.valueOf(waterTypeStr);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("SEA or SWEET only!");
                                        sc.next();
                                    }
                                }
                                animals[i] = new Dolphin(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, diveDepth, waterTypeEnum);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                    }
                    break;
                case 3:
                    location = new Point(0, 20);
                    int terrestrialType;
                    while (true) {
                        try {
                            System.out.print("""
                                    Choose animal:
                                    1) Dog
                                    2) Cat
                                    3) Snake
                                    """);
                            terrestrialType = sc.nextInt();
                            if (terrestrialType < 1 || terrestrialType > 3) {
                                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    int noLegs;
                    while (true) {
                        try {
                            System.out.print("Enter number of legs: ");
                            noLegs = sc.nextInt();
                            if (noLegs < 0) {
                                System.out.println("Number of legs must be non-negative.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    switch (terrestrialType) {
                        case 1:
                            try {
                                attributes.input(attributes);
                                System.out.print("Enter breed: ");
                                String breed = sc.next();
                                animals[i] = new Dog(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, noLegs, breed);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                        case 2:
                            try {
                                attributes.input(attributes);
                                boolean castrated;
                                while (true) {
                                    try {
                                        System.out.print("Is the cat castrated? (true/false): ");
                                        castrated = sc.nextBoolean();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input. Please enter true or false.");
                                        sc.next();
                                    }
                                }
                                animals[i] = new Cat(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, noLegs, castrated);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                        case 3:
                            try {
                                attributes.input(attributes);
                                noLegs = 0;
                                System.out.print("Enter snake length: ");
                                double length = sc.nextDouble();
                                Snake.Poisonous poisonous;
                                while (true) {
                                    try {
                                        System.out.print("Enter if snake is poisonous (YES, NO): ");
                                        String poisonousStr = sc.next().toUpperCase();
                                        poisonous = Snake.Poisonous.valueOf(poisonousStr);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input. Please enter YES or NO.");
                                        sc.next();
                                    }
                                }
                                animals[i] = new Snake(attributes.name, attributes.gender, attributes.weight, attributes.speed, attributes.medals, location, noLegs, length, poisonous);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please try again.");
                                sc.next();
                            }
                            break;
                    }
                    break;
            }
        }

        while (true) {
            try {
                System.out.print("""
                        Choose an option:
                        1-View all animals
                        2-Hear all animals
                        3-compare
                        4-Exit
                        """);
                int option = sc.nextInt();
                if (option == 4) {
                    System.out.println("Thank you, bye!");
                    break;
                }
                switch (option) {
                    case 1:
                        for (Animal animal : animals) {
                            System.out.println(animal.toString());
                        }
                        break;
                    case 2:
                        for (Animal animal : animals) {
                            animal.makeSound();
                        }
                        break;
                    case 3:
                        if (animals.length < 2) {
                            System.out.println("Can't compare, only 1 animal!.");
                        } else {
                            boolean allIdentical = true;
                            for (int i = 0; i < animals.length; i++) {
                                for (int j = i + 1; j < animals.length; j++) {
                                    if (!animals[i].equals(animals[j])) {
                                        allIdentical = false;
                                        break;
                                    }
                                }
                            }

                            if (allIdentical) {
                                System.out.println("All animals identical.");
                            } else {
                                System.out.println("All animals not identical.");
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                sc.next();
            }
        }
        sc.close();
    }
}
