package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        FileOutputStream in1 = new FileOutputStream(reader.readLine());
        //FileOutputStream in2 = new FileOutputStream(reader.readLine());
        byte[] byte1 = new byte[in.available()];
        while (in.available()>0){
            byte1 = new byte[in.available()];
            int count = in.read(byte1);
        }
        for (int i = 0; i < byte1.length-1; i++)
        {
            System.out.println(byte1[i]);

        }

        for (int i = byte1.length-1; i >=0; i--){
            in1.write(byte1[i]);

        }


    }
}
