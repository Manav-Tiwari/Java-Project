public class User {
    private String username;
    private int credits;

    public User(String username, int initialCredits) {
        this.username = username;
        this.credits = initialCredits;
    }

    public String getUsername() { return username; }
    public int getCredits() { return credits; }

    public void addCredits(int amount) {
        this.credits += amount;
    }

    // Returns true if successful, false if not enough credits
    public boolean deductCredits(int amount) {
        if (this.credits >= amount) {
            this.credits -= amount;
            return true;
        }
        return false; 
    }
}