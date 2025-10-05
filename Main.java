import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account(0);

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();

            if (ch == 4) {
                System.out.println("Thank you for using ATM!");
                break;
            }

            double amt = 0;
            String op = "";

            switch (ch) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    amt = sc.nextDouble();
                    op = "deposit";
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    amt = sc.nextDouble();
                    op = "withdraw";
                    break;
                case 3:
                    op = "check";
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            ATM atm = new ATM(acc, op);
            atm.transaction(amt);
        }

        sc.close();
    }
}
