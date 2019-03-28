package Task1;

import java.util.Date;

public class Account implements java.io.Serializable {
    private int id;
    private String fname;
    private String lname;
    private int pin;
    private double balance;
    private static transient double annualInterestRate;
    private Date dateCreated;

    Account() {
        this.id = -1;
        this.fname = "";
        this.lname = "";
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
        this.pin = 0;
    }

    Account(int id, double balance) {
        this();
        this.id = id;
        this.balance = balance;
    }

    Account(int id, String fname, String lname, double balance) {
        this(id, balance);
        this.fname = fname;
        this.lname = lname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return this.fname + this.lname;
    }

    public double getBalance() {
        return balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return (annualInterestRate / 12) * balance;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void withdraws(double balance) {
        this.balance -= balance;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public void AssignPinCode(int pin) {
        this.pin = pin;
    }
}
