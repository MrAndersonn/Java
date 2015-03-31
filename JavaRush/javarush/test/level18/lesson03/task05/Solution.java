package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> list1 = new HashSet<Integer>();
        int k = 0;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        FileInputStream file = new FileInputStream(string);

        while (file.available() > 0)
        {
            list.add(k, file.read());
            k++;
        }
        list1.addAll(list);

        list.clear();
        list.addAll(list1);
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size(); j++)
            {


                if (list.get(i) < list.get(j))
                {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }

            }


            file.close();
        }

        for (Integer i : list) System.out.print(i+" ");
    }


}
