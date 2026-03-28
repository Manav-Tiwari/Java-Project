public class Item {
    private String id;
    private String title;
    private int price;
    private String sellerUsername;

    public Item(String id, String title, int price, String sellerUsername) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.sellerUsername = sellerUsername;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getPrice() { return price; }
    public String getSellerUsername() { return sellerUsername; }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " - " + price + " Credits (Seller: " + sellerUsername + ")";
    }
}