package com.javarush.test.level15.lesson12.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    //static List<Character> list = new ArrayList<Character>();
    //static String FILE_NAME = "c:\\1.txt";


    public static void main(String[] args) {
        System.out.println(lines);
    }

    static  {
        BufferedReader reader= null;
        try
        {
           reader = new BufferedReader( new FileReader(Constants.FILE_NAME));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line;

        try
        {
            while ((line =reader.readLine() )!=null){
            lines.add(line);
        }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
