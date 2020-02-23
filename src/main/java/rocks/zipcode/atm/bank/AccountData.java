package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public final class AccountData {

    private final int id;
    private final String name;
    private final String email;
    private final int pin;

    private final Float balance;

    AccountData(int id, String name, String email, float balance, int pin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Float getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public String toString() {
        return String.format("Account id: %d\nName: %s\nEmail: %s\nBalance: $%10.2f\n", id, name, email, balance);
    }
}
