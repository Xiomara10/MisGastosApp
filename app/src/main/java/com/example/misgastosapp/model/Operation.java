package com.example.misgastosapp.model;

public class Operation {

    private double amount;
    private String operationType;
    private String accountType;
    private static String date;

    public Operation() {
    }

    public Operation(double amount, String operationType, String accountType, String date) {
        this.amount = amount;
        this.operationType = operationType;
        this.accountType = accountType;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
