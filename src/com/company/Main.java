package com.company;

import java.io.*;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String job;

        int logger = getLogger();
        if (logger == 1) {
            System.out.println("You have joined as a cook.");
            job = "cook";
            // metodite na cook

        } else {
            System.out.println("You have joined as a waiter.");
            job = "waiter";
            //metodite na waiter
            Waiter w1 = new Waiter();
            w1.chooseWhatToDo();
        }


    }

    public static int getLogger() {
        Scanner log = new Scanner(System.in);
        System.out.println("Input 1: for Cook.");
        System.out.println("Input 2: for Waiter.");
        int logger = log.nextInt();
        while (logger != 1 && logger != 2) {

            System.out.println("Wrong input.");

            System.out.println("Input 1: for Cook.");
            System.out.println("Input 2: for Waiter.");
            logger = log.nextInt();

        }
        return logger;
    }


}