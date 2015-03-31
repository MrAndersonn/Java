package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<Pair>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "Windows-1251"));
        ArrayList<String> dataLine = new ArrayList<String>();
        //Записываем все слова из файла в ArrayList.
        while(in.ready()){
            dataLine.addAll(Arrays.asList((in.readLine().split(" "))));
        }
        in.close();

        for(int i = 0; i < dataLine.size(); i++)
        {
            for(int j = 0; j < dataLine.size();)
            {
                StringBuilder stringBuilder = new StringBuilder(dataLine.get(i));
                String s = stringBuilder.reverse().toString();

                //Если перевернутая строчка равна обычной строчке, сохраняем данные в result
                //уже записанные данные из dataList удаляем.
                if(dataLine.get(j).equals(s)&&j!=i)
                {
                    Pair pair = new Pair();
                    pair.first = dataLine.get(j);
                    pair.second = dataLine.get(i);
                    result.add(pair);
                    dataLine.remove(j);
                    dataLine.remove(i);
                    j = 0;
                }
                else
                    j++;
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}