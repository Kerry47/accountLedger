package com.pluralsight;

import com.pluralsight.Transaction;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class FilterOne {
    public FilterOne() {
    }

    public static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate, ArrayList<Transaction> transactions) {
        // This method filters the transactions by date and prints a report to the console.
        // It takes two parameters: startDate and endDate, which represent the range of dates to filter by.
        // The method loops through the transactions list and checks each transaction's date against the date range.
        // Transactions that fall within the date range are printed to the console.
        // If no transactions fall within the date range, the method prints a message indicating that there are no results.
        for (int i = 0; i<transactions.size(); i++){
            if(transactions.get(i).getDate().isBefore(startDate)){
                System.out.println("This transaction is before the date: ");
                System.out.println(transactions.get(i).toString());
            }
            if (transactions.get(i).getDate().isAfter(endDate)){
                System.out.println("This transaction is after the date: ");
                System.out.println(transactions.get(i).toString());
            }
            else{
                System.out.println("There are no results!");
            }
        }

    }

    public static void filterTransactionsByVendor(String vendor, ArrayList<Transaction> transactions) {
        // This method filters the transactions by vendor and prints a report to the console.
        // It takes one parameter: vendor, which represents the name of the vendor to filter by.
        // The method loops through the transactions list and checks each transaction's vendor name against the specified vendor name.
        // Transactions with a matching vendor name are printed to the console.
        // If no transactions match the specified vendor name, the method prints a message indicating that there are no results.
        int count = 0;
        for
        (int i = 0; i< transactions.size(); i++){
            if (transactions.get(i).getVendor().contains(vendor)){
                System.out.println(transactions.get(i).toString());
                count ++;
            }
        }
        if (count==0){
            System.out.println("you did it wrong!!");
        }
    }
}

//CANT SEARCH BY VENDOR
//WHEN PRESSING H IT SAYS INVALID OPTION
//