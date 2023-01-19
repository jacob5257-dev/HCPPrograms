public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Jacob", 1000, 0.05, 20.0);
        account.deposit(200);
        System.out.println("Balance: " + account.getBalance());
        account.withdraw(500);
        System.out.println("Balance: " + account.getBalance());
        account.withdraw(400);
        System.out.println("Balance: " + account.getBalance());
        account.addInterest();
        System.out.println("Balance: " + account.getBalance());
    }
}
