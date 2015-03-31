package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/



import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        List<Character> alphabet = new ArrayList<>();
        List<Character> file = new ArrayList<>();
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(args[0]);
        int count =0;
        while (inputStream.available()>0){
            file.add((char)inputStream.read());
        }

        for (int i=0; i< 26; i++) {
            alphabet.add((char)('a' + i));
//            System.out.println(alphabet.get(i));
        }

        for (Character character : file)
        {
            String s = ""+character;
            Character c= s.toLowerCase().charAt(0);

            if (alphabet.contains(character)||alphabet.contains(c))
            {
                count++;
            }
        }

        System.out.println(count);


    }
}
