import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    private String name;
    private int balance;
    private LocalDateTime opened;
    private boolean blocked;
    private String number;

    public BankAccount(String name) {
        this.name = name;
        balance = 0;
        opened = LocalDateTime.now();
        blocked = false;
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            numberBuilder.append(new Random().nextInt(10));
        }
        number = numberBuilder.toString();
    }

    public boolean deposit(int amount) {
        if (blocked || amount < 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (blocked || amount < 0 || balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (blocked || amount < 0 || balance < amount || otherAccount == null || otherAccount.blocked) {
            return false;
        }
        withdraw(amount);
        otherAccount.deposit(amount);
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + name + "(" + balance + ") created: " + opened +" status: "
                + (blocked ? "blocked" : "active");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof BankAccount account) {
            return Objects.equals(number, account.number);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
