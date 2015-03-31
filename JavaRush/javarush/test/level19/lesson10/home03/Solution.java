package com.javarush.test.level19.lesson10.home03;

import java.io.*;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s;
        while ((s=reader.readLine())!=null)
        {
            String[] mas = s.split(" ");
            String name= "";
            for (int i = 0; i < mas.length - 3; i++)
            {
                name +=mas[i]+" ";
            }
            name=name.trim()   ;
            Date date=new Date() ;
            date.setDate(Integer.parseInt(mas[mas.length-3]));
            date.setMonth(Integer.parseInt(mas[mas.length - 2])-1);
            date.setYear(Integer.parseInt(mas[mas.length-1])-1900);
            PEOPLE.add(new Person(name,date));
        }
        /*for (Person s1 : PEOPLE)*/
        /*{*/
        /*    System.out.println(s1.getName()+" "+s1.getBirthday());*/
        /*}*/
        reader.close();

    }

}
