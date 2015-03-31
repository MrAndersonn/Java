package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String s = reader.readLine();

        FileOutputStream out = new FileOutputStream(s );


        while (true){
            String k = reader.readLine();
            for (Character x: k.toCharArray())
            {
                out.write(x);
            }
            out.write('\n');
            if(k.equals("exit")) break;
        }
    }
}
