package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.io.IOException;

import java.util.Locale;

/**
 * Created by Yaroslav on 18.02.2015.
 */
public class CashMachine
{
    public static void main(String[] args) throws IOException
    {
        
        Locale.setDefault(Locale.ENGLISH);
        Operation operation=null;
        do
        {
            System.out.println("Введите операцию");
            operation= ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        }while (operation!=Operation.EXIT);

    }

}
