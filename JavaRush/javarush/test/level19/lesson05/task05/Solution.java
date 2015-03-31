package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        FileOutputStream out=new FileOutputStream(reader.readLine());
        List<Character> list =new ArrayList<>();
        byte[] chart =new byte[in.available()];
        byte[] chart1 = new byte[0];
        while (in.available()>0){

            in.read(chart);
            for (int i = 0; i <chart.length; i++)
            {
                list.add((char)chart[i]);


            }
            for (int i = 0; i <list.size() ; i++)
            {


                Character s=list.get(i);
                if (!(Character.isLetterOrDigit(s) || Character.isSpaceChar(s))){
                    list.remove(i);
                    i--;
                }
            }
            chart1 = new byte[list.size()];
            for (int i = 0; i <list.size() ; i++)
            {
                char x = (char)list.get(i);

                chart1[i]=(byte)x;

            }
            out.write(chart1);
        }

       // for (Character x : list) System.out.print(x);




    }
}
