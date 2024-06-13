
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(123456, 123);
                data.put(123, 123);
                System.out.println("Welcome to the ATM!");
                System.out.println("Enter your account number:");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter your pin number:");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid characters(s).Only numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong customer number or pin number!" + "\n");
        } while (x == 1);
    }

    int selection;

    public void getAccountType() {
        System.out.println("Select the account you want to access:");
        System.out.println("Type 1 - Checking account");
        System.out.println("Type 2 - Saving account");
        System.out.println("Type 3 - Exit");
        System.out.println("Enter your choice:");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM,bye.");
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking account:");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Enter choice:");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM,bye.");
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving account:");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Enter choice:");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM,bye.");
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSaving();
        }
    }
}
