package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        List<Character> list = new ArrayList<Character>();

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream =new FileOutputStream(reader.readLine());

        while (inputStream.available()>0){
            list.add((char)inputStream.read());
        }

        for (int i = 0; i < list.size(); i++)
        {
            String s = new String();

            for (int j = i; j < list.size(); j++)
            {
                if (list.get(j)!=' ')s=s+list.get(j);
                else {
                    break;
                }
                i=j;

            }
            System.out.println(s);
            try{
                Integer.parseInt(s);
                for (char x:s.toCharArray()) outputStream.write(x);

                outputStream.write(' ');

            }catch (Exception e ){}

            s="";
        }



    }
}
