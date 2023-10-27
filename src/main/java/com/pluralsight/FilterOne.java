package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;

public class FilterOne {


    public static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate, ArrayList<Transaction> transactions) {

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

