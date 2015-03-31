package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile=reader.readLine();
        FileInputStream in = new FileInputStream(inFile);
        FileOutputStream out ;
        List<Character> in1 = new ArrayList<>();
        List<Character> in2 = new ArrayList<>();
        while (in.available()>0){
            in1.add((char)in.read());
        }
        in=new FileInputStream(reader.readLine());
        while (in.available()>0){
            in2.add((char)in.read());
        }
        out=new FileOutputStream(inFile);
        for (Character character : in2)
        {
            out.write(character);
        }
        for (Character character : in1)
        {
            out.write(character);
        }


    }
}
