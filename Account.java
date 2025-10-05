public class Account {
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
