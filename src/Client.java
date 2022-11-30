public class Client {
    String name;
    String securityNumber;
    String accountNumber;

    Account account;

    public Client(String name, String securityNumber, String accountNumber, Account account) {
        this.name = name;
        this.securityNumber = securityNumber;
        this.accountNumber = accountNumber;
        this.account = account;
    }

    public void PrintClient() {
        System.out.println("Client name: " + name + "\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Account getAccount() {
        return account;
    }
}
