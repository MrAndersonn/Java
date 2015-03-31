package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader redReader=new BufferedReader(new InputStreamReader(System.in));

        System.out.print(delitel(Integer.parseInt(redReader.readLine()),Integer.parseInt(redReader.readLine())));


    }


    static int delitel(int a,int b){
        int k =0;
        int l ;
        l= a>b ? a:b;
        for (int i = l; i >1 ; i--)
        {
          //  System.out.println(i);
            if (a%i==0&&b%i==0) k=i;

        }
      //  System.out.println(k);
        if (k!=0) return k;
        else return 1;

    }
}
