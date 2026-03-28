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

   
}