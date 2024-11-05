package Lesson3;

public class User {
    String name;
    int bankCard;
    int pinNum;
    double checkingAcc;
    double savingAcc;

    public User(String name, int bankCard, int pinNum, double checkingAcc, double savingAcc) {
        this.name = name;
        this.bankCard = bankCard;
        this.pinNum = pinNum;
        this.checkingAcc = checkingAcc;
        this.savingAcc = savingAcc;
    }

    public double balance() {
        return checkingAcc + savingAcc;
    }

    public double withdrawFundsFromChecking(double amount) {
        return checkingAcc-amount;
    }

    public double withdrawFundsFromSaving(double amount) {
        return savingAcc-amount;
    }

    public double depositFunds(double amount) {
        return savingAcc+amount;
    }





}
