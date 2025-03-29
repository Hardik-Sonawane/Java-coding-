import java.util.Scanner;

public class CricketPlayerException extends Exception {

public CricketPlayerException(String msg) {

    super(msg);

}



int checkDebutYear(int debutYear) throws Exception {

    int experience = 2024 - debutYear;

    int calc = debutYear / experience;  // Potential division error if debutYear is recent

    return calc;

}



void checkEligibility(int runs, int matches) throws CricketPlayerException {

    if (runs < 1000 || matches < 20) {

        throw new CricketPlayerException("Player is not eligible for international selection");

    }

    System.out.println("Player meets the basic eligibility criteria");

}



public static void main(String args[]) {

    Scanner ip = new Scanner(System.in);

    int ch;

    do {

        System.out.println("\n1. Insert Cricket Player Details");

        System.out.println("2. Check Player Career Stats");

        System.out.println("3. Evaluate Player Performance");

        System.out.println("4. Exit");

        ch = ip.nextInt();



        switch (ch) {

            case 1:

                System.out.println("Enter Player Name:");

                String name = ip.next();

                try {

                    System.out.println("Enter Player Age:");

                    int age = ip.nextInt();

                    if (age < 0) {

                        throw new Exception("Age cannot be negative");

                    }



                    System.out.println("Enter Total Runs Scored:");

                    int runs = ip.nextInt();

                    if (runs < 0) {

                        throw new Exception("Runs cannot be negative");

                    }



                    System.out.println("Enter Player ID (Min 4 Digits)");

                    System.out.println("Enter the size of your ID:");

                    int size = ip.nextInt();

                    int id[] = new int[4];

                    for (int i = 0; i < size; i++) {

                        id[i] = ip.nextInt();

                    }

                } catch (ArrayIndexOutOfBoundsException e) {

                    System.out.println("ID size must be exactly 4 digits");

                } catch (Exception e) {

                    System.out.println(e.getMessage());

                } finally {

                    System.out.println("\nEnsure all details are valid\n");

                }

                break;



            case 2:

                System.out.println("Enter Player Debut Year:");

                int debutYear = ip.nextInt();

                try {

                    CricketPlayerException obj = new CricketPlayerException("Career Validation:");

                    obj.checkDebutYear(debutYear);

                    System.out.println("Experience Level: " + obj.checkDebutYear(debutYear));

                } catch (Exception e) {

                    System.out.println("Invalid debut year! Player might be too young.");

                } finally {

                    System.out.println("Ensure all details are valid");

                }

                break;



            case 3:

                System.out.println("Enter Total Runs:");

                int totalRuns = ip.nextInt();

                System.out.println("Enter Total Matches Played:");

                int matches = ip.nextInt();



                try {

                    CricketPlayerException obj = new CricketPlayerException("Eligibility Check");

                    obj.checkEligibility(totalRuns, matches);

                } catch (CricketPlayerException e) {

                    System.out.println(e.getMessage());

                } finally {

                    System.out.println("Ensure all details are valid");

                }

                break;



            case 4:

                System.out.println("Exiting...");

                break;



            default:

                System.out.println("Invalid choice");

        }

    } while (ch != 4);

}

}