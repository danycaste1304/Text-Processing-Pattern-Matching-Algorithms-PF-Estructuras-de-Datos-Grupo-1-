public class Review {
    private int id;
    private String customer;
    private String text;

    public Review(int id, String customer, String text) {
        this.id = id;
        this.customer = customer;
        this.text = text;
    }

    public int getId() { return id; }
    public String getCustomer() { return customer; }
    public String getText() { return text; }

    @Override
    public String toString() {
        return "Review #" + id + " de " + customer + ": \"" + text + "\"";
    }
}