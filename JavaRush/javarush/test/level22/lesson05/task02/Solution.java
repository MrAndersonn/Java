package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        String s = "qweqw\twqeqwe \t";

        System.out.println(s);
        System.out.println(getPartOfString(s));
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        try{
            int i= string.indexOf('\t');
            int k= string.indexOf('\t',i+1);

            return string.substring(i+1,k);

        }catch (Exception e){
            throw new TooShortStringException();
        }
        //;
    }

    public static class TooShortStringException extends Exception {

    }
}
