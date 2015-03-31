package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:


Пример вывода:
Петров
*/

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String,Double> map = new TreeMap<>();
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        String line ;
        String[] mas;
        while ((line = file.readLine())!=null){
            mas=line.split(" ");
            if (map.containsKey(mas[0])){
                map.put(mas[0], map.get(mas[0]) + Double.parseDouble(mas[1]));
            }else {
                map.put(mas[0],Double.parseDouble(mas[1]));
            }
        }

        double max=Double.MIN_VALUE ;
        String name="" ;
        for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet())
        {

            if (stringDoubleEntry.getValue()>max)
            {
                max=stringDoubleEntry.getValue();
                name =stringDoubleEntry.getKey();
            }
//            System.out.println(stringDoubleEntry.getKey()+" "+stringDoubleEntry.getValue());
        }

        System.out.println(name);
    }
}
