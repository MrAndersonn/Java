package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Yaroslav on 18.02.2015.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException
    {

        return reader.readLine();
    }
    public static Operation askOperation() {
        Operation operation=null;
        while (operation==null)
        {
            try
            {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(reader.readLine()));
            }
            catch (Exception e ){
                operation=null;
            }
        }
    return  operation;
    }
    public static String askCurrencyCode() throws IOException{

        String s;
        while (true){
            s=reader.readLine();
            if (s.length()==3) {
                return s.toUpperCase();

            }

            else System.out.println("ERROR Валюта");
        }
    }
    public static String[] getValidTwoDigits(String currencyCode) throws IOException{
         String[] mas ;
        while (true){
            mas = reader.readLine().split(" ");
            while (true){
                if (mas.length==2)
                {
                    try
                    {
                        Integer.parseInt(mas[0]);
                        Integer.parseInt(mas[1]);
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("ERROR номинал");
                        mas = reader.readLine().split(" ");

                    }
                }else {
                    System.out.println("ERROR номинал");
                    mas =reader.readLine().split(" ");
                }

            }
            if (Integer.parseInt(mas[0])>0&Integer.parseInt(mas[1])>0)
                return mas;
            else System.out.println("ERROR номинал");

        }



    }
}
