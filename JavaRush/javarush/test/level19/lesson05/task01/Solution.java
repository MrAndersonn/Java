package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> in = new ArrayList<Integer>();
        FileInputStream in1 = new FileInputStream(reader.readLine());
        FileOutputStream out =new FileOutputStream(reader.readLine());

        while (in1.available()>0){

              in.add(in1.read());

        }

        for (int i = 1; i < in.size(); i+=2)
        {


           out.write(in.get(i));
        }

        in1.close();
        out.close();
    }
}
