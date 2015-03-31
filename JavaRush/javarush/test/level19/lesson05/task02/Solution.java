package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int o=0;

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader in = new FileReader(reader.readLine());
        reader = new BufferedReader(in);
        
        List<String> list=new ArrayList<>();
        String op;
        while ((op=reader.readLine())!=null){
           list.add(" "+op);
        }

     //   for (String x : list) System.out.println(x);

        for (int i = 0; i < list.size(); i++)
        {
            char[] buf=list.get(i).toCharArray();
            for (int j = 0; j < buf.length; j++)
            {
                Character s = (Character)buf[j];
                if (!Character.isLetterOrDigit(s)){
                   String l = "";
                    if (j<buf.length-6){
                    for (int k = j+1; k <j+6 ; k++)
                    {
                        l+=buf[k];

                    }

                    if (l.equals("world"))o++;
                    else l="";

                    }
                }

            }
        }

        System.out.println(o);
    }
}
