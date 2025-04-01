import java.util.Scanner;

public class CricketPlayerException extends Exception {
    public CricketPlayerException(String msg) { 
        super(msg); 
    }

    int checkDebutYear(int debutYear) throws Exception {
        int experience = 2024 - debutYear;
        if (experience <= 0) {
            throw new Exception("Invalid debut year! Player might be too young.");
        }
        return experience;
    }

    void checkEligibility(int runs, int matches) throws CricketPlayerException {
        if (runs < 1000 || matches < 20) {
            throw new CricketPlayerException("Player is not eligible for international selection");
        }
        System.out.println("You are clear with basic criteria");
    }

    public static void main(String args[]) {
        Scanner ip = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("\n1. Insert Player detail");
            System.out.println("2. Check Career Stats");
            System.out.println("3. Check Eligibility");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            while (!ip.hasNextInt()) {
                System.out.println("Invalid input! Enter a number (1-4).");
                ip.next();
            }
            ch = ip.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("\nInsert Player detail");
                    System.out.println("Enter player name:");
                    String name = ip.next();

                    int age;
                    while (true) {
                        System.out.println("Enter player age:");
                        if (!ip.hasNextInt()) {
                            System.out.println("Invalid input! Age must be a number.");
                            ip.next();
                            continue;
                        }
                        age = ip.nextInt();
                        if (age < 0) {
                            System.out.println("Age cannot be negative");
                        } else break;
                    }

                    System.out.println("Make sure that everything is valid credentials");
                    break;

                case 2:
                    System.out.println("\nCheck Career Stats");
                    int debutYear;
                    while (true) {
                        System.out.println("Enter player debut year:");
                        if (!ip.hasNextInt()) {
                            System.out.println("Invalid input! Enter a valid year.");
                            ip.next();
                            continue;
                        }
                        debutYear = ip.nextInt();
                        try {
                            CricketPlayerException obj = new CricketPlayerException("Career Validation:");
                            System.out.println("Your experience code: " + obj.checkDebutYear(debutYear));
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Make sure that everything is valid credentials");
                    break;

                case 3:
                    System.out.println("\nCheck Eligibility");
                    int totalRuns, matches;
                    while (true) {
                        System.out.println("Enter total runs:");
                        if (!ip.hasNextInt()) {
                            System.out.println("Invalid input! Runs must be a number.");
                            ip.next();
                            continue;
                        }
                        totalRuns = ip.nextInt();
                        break;
                    }
                    while (true) {
                        System.out.println("Enter total matches played:");
                        if (!ip.hasNextInt()) {
                            System.out.println("Invalid input! Matches must be a number.");
                            ip.next();
                            continue;
                        }
                        matches = ip.nextInt();
                        break;
                    }

                    try {
                        CricketPlayerException obj = new CricketPlayerException("Eligibility Check");
                        obj.checkEligibility(totalRuns, matches);
                    } catch (CricketPlayerException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Make sure that everything is valid credentials");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Enter 1-4.");
            }
        }
    }
}