package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("File");
        words.add("Bid");
        words.add("B");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader = new BufferedReader( new FileReader(reader.readLine()));
        String line ;
        int count =0;
        String[] mas;
        while ((line=reader.readLine())!=null){
            mas=line.split(" ");
            for (String ma : mas)
            {
                if (words.contains(ma))
                    count++;
            }
            if (count==2){
                System.out.println(line);
            }
            count=0;
        }


    }
}
