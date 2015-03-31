package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)  {
        PrintStream printStream =System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream =new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        List<Integer> list = new ArrayList<Integer>();

        String string= outputStream.toString();
        char l=0 ;
        String result = string;
        String s = new String();
        for (int i = 0; i < string.toCharArray().length; i++)
        {
            if (string.toCharArray()[i]!=' ') s+=string.toCharArray()[i];

            if (string.toCharArray()[i]==' '){
                try{
                   int x= Integer.parseInt(s);
                    list.add(x);
                    s="";
                }catch ( Exception e ){

                }

            }
            if (string.toCharArray()[i]=='+'|string.toCharArray()[i]=='-'|string.toCharArray()[i]=='*'){
                l=string.toCharArray()[i];
            }


        }
        int c =0;
        if (l=='+'){
           c =list.get(0)+list.get(1);
        }else if (l=='-'){
            c =list.get(0)-list.get(1);
        }else if (l=='*'){
            c =list.get(0)*list.get(1);
        }


        System.setOut(printStream);


        System.out.print(result+c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("126 - 26 = ");
        }
    }
}

