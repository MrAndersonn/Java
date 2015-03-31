package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String s = reader.readLine();


        FileInputStream f = new FileInputStream(s);
        int k=0;
        int[] mas = new int[f.available()] ;
        int z=0;
        while (f.available()>0){
            int data1= f.read();
            mas[k]=data1;
            k++;


        }
        for (int i = 0,data=0,o=0; i < mas.length; i++)
        {
            int l= mas[i];
            for (int j = 0; j < mas.length; j++)
            {
                if (l==mas[j]) o++;

            }
            if (o>data) {
                data=o;
                z=l;
            }
            o=0;


        }
        System.out.println(z);
        f.close();
    }
}
