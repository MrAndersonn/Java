package com.javarush.test.level08.lesson11.home09;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.printf("" +isDateOdd("JANUARY 1 2000"));

    }

    public static boolean isDateOdd(String date)
    {

        Date f= new Date(date);

        String[] masdat=date.split(" ");
        f.setDate(Integer.parseInt(masdat[1]));
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(f);
        //System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //date.



        return calendar.get(Calendar.DAY_OF_YEAR)%2!=0;
    }
}
