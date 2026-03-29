import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Marketplace market = new Marketplace();

        // Load existing data from CSV files when the app starts
        market.loadData();

        System.out.println("=========================================");
        System.out.println("       Welcome to CampusCred!            ");
        System.out.println("   The Virtual Campus Barter System      ");
        System.out.println("=========================================");

        // Simple Login / Registration
        System.out.print("Enter your username to login (or register): ");
        String currentUser = scanner.nextLine().trim();
        
        // If the user doesn't exist, this creates them with 100 starting credits
        market.addUser(currentUser, 100); 
        System.out.println("\nWelcome, " + currentUser + "! Your balance is: " + market.getUser(currentUser).getCredits() + " credits.");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Marketplace");
            System.out.println("2. Sell an Item");
            System.out.println("3. Buy an Item");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit & Save");
            System.out.print("Choose an option (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character

                switch (choice) {
                    case 1:
                        market.displayItems();
                        break;
                    case 2:
                        System.out.print("Enter item title (e.g., 'Physics Notes'): ");
                        String title = scanner.nextLine();
                        System.out.print("Enter selling price (in credits): ");
                        int price = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        
                        if (price <= 0) {
                            System.out.println("Price must be greater than 0.");
                        } else {
                            market.listAnItem(title, price, currentUser);
                        }
                        break;
                    case 3:
                        market.displayItems();
                        System.out.print("Enter the ID of the item you want to buy (e.g., ITEM1): ");
                        String itemId = scanner.nextLine().trim();
                        market.buyItem(itemId, currentUser);
                        break;
                    case 4:
                        System.out.println("Current Balance: " + market.getUser(currentUser).getCredits() + " credits.");
                        break;
                    case 5:
                        System.out.println("Saving data... Thank you for using CampusCred!");
                        market.saveData(); // Save state to CSV before closing
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // This catches the error if a user types a letter instead of a number
                System.out.println("Error: Invalid input. Please enter numbers only for menu choices and prices.");
                scanner.nextLine(); // Clear the bad input from the scanner buffer
            } catch (Exception e) {
                // Catches any other unexpected errors so the program doesn't crash entirely
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}