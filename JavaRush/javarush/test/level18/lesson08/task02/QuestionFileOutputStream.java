package com.javarush.test.level18.lesson08.task02;

import java.io.*;

/* Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширьте функциональность AmigoOutputStream
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу [Вы действительно хотите закрыть поток? Д/Н]
2. Считайте строку
3. Если считанная строка равна [Д], то закрыть поток
4. Если считанная строка не равна [Д], то не закрывать поток
*/

public class QuestionFileOutputStream  implements AmigoOutputStream  {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    AmigoOutputStream a;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) throws IOException
    {
       this.a=amigoOutputStream;


    }

    @Override
    public void flush() throws IOException
    {
        a.flush();
    }

    @Override
    public void write(int b) throws IOException
    {
        a.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        a.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        a.write(b,off,len);

    }

    @Override
    public void close() throws IOException
    {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String s = reader.readLine();
        if(s.equals("Д")){
            a.close();
        }

    }
}

