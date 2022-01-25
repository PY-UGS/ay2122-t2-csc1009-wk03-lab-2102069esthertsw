package com.esther.lab.wk03;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class Q1Loan {   //name
    private double annualInterestRate;  //attributes
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public void Loan(){  //method
        annualInterestRate = 2.5;
        numberOfYears = 1;
        loanAmount = 1000;
        Date currentDate = new Date();
        this.loanDate = currentDate;
    }

    public void Loan(double annualInterestRate, int numberOfYears, double loanAmount)
    {
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYears);
        setLoanAmount(loanAmount);
        Date currentDate = new Date();
        this.loanDate = currentDate;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public int getNumberOfYears() {
        return this.numberOfYears;
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    public Date getLoanDate() {
        return this.loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment()
    {
        return ((this.loanAmount * this.annualInterestRate/(12*100))/(1 - Math.pow((1+this.annualInterestRate/(12*100)), (-12* this.numberOfYears))));
    }

    public double getTotalPayment()
    {
        return (getMonthlyPayment() * this.numberOfYears * 12);
    }

    public static void main(String[] args)  //  MAIN method!
    {
        Scanner input = new Scanner(System.in);
        Q1Loan loan1 = new Q1Loan();
        System.out.println("Default Loan: Annual interest rate 2.5%, 1 year for loan, loan amount $1000");
        System.out.println("Create loan: Enter 0 for default, 1 for custom: ");
        int choice = input.nextInt();
        if (choice == 1)
        {
            System.out.print("Enter annual interest rate, for example 8.25: ");
            double interestRate = input.nextFloat();
            System.out.print("Enter number of years for the loan as an integer: ");
            int years = input.nextInt();
            System.out.print("Enter loan amount, for example, 12300.75: ");
            double amount = input.nextDouble();
            loan1.Loan(interestRate, years, amount);    //creates a new loan object

            System.out.println("The loan was created on " + loan1.getLoanDate());
//            System.out.println("Loan amount is $" + df.format(loan1.getLoanAmount()));
            //best to access variables through a method instead of loan1.loanAmount
        }
        else if (choice == 0)
        {
            loan1.Loan();
            System.out.println("The loan was created on " + loan1.getLoanDate());
//            System.out.println("Loan amount is $" + df.format(loan1.getLoanAmount()));
        }

        if (choice == 0 || choice == 1) {
            System.out.println("The monthly payment is $" + df.format(loan1.getMonthlyPayment()));
            System.out.println("The total payment is $" + df.format(loan1.getTotalPayment()));
        }
    }
}
