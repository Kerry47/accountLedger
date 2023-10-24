package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;


public class Transaction {
    private String description;
    private String vendor;
    private LocalDate date;
    private LocalTime time;
    private double amount;

    public Transaction(String description, String vendor, LocalDate date, LocalTime time, double amount) {
        this.description = description;
        this.vendor = vendor;
        this.date = date;
        this.time = time;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }
}