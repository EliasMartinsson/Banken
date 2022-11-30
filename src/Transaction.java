public class Transaction {
    String date;
    int sum;
    String origin;
    String recipient;

    public Transaction() {
        this.date = date;
        this.sum = sum;
        this.origin = origin;
        this.recipient = recipient;
    }


    private void PrintTransaction(String date, int sum, String origin, String recipient) {
        System.out.println("----------------------------------------------------");
        System.out.println("Details of Transactions:");
        System.out.println("Date: " + date);
        System.out.println("Transactionsum: " + sum);
        System.out.println("From: " + origin + " To: " + recipient);
        System.out.println("----------------------------------------------------");
    }
}
