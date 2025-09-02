import java.util.Scanner;
abstract class BankOps {
    abstract void transaction(double amt);
}
class Account {
    private double bal;

    public Account(double bal) {
        this.bal = bal;
    }

    public double getBal() {
        return bal;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            bal += amt;
            System.out.println("Deposited: " + amt);
        } else {
            System.out.println("Invalid deposit.");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= bal) {
            bal -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient funds or invalid input.");
        }
    }
}
class ATM extends BankOps {
    private Account acc;
    private String op;

    public ATM(Account acc, String op) {
        this.acc = acc;
        this.op = op;
    }

    @Override
    void transaction(double amt) {
        switch (op) {
            case "deposit":
                acc.deposit(amt);
                break;
            case "withdraw":
                acc.withdraw(amt);
                break;
            case "check":
                System.out.println("Balance: " + acc.getBal());
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account(5000); 
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
