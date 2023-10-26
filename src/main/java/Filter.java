import com.pluralsight.Transaction;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class Filter {
    private static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate, ArrayList<Transaction> transactions) {

        for (int i =0; i<transactions.size(); i++){
            if(transactions.get(i).getDate().isBefore(startDate)){
                System.out.println("Here is the transactions from you have chosen: ");
            }
            if (transactions.get(i).getDate().isAfter(endDate)){
                System.out.println("Here is the transactions from you have chosen: ");
            }
            else{
                System.out.println("There are no results!");
            }
        }

    }

    private static void filterTransactionsByVendor(String vendor, ArrayList<Transaction> transactions) {




    }
}

