package com.company;

import java.io.*;
import java.util.Scanner;

public class Waiter {

    public Waiter() throws IOException {
    }

    public void deleteItemFromMenu() throws IOException {
        File inputFile = new File("Menu.txt");
        File tempFile = new File("Menu1.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        Scanner input = new Scanner(System.in);
        System.out.print("Line to be removed (ex: Margherita, Pizza, 8.20): ");

        String lineToRemove = input.nextLine();
        String currentLine;


        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        copyFile();

    }

    public static void copyFile() throws IOException {
        FileReader fin = new FileReader("Menu1.txt");
        FileWriter fout = new FileWriter("Menu.txt", false);
        int c;
        while ((c = fin.read()) != -1) {
            fout.write(c);
        }

        fin.close();
        fout.close();
    }

    public static void addNewItemToMenu(String name, String foodType, double price) {

        Food food1 = new Food(name, foodType, price);

        File log = new File("Menu.txt");

        try {
            FileWriter fileWriter = new FileWriter(log, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(food1.toString() + "\n");
            bufferedWriter.close();

            System.out.println("Done");
        } catch (IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
    }

    public void setTables() {
        System.out.println("");
        Table table1 = new Table();
        System.out.println("Table 1: ");
        table1.orderSomething();

        Table table2 = new Table();
        System.out.println("Table 2: ");
        table2.orderSomething();

        Table table3 = new Table();
        System.out.println("Table 3: ");
        table3.orderSomething();


        table1.changeOrderProgressWaiter();
        table2.changeOrderProgressWaiter();
        table3.changeOrderProgressWaiter();

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("Orders.txt", false));
            writer.write(" New Table \n");
            writer.write(table1.order);
            writer.write(" \n New Table \n");
            writer.write(table2.order);
            writer.write(" \n New Table \n");
            writer.write(table3.order);


            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }

    }

    public void makeNewItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input food name: ");
        String name = input.nextLine();
        System.out.println("Input food type: ");
        String foodType = input.nextLine();
        System.out.println("Input price: ");
        double price = input.nextDouble();
        addNewItemToMenu(name, foodType, price);
    }

    public void viewMenu() {
        File fileReader = new File("Menu.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileReader));
            String st;
            int i = 1;
            while ((st = br.readLine()) != null) {
                System.out.println(i + ". " + st);
                i++;
            }
        } catch (IOException e) {
            System.out.println("Something went wrong with reading Menu.txt");
        }

    }

    public void chooseWhatToDo() throws IOException {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("What do u want to do as a waiter?");
            System.out.println("Input 1 to view the menu.");
            System.out.println("Input 2 to delete an item from menu.");
            System.out.println("Input 3 to add new item to menu.");
            System.out.println("Input 4 to set tables.");
            System.out.println("Input 5 to stop the program.");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    deleteItemFromMenu();
                    break;
                case 3:
                    makeNewItem();
                    break;
                case 4:
                    viewMenu();//ne che e nujno prosto za da e ulesneno izbiraneto na poruchka za masata
                    setTables();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }
        } while (flag);

    }
}
