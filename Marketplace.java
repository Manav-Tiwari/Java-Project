import java.io.*;
import java.util.*;

public class Marketplace {
    // HashMap for instant user lookups, ArrayList for dynamic item lists
    private HashMap<String, User> users;
    private ArrayList<Item> items;
    private int nextItemId = 1;

    public Marketplace() {
        users = new HashMap<>();
        items = new ArrayList<>();
    }

    // --- USER MANAGEMENT ---
    
    public void addUser(String username, int initialCredits) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, initialCredits));
        }
    }

    public User getUser(String username) {
        return users.get(username);
    }

    // --- MARKETPLACE LOGIC ---

    // Seller lists an item
    public void listAnItem(String title, int price, String sellerUsername) {
        String itemId = "ITEM" + nextItemId++;
        Item newItem = new Item(itemId, title, price, sellerUsername);
        items.add(newItem);
        System.out.println("Success! Item listed: " + newItem.toString());
    }

    // Buyer purchases an item
    public void buyItem(String itemId, String buyerUsername) {
        User buyer = users.get(buyerUsername);
        if (buyer == null) {
            System.out.println("Error: Buyer not found in the system.");
            return;
        }

        Item itemToBuy = null;
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(itemId)) {
                itemToBuy = item;
                break;
            }
        }

        if (itemToBuy == null) {
            System.out.println("Error: Item ID not found in the marketplace.");
            return;
        }

        if (itemToBuy.getSellerUsername().equalsIgnoreCase(buyerUsername)) {
            System.out.println("Error: You cannot buy your own item!");
            return;
        }

        User seller = users.get(itemToBuy.getSellerUsername());

        // Process Transaction Logic
        if (buyer.deductCredits(itemToBuy.getPrice())) {
            seller.addCredits(itemToBuy.getPrice());
            items.remove(itemToBuy); // Remove from market once sold
            System.out.println("Transaction successful! You bought: " + itemToBuy.getTitle());
            System.out.println("Your remaining balance: " + buyer.getCredits() + " credits.");
        } else {
            System.out.println("Transaction failed. Insufficient credits.");
        }
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("The marketplace is currently empty.");
            return;
        }
        System.out.println("\n--- Current CampusBarter Listings ---");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println("-------------------------------------");
    }

}