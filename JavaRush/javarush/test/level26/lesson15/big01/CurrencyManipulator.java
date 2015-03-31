package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yaroslav on 18.02.2015.
 */
public class CurrencyManipulator
{
    String currencyCode;
    Map<Integer,Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        denominations= new HashMap<>();
        this.currencyCode = currencyCode;
    }
    public boolean hasMoney() {
        boolean result = false;

        for(Map.Entry<Integer, Integer> pair : denominations.entrySet()){
            if(pair.getValue() != 0){
                result = true;
            }
        }
        return result;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        if (denominations.keySet().contains(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else
            denominations.put(denomination, count);
    }

    public  int getTotalAmount(){
        int sum=0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            int k = entry.getKey();
            int v = entry.getValue();
            sum +=k*v;
        }
        return sum;
    }


}
