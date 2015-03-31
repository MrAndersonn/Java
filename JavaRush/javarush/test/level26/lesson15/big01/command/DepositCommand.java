package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.io.IOException;

/**
 * Created by Yaroslav on 02.03.2015.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws IOException
    {
        String s = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s);
        String[] val = ConsoleHelper.getValidTwoDigits(s);
        currencyManipulator.addAmount(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
    }
}
