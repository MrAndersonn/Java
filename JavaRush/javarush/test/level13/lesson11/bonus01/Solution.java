package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws  Exception
    {


        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        List<Byte> list = new ArrayList<Byte>();
        List<Integer> list1 = new ArrayList<Integer>();
        FileInputStream in =new FileInputStream(reader.readLine());
        while (in.available()>0){
            list.add((byte)(in.read()));
           // System.out.printf("    "+(in.read()));
        }
        list.add((byte)'\n');
        String s =new String();
        for (byte x: list)
        {
            String s1 = "" + (char) x;

            if (s1.equals(" ") || s1.equals("\n"))
            {
                try
                {

                    if (Integer.parseInt("" + s) % 2 == 0)
                    {
                        list1.add(Integer.parseInt("" + s));
                        // System.out.println(Integer.parseInt("" + s));

                    }

                }
                catch (Exception e)
                {
                }
                s = "";
            } else
            {
                if (!s1.equals("\r"))
                    s += (char) x;
            }

        }



    Integer [] a = new Integer[list1.size()];
        for (int i = 0; i < list1.size(); i++)
        {
            a[i]=list1.get(i);
        }
        for(int i = 0; i < a.length - 1; i++)
            for(int j = 0; j < a.length - i - 1; j++)
                if(a[j] > a[j + 1])
                {
                    int swap = a[j];
                    a[j]= a[j+1];
                    a[j+1]=swap;
                }

      for (int x : a) System.out.println(x);



    }
}
