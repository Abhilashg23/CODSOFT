import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ATMInterface {
    private static double accountBalance = 1000.0; // Initial account balance
    private static List<String> transactionHistory = new ArrayList<>();
    private static String mobileNumber = "123-456-7890"; // Initial mobile number
    private static String pin = "1234"; // Initial PIN

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SBI ATM");
        System.out.println("Select a language:");
        System.out.println("1. English");
        System.out.println("2. Hindi");
        System.out.println("3. Kannada");
        System.out.println("4. Dutch");

        int languageChoice = scanner.nextInt();

        switch (languageChoice) {
            case 1:
                displayMenu("English", scanner);
                break;
            case 2:
                displayMenu("Dutch", scanner);
                break;
            default:
                System.out.println("Invalid language choice. Please try again.");
        }
    }

    private static void displayMenu(String language, Scanner scanner) {
        while (true) {
            System.out.println("ATM Menu (" + language + "):");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Mini-Statement");
            System.out.println("4. Change Mobile Number");
            System.out.println("5. Generate/Change PIN");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(language);
                    break;
                case 2:
                    withdraw(language);
                    break;
                case 3:
                    miniStatement(language);
                    break;
                case 4:
                    changeMobileNumber(language, scanner);
                    break;
                case 5:
                    generateOrChangePIN(language, scanner);
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance(String language) {
        System.out.println("Your account balance is: $" + accountBalance);
        addToTransactionHistory("Balance Check: $" + accountBalance);
    }

    private static void withdraw(String language) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("You have successfully withdrawn $" + amount);
            System.out.println("Your new balance is: $" + accountBalance);
            addToTransactionHistory("Withdrawal: $" + amount);
        } else {
            System.out.println("Insufficient funds. Please try again.");
        }
    }

    private static void miniStatement(String language) {
        System.out.println("Mini-Statement (" + language + "):");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void changeMobileNumber(String language, Scanner scanner) {
        System.out.print("Enter your new mobile number: ");
        String newMobileNumber = scanner.next();
        mobileNumber = newMobileNumber;
        System.out.println("Your mobile number has been updated to: " + mobileNumber);
    }

    private static void generateOrChangePIN(String language, Scanner scanner) {
        Random random = new Random();
        int newPin = 1000 + random.nextInt(9000); // Generates a random 4-digit PIN

        System.out.println("Your new PIN is: " + newPin);
        System.out.println("Please make sure to remember it.");
        pin = Integer.toString(newPin);
    }

    private static void addToTransactionHistory(String transaction) {
        transactionHistory.add(transaction);
    }
}
