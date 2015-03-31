package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream=null;
        String name=null;
        while (true){
            /*String name = null;
            try
            {
            }
            catch (IOException e)
            {
            }*/
            try
            {
                name = reader.readLine();
                fileInputStream = new FileInputStream(name);
            }
            catch (FileNotFoundException e)
            {
                System.out.println(name);

                break;
            }

        }
        //assert fileInputStream != null;
       /* try
        {
            fileInputStream.close();
            reader.close();
        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }*/

    }
}
