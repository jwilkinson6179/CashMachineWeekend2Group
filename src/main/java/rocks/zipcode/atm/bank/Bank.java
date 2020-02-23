package rocks.zipcode.atm.bank;

import rocks.zipcode.atm.ActionResult;
import rocks.zipcode.atm.PopupWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZipCodeWilmington
 */
public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();
    private Integer id = 1001;

    public Bank() {
        Float initialBalance = (float)0.0;

        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Example 1", "example1@gmail.com", 500, 1111
        )));

        accounts.put(2000, new PremiumAccount(new AccountData(
                2000, "Example 2", "example2@gmail.com", 200, 0000
        )));

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "James Wilkinson", "JWEmail54@geemail.com", initialBalance, 5645
        )));
        id++;

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "Sandy Setiawan", "seti@yoohoo.com", initialBalance, 9876
        )));
        id++;

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "Maurice Russ", "Moruss@udel.edu", initialBalance, 4355
        )));
        id++;

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "Corey Williams", "cwilliams@un.gov", initialBalance, 9999
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Paul Atredes", "maudib@arakkis.co.ak", initialBalance, 3498
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Frodo Baggins", "BagEnd420@shire.com", initialBalance, 3345
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Luke Cage", "powerman@aliasinvestigations.com", initialBalance, 8765
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Bugs Bunny", "bb1931@warner.com", initialBalance, 4323
        )));
        id++;
    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id + "\nTry account 1000 or 2000");
        }
    }

    public boolean getAccountByPin(int pin, int id) {
        Account account = accounts.get(pin);
    for(Map.Entry<Integer, Account> i : accounts.entrySet()){
        if(i.getValue().getAccountData().getPin() == pin && i.getValue().getAccountData().getId() == id) {
            return true;
        }
        }
        return false;

    }

    public ActionResult<AccountData> deposit(AccountData accountData, Float amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        if(amount > 0.00) {
            return ActionResult.success(account.getAccountData());
        }
        else
        {
            return ActionResult.fail("Input a value greater than $0.00");
        }
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, Float amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {
            if (amount > 0.00) {
                return ActionResult.success(account.getAccountData());
            } else {
                return ActionResult.fail("Input a value greater than $0.00");
            }
        }
        else {
            return ActionResult.fail(String.format("Withdraw failed: $%.2f. Account has: $%.2f", amount, account.getBalance()));
        }
    }
}
