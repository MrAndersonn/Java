package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream =new FileInputStream(reader.readLine());
        FileOutputStream inputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream inputStream12 = new FileOutputStream(reader.readLine());
        byte[] buf =new byte[inputStream.available()];
        int c=inputStream.available();
        while (inputStream.available()>0){
            c =inputStream.read(buf);
        }
        //System.out.println(c+" "+c/2+' '+inputStream.available());
        //System.out.println(buf.length+" "+ c);

        if (c%2==1)
        {
            inputStream1.write(buf, 0, c / 2+1 );
            inputStream12.write(buf,c/2+1,c-(c/2+1));
        }else {
            inputStream1.write(buf,0, c/2 );
            inputStream12.write(buf,c/2,c-(c/2));
        }



    }
}
