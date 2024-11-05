import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    private String location;
    private String date;
    private String preferences;
    private double budget;

    public Destination(String location, String date, String preferences, double budget) {
        this.location = location;
        this.date = date;
        this.preferences = preferences;
        this.budget = budget;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getPreferences() {
        return preferences;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Destination: " + location + "\nDate: " + date + "\nPreferences: " + preferences + "\nBudget: $" + budget;
    }
}

public class TravelItineraryPlanner {
    private ArrayList<Destination> itinerary;
    private double totalBudget;

    public TravelItineraryPlanner() {
        itinerary = new ArrayList<>();
        totalBudget = 0.0;
    }

    public void addDestination(String location, String date, String preferences, double budget) {
        Destination destination = new Destination(location, date, preferences, budget);
        itinerary.add(destination);
        totalBudget += budget;
        System.out.println("Destination added successfully!\n");
    }

    public void displayItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("No destinations in your itinerary.");
        } else {
            System.out.println("Your Travel Itinerary:");
            for (Destination destination : itinerary) {
                System.out.println(destination);
                System.out.println("-----------------------");
            }
            System.out.println("Total Budget: $" + totalBudget);
        }
    }

    public void getTotalBudget() {
        System.out.println("Total Budget for the trip: $" + totalBudget);
    }

    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTravel Itinerary Planner");
            System.out.println("1. Add Destination");
            System.out.println("2. Display Itinerary");
            System.out.println("3. Show Total Budget");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter travel date (e.g., 2023-12-25): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter preferences (e.g., sightseeing, food, etc.): ");
                    String preferences = scanner.nextLine();
                    System.out.print("Enter budget for this destination: $");
                    double budget = scanner.nextDouble();
                    
                    planner.addDestination(location, date, preferences, budget);
                    break;
                case 2:
                    planner.displayItinerary();
                    break;
                case 3:
                    planner.getTotalBudget();
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }
}