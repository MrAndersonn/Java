package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        List<Integer> list = new ArrayList<Integer>();
        FileInputStream in = new FileInputStream(s);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        int w = 0;
        while (in.available() > 0)
        {
            list.add(in.read());
        }
       // for (Integer x : list) System.out.println(x);

        for (int i = 0, k = 0, min = Integer.MAX_VALUE; i < list.size(); i++)
        {

            for (int j = 0; j < list.size(); j++)
            {
                if (list.get(i).equals(list.get(j)) )
                {
                    k++;
                }
            }
            map.put(list.get(i), k);

            k = 0;

        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry entry : map.entrySet())
        {
            //  System.out.println(entry.getKey() + ", " + entry.getValue());
            if ((Integer) entry.getValue() < min)
            {
                min = (Integer) entry.getValue();

            }
            //System.out.println(min);
            // System.out.println(w);
            //for (Integer x : list1) System.out.println(x);
        }
        for (Map.Entry entry : map.entrySet())
        {
            if ((Integer)entry.getValue()==min) list1.add((Integer)entry.getKey());
        }

        for (Integer x : list1) System.out.print(x+" ");
    }
}

