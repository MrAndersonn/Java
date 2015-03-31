package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Neo on 04.12.2014.
 */
public class Hrivna extends Money
{


    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
