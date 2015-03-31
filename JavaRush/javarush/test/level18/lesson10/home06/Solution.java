package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/


import java.io.FileInputStream;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
//        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(args[0]);
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        int count = 1;

        while (in.available()>0){
            list.add((char)in.read());
        }

        /*for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i));
        }*/
        for (int i = 0; i < list.size(); i++)
        {

            for (int j = 0; j < list.size(); j++)
            {
                if (i!=j&&list.get(i)==(list.get(j)))
                {
                    count++;
                    list.remove(j);
                    j--;

                }
            }
            map.put(list.get(i),count);
            list.remove(i);
            i--;
            count=1;
        }


        TreeMap<Character, Integer> treeMap =new TreeMap();
        treeMap.putAll(map);
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet())
        {
            System.out.println(entry.getKey()+ " "+entry.getValue());
        }
    }

}
