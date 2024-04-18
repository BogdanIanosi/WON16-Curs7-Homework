import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void deposit(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Withdrawn " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

public class bankAccount {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        Account account1 = new Account(123);
        Account account2 = new Account(456);

        bank.addAccount(account1);
        bank.addAccount(account2);

        bank.deposit(123, 1000);
        bank.withdraw(123, 500);
        bank.withdraw(123, 600); // should display "Insufficient balance."
        bank.deposit(456, 200);
        bank.withdraw(789, 100); // should display "Account not found."
    }
}

