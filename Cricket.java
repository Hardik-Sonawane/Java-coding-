import java.util.Scanner;

// CricketPlayer class for storing player details
class CricketPlayer {
    String name;
    int age;
    String type; // Batsman, Bowler, or Allrounder
    int hundreds; // Number of hundreds scored in IPL
    int wickets;  // Number of wickets taken in IPL

    // Constructor to initialize player details
    public CricketPlayer(String name, int age, String type, int hundreds, int wickets) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.hundreds = hundreds;
        this.wickets = wickets;
    }

    // Method to display player details
    public void display() {
        System.out.println("Player Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Type: " + type);
        System.out.println("Hundreds: " + hundreds);
        System.out.println("Wickets: " + wickets);
    }

    // Method to provide recommendation based on IPL record
    public void recommendation() {
        if (hundreds >= 5 || wickets >= 100) {
            System.out.println(name + " is an experienced and talented player.");
        } else {
            System.out.println(name + " is still developing.");
        }
    }
}

// Main class to execute the code
public class Cricket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user for the number of players
        System.out.print("Enter the number of players you want to add: ");
        int numPlayers = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Array of players
        CricketPlayer[] players = new CricketPlayer[numPlayers];

        // Input details for the players
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter details for player " + (i + 1) + ":");

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();

            System.out.print("Enter type (Batsman, Bowler, Allrounder): ");
            sc.nextLine(); // Consume the remaining newline
            String type = sc.nextLine();

            System.out.print("Enter number of hundreds in IPL: ");
            int hundreds = sc.nextInt();

            System.out.print("Enter number of wickets in IPL: ");
            int wickets = sc.nextInt();
            sc.nextLine(); // Consume the remaining newline

            // Create CricketPlayer object and store it in the array
            players[i] = new CricketPlayer(name, age, type, hundreds, wickets);
            System.out.println();
        }

        // Display and recommend for each player
        for (CricketPlayer player : players) {
            player.display();
            player.recommendation();
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}
