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
