package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class HomeScreen {


    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final String FILE_NAME = "transaction.csv";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    public static void main(String[] args) {
        loadTransactions(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to TransactionApp");
            System.out.println("Choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D":
                    addDeposit(scanner);
                    break;
                case "P":
                    addPayment(scanner);
                    break;
                case "L":
                    ledgerMenu(scanner);
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        scanner.close();
    }

    public static void loadTransactions(String fileName) {

        try {
            File someFile = new File(fileName);
            if (someFile.createNewFile()) {
                System.out.println("Must create a new file:");
            }
        } catch (IOException e) {
            System.out.println("Wait a minute, hold on. The file can not be created. SORRY!");
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String input;
            reader.readLine();
            while ((input = reader.readLine()) != null) {
                String[] value = input.split("\\|");
                LocalDate theDate = LocalDate.parse(value[0], DATE_FORMATTER);
                LocalTime theTime = LocalTime.parse(value[1], TIME_FORMATTER);
                String description = value[2];
                String vendor = value[3];
                double total = Double.parseDouble(value[4]);
                transactions.add(new Transaction(theDate,theTime,vendor, description, total));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Wait task can't be completed");
        }

    }

    public static void saveTransactions(String fileName, Transaction transaction) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true));
            for (Transaction element: transactions) {
                String userInput = String.format("%s,%s,%s,%s,%.2f", element.getDate(), element.getTime(),element.getVendor(), element.getDescription(),element.getAmount());
                bufferedWriter.write(userInput);
                bufferedWriter.close();
            }

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("errrrrrrrrrrrrrrro");
        }
    }




    private static void addDeposit(Scanner scanner) {

        System.out.println("What is the date of the current deposit ? yyyy-MM-dd");
        String input = scanner.nextLine();
        LocalDate date = LocalDate.parse(input, DATE_FORMATTER);

        System.out.println("make something up: HH:mm:ss");
        input = scanner.nextLine();
        LocalTime time = LocalTime.parse(input, TIME_FORMATTER);

        System.out.println("Vendor name");
        String vendor = scanner.nextLine();

        System.out.println("Enter some type of deposit");
        double depositTotal = scanner.nextDouble();
        scanner.nextLine();

        if (depositTotal <= 0) {
            System.out.println("No boss only positive numbers over here");
        }
        Transaction deposit = new Transaction(date, time, "description", vendor, depositTotal);
        transactions.add(deposit);

        saveTransactions("transaction.csv", deposit);
    }

    private static void addPayment(Scanner scanner) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME));
            System.out.println("Add a payment date: yyyy-MM-dd ");
            String input = scanner.nextLine();
            LocalDate date = LocalDate.parse(input, DATE_FORMATTER);

            System.out.println("Add payment time : HH:mm:ss");
            input = scanner.nextLine();
            LocalTime time = LocalTime.parse(input, TIME_FORMATTER);

            System.out.println("Ask the damn vendor a question kerry c'mon ");
            String vendor = scanner.nextLine();

            System.out.println("amount of payment");
            double paymentAmount = scanner.nextDouble();
            scanner.nextLine();
            if (paymentAmount <= 0) {
                System.out.println("Ya done messed up this time buddy try again, only positive numbers");
            }
            Transaction payment = new Transaction(date, time, "description", vendor, paymentAmount);
            transactions.add(payment);

            saveTransactions("transaction.csv", payment);
        } catch (IOException e) {
            System.out.println("Try again");
        }

    }


    private static void ledgerMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Ledger");
            System.out.println("Choose an option:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A":
                    displayLedger();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    reportsMenu(scanner);
                    break;
                case "H":
                    running = false;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void displayLedger() {

        for(Transaction transaction: transactions){
            System.out.println(transaction);
        }

    }


    private static void displayDeposits() {

        for(Transaction transaction: transactions){
            if(transaction.getAmount() >= 0){
                System.out.println(transaction);
            }
        }
    }

    private static void displayPayments() {

            for(Transaction transaction : transactions){
                System.out.println(transaction);
            }
    }

    private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    LocalDate thisMonth = LocalDate.now();
                    LocalDate beginningMonth = LocalDate.of(thisMonth.getYear(), thisMonth.getMonth(), 1);
                    break;

                case "2":
                    LocalDate previousMonth = LocalDate.now();
                    LocalDate beginningOfLastMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1,1);
                    LocalDate endingOfLastMonth = beginningOfLastMonth.plusDays(beginningOfLastMonth.lengthOfMonth() -1);
                    System.out.println(beginningOfLastMonth + " " + endingOfLastMonth);
                    break;
                case "3":
                    LocalDate currentYear = LocalDate.now();
                    LocalDate thisYear = LocalDate.of(currentYear.getYear(), currentYear.getDayOfYear(), 1);
                    break;

                case "4":
                    LocalDate previousYear = LocalDate.now();
                    LocalDate beginningOfLastYear = LocalDate.of(LocalDate.now().getYear() -1,1,1);
                    LocalDate endingOfPreviousYear = beginningOfLastYear.plusDays(beginningOfLastYear.lengthOfYear()-1);
                    System.out.println(beginningOfLastYear + " " + endingOfPreviousYear);
                    break;

                case "5":
                    System.out.println("What is the vendor name ?");

                case "0":
                    running = false;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

}