import java.util.Scanner;
class PrintInfo {
   static void print() {
        System.out.println("Name: Kashvi Agarwal");
        System.out.println("USN: 1BM23CS141");
    }
}


class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;

    public Account(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Interest deposited: " + interest);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal!");
        }
    }
}

class CurAcct extends Account {
    private double minBalance;
    private double serviceCharge;

    public CurAcct(String customerName, String accountNumber, double minBalance, double serviceCharge) {
        super(customerName, accountNumber);
        this.minBalance = minBalance;
        this.serviceCharge = serviceCharge;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance for withdrawal!");
        }
    }

    private void checkMinimumBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Service charge imposed: " + serviceCharge);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
     PrintInfo.print();

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();
        
        System.out.print("Choose account type (1 for Savings, 2 for Current): ");
        int choice = scanner.nextInt();
        
        Account account;
        if (choice == 1) {
            System.out.print("Enter interest rate for savings account: ");
            double interestRate = scanner.nextDouble();
            account = new SavAcct(name, accNumber, interestRate);
        } else {
            System.out.print("Enter minimum balance for current account: ");
            double minBalance = scanner.nextDouble();
            System.out.print("Enter service charge for current account: ");
            double serviceCharge = scanner.nextDouble();
            account = new CurAcct(name, accNumber, minBalance, serviceCharge);
        }

        boolean continueBanking = true;
        while (continueBanking) {
            System.out.println("\nOptions:");
            System.out.println("1. Deposit");
            System.out.println("2. Display Balance");
            System.out.println("3. Withdraw");
            if (account instanceof SavAcct) {
                System.out.println("4. Compute and Deposit Interest");
            }
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    account.displayBalance();
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).withdraw(withdrawAmount);
                    } else {
                        ((CurAcct) account).withdraw(withdrawAmount);
                    }
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeAndDepositInterest();
                    } else {
                        System.out.println("Current accounts do not have interest.");
                    }
                    break;
                case 5:
                    continueBanking = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
        scanner.close();
    }
}
