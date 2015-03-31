package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;// =new String();
        boolean w=false;
        int k ;
        double d;
        short d1;
        while (true)
        {
            s = reader.readLine();
            if (s.equals("exit")) break;

            try
            {
                if (s.contains("."))
                {

                    d = Double.parseDouble(s);
                    print(d);
                } else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128)
                {
                    d1 = Short.parseShort(s);
                    print(d1);
                } else if (Integer.parseInt(s) >= 128)
                {
                    k = Integer.parseInt(s);
                    print(k);
                }
            }
            catch (Exception e)
            {
                print(s);
            }
        }



    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
