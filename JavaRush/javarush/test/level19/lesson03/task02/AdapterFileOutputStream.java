package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    public static void main(String[] args) throws  Exception
    {
        AdapterFileOutputStream a = new AdapterFileOutputStream(new FileOutputStream("c:\\1.txt"));
        a.writeString("asdasda123123123sda");

    }
    FileOutputStream fileOutputStream ;
    AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }




    @Override
    public void flush() throws IOException
    {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {

        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
       fileOutputStream.close();
    }
}

