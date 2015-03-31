package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader(  System.in));
        String s = reader.readLine();

        int max;
        FileInputStream fileReader = new FileInputStream(s);

        max = fileReader.read();
        while (fileReader.available() > 0)
        {
           int data = fileReader.read();
            if (data>max) max = data;
        }
        fileReader.close();
        System.out.println(max);
    }
}