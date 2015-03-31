package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        FileOutputStream out = new FileOutputStream(reader.readLine());
        List<Character> list = new ArrayList<>();

        while (in.available()>0){
            list.add((char)in.read());
        }
        String s="" ;
        for (Character character : list)
        {
            /*if (character=='\n'){
                s+=' ';
            }else*/
            s+=character;
        }
        String[] mas = s.split(" ");
        String r9d= "";
        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i].length()>6){

                for (char c : mas[i].toCharArray())
                {
                    r9d+=c;
                }
                r9d+=',';

            }
        }

        if (r9d.toCharArray()[r9d.toCharArray().length-1]==',')
            r9d=r9d.substring(0,r9d.length()-1);
        for (char ma : r9d.toCharArray())
        {
            out.write(ma);
        }
    }
}
