package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Cook {



    public void changeOrderProgressCook() throws IOException {

        String content = "";

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Orders.txt"));
            content = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (content==null){
            System.out.println("There are no orders, you can rest.");}
        else{
            System.out.println("You`ve got work to do!");
        }

    }
}
