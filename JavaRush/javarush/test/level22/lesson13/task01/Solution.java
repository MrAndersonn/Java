package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args)
    {
        String[] s =getTokens("level22.lesson13.task01", ".");
        for (int i = 0; i < s.length; i++)
        {
            System.out.println(s[i]);
        }
    }
    public static String [] getTokens(String query, String delimiter) {

        int i = 0;
        StringTokenizer tokenizer =new StringTokenizer(query,delimiter);
        String[] mas =null;
        String[] mas1 =new String[query.length()];
        while (tokenizer.hasMoreElements()){


         //   mas=new String[i+1];
            mas1[i]=tokenizer.nextToken();
            i++;
        }
        mas=new String[i];
        for (int j = 0; j < i; j++)
        {
           mas[j]=mas1[j];
        }

        return mas;
    }
}
