package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s =reader.readLine();
        String[] buf = s.split(" ");
        FileInputStream in =new FileInputStream(buf[1]);;
        FileOutputStream out=new FileOutputStream(buf[2]);

        while (in.available()>0){
            if (buf[0].equals("-e")){
                int data =in.read()+1;
                out.write(data);
            }else if (buf[0].equals("-d")){
                int data = in.read() -1;
                out.write(data);
            }else return;
        }
        in.close();
        out.close();
    }


}
