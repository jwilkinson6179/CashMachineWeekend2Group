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
                1000, "Example 1", "example1@gmail.com", 500
        )));

        accounts.put(2000, new PremiumAccount(new AccountData(
                2000, "Example 2", "example2@gmail.com", 200
        )));

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "James Wilkinson", "JWEmail54@geemail.com", initialBalance
        )));
        id++;

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "Sandy Setiawan", "seti@yoohoo.com", initialBalance
        )));
        id++;

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "Maurice Russ", "Moruss@udel.edu", initialBalance
        )));
        id++;

        accounts.put(id, new PremiumAccount(new AccountData(
                id, "Corey Williams", "cwilliams@un.gov", initialBalance
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Paul Atredes", "maudib@arakkis.co.ak", initialBalance
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Frodo Baggins", "BagEnd420@shire.com", initialBalance
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Luke Cage", "powerman@aliasinvestigations.com", initialBalance
        )));
        id++;

        accounts.put(id, new BasicAccount(new AccountData(
                id, "Bugs Bunny", "bb1931@warner.com", initialBalance
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
