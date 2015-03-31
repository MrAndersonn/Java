package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/


import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)throws Exception{


        FileInputStream inputStream = new FileInputStream(args[0]);
        List<Character> characters = new ArrayList<>();
        int count =0;
        double e;
        while (inputStream.available()>0){
            characters.add((char)inputStream.read());
        }

        for (Character character : characters)
        {

            if (character.equals(' '))
                count++;
        }

        double k = characters.size();
        e = (count / k)*100;
        System.out.printf("%.2f",e);

    }
}
