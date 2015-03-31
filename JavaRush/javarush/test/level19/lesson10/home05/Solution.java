package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException
    {
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(args[0]);//reader.readLine());
        FileOutputStream out = new FileOutputStream(args[1]);//reader.readLine());
        String[] mas ;
        String file="";
        List<String> words = new ArrayList<>();
        while (in.available()>0){
            char c = (char)in.read();
            if (c=='\n')
                file+=' ';
            else
                file+=c;
        }


        //System.out.println(file);
        mas=file.split(" ");

        String word1="";
        boolean flag = false;
        for (String word : mas)
        {
            for (char c : word.toCharArray())
            {

             //   word1+=c;
                try{
                    Integer.parseInt(""+c);
                    flag =true;
                }catch (Exception e ){
                    //flag=false;
                }
            }
            if (flag)
                words.add(word+" ");
            //word1="";
            flag=false;
        }
       words.add(words.get(words.size() - 1).trim());
        words.remove(words.size()-2);
        for (String word : words)
        {
            for (char c : word.toCharArray())
            {
                out.write(c);
            }
        }


    }
}
