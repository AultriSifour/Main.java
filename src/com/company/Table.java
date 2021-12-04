package com.company;

import java.io.*;
import java.util.Scanner;

public class Table {
    private String orderProgress;
    String order = "";

    public void changeOrderProgressWaiter() {

        do {
            System.out.println("The order is 'taken', 'served 'or 'payed':");
            Scanner input = new Scanner(System.in);
            this.orderProgress = input.nextLine();
            System.out.println(this.orderProgress);

        } while (this.orderProgress == "served" || this.orderProgress == "payed" || this.orderProgress == "taken");
    }

    public void orderSomething() {
        String[] miniorders = new String[99];
        try {
            File myObj = new File("Menu.txt");
            Scanner myReader = new Scanner(myObj);
            miniorders = new String[99];
            int i = 1;
            while (myReader.hasNextLine()) {
                miniorders[i] = myReader.nextLine();
                i++;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            System.out.println("Make your order(1, 2, 3...): ");
            Scanner input = new Scanner(System.in);
            String fullOrder = input.nextLine();
            String[] miniorders1 = fullOrder.split(", ");
            for (int i = 0; miniorders1.length > i; i++) {
                int a = Integer.parseInt(miniorders1[i]);
                this.order += miniorders[a];
                this.order += "; ";

            }
            System.out.println(this.order);
        } catch (Exception e) {
            System.out.println("You did not use the right format");
        }
    }
}