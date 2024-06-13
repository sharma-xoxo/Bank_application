
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 10000;
    private double savingBalance = 5000;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // set the customer number
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    // Get the customer number
    public int getCustomerNumber() {
        return customerNumber;
    }

    // Set pin number
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    // get pin number
    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from checking balance:");
        double amount = input.nextDouble();
        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient checking account balance!!" + "\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from saving balance:");
        double amount = input.nextDouble();
        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New saving account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient saving account balance!!" + "\n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit to checking balance:");
        double amount = input.nextDouble();
        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient checking account balance!!" + "\n");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit to saving balance:");
        double amount = input.nextDouble();
        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New saving account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient saving account balance!!" + "\n");
        }
    }
}