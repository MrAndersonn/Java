package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        FileInputStream in ;
        FileOutputStream out;
        String s;
        String fileName=null;
        ArrayList<String> list = new ArrayList<>();
        String[] mas;
        Map<Integer,String> map = new TreeMap<>();
        ArrayList<Byte> list1 = new ArrayList<>();
        while(!(s=reader.readLine()).equals("end")){
            list.add(s);
        }

        for (String s1 : list)
        {
            mas=s1.split("\\.");
            fileName=mas[0]+"."+mas[1];
            map.put(Integer.parseInt(mas[2].substring(4)),s1);
        }
        for (Map.Entry<Integer, String> entry : map.entrySet())
        {
//            mas=entry.getValue().split("\\.");
//            fileName=mas[0]+mas[1];
            in=new FileInputStream(entry.getValue());

            while (in.available()>0){
                list1.add((byte)in.read());
//                out.write(in.read());
            }
//            System.out.println(entry.getKey() + "    "+ entry.getValue());
        }
        out=new FileOutputStream(fileName);
        for (Byte aByte : list1)
        {
            out.write(aByte);

        }
    }
}
