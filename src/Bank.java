import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    Client client;
    List<Client> clients = new ArrayList<>();

    List<Account> accounts = new ArrayList<>();

    Account account;

    public Bank(Client client, List<Client> clients, Account account, List<Account> accounts) {
        this.client = client;
        this.clients = clients;
        this.account = account;
        this.accounts = accounts;
    }

    public void Program() {
        boolean runProgram = true;
        while (runProgram) {
            String name;
            String accountNumber;
            String securityNumber;
            List<Client> clients = new ArrayList<>();
            while (runProgram) {
                double balance;
                Scanner Menuscanner = new Scanner(System.in);
                System.out.println("Welcome to the bank ! Choose between the options below by entering the respective number.");
                System.out.println("");
                System.out.println("1. Register new client ");
                System.out.println("2. Open an account ");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw ");
                System.out.println("5. View Bankclients ");
                switch (MenuInput()) {
                    case 1:
                        System.out.println("Clients name? ");
                        name = Menuscanner.next("");
                        while (true) {
                            try {
                                System.out.println("Clients balance?");
                                balance = Menuscanner.nextDouble();
                                break;
                            } catch (Exception e) {
                                System.out.println("Input error! Please enter an integer");
                            }
                        }
                        System.out.println("Accountnumber? ");
                        accountNumber = Menuscanner.next("");
                        securityNumber = Menuscanner.next("");

                        //Declaring new client
                        Client client = new Client(name, securityNumber, accountNumber, null);
                        clients.add(client);
                        break;
                    case 2:
                        Client owner = null;
                        System.out.println("Who is the owner of the account? ");
                        String ownerName = Menuscanner.next();

                        for (Client clientf : clients) {
                            if (clientf.getName() == ownerName) {
                                owner = clientf;
                            }
                        }
                        Account account = CreateAccount(owner);
                        if (owner != null) {
                            owner.account = account;
                        }
                        accounts.add(account);
                    case 3:
                        String soughtName;
                        System.out.println("Name of client? ");
                        soughtName = Menuscanner.next();

                        for (Client clientf : clients) {
                            System.out.println(clientf.getName());
                            if (clientf.getName() == soughtName) {
                                Account clientAccount = clientf.account;
                                clientAccount.Deposit();
                            }

                        }
                    case 4:
                        System.out.println("Name of client? ");
                        soughtName = Menuscanner.next();

                        for (Client clientf : clients) {
                            System.out.println(clientf.getName());
                            if (clientf.getName() == soughtName) {
                                Account clientAccount = clientf.account;
                                clientAccount.Withdraw();
                            }
                        }
                        break;
                    case 5:
                        for (Client clientf : clients) {
                            clientf.PrintClient();
                        }
                        break;
                }

            }
        }
    }

    public static int MenuInput() {
        Scanner Scanner = new Scanner(System.in);
        int answer;
        while (true) {
            try {
                System.out.println("Choose option: ");
                answer = Scanner.nextInt();
                if (answer <= 0 || answer > 5) {
                    System.out.println("");
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input Error! Please enter a valid integer corresponding to the options presented");
            }
        }
        return answer;
    }

    public static Account CreateAccount(Client owner) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        String accountNumber = null;
        Transaction previousTransaction = null;
        System.out.println("Owners name: ");

        while (true) {
            try {
                System.out.println("Account balance: ");
                balance = scanner.nextDouble();
                if (balance < 0) {
                    continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error! Please enter integer");
            }
        }
        Account account = new Account(accountNumber, balance, owner, null);
        return account;
    }

    public void PrintClients(List<Client> Clients) {
        int clientAmount = 0;
        for (Client clientf : clients) {
            clientAmount++;
            System.out.println("--------------------------------------------");
            System.out.println(clientf.getName());
            System.out.println(clientf.getSecurityNumber());
            System.out.println(clientf.getAccountNumber());
            System.out.println("--------------------------------------------");
        }
        System.out.println("Client count " + clientAmount);
    }

    public void CalculateRevenue(List<Account> accounts) {
        double balance;
        int sum = 0;
        for (Client clientf : clients) {
            balance = clientf.account.balance;
            if (balance > 0) ;
            sum += balance;
        }
        System.out.println("Total revenue: " + sum);
    }
}

