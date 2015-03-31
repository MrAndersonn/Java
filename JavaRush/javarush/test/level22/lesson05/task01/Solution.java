package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException
    {

        try
        {
            int i= string.indexOf(' ');
            int i1=string.indexOf(' ',i+1);
            int i2=string.indexOf(' ',i1+1);
            int i3=string.indexOf(' ',i2+1);
            int i4=string.indexOf(' ',i3+1);

            return string.substring(i+1,i4);

        }catch (Exception e){
            throw  new TooShortStringException();
        }
        //  return null;
    }



    public static class TooShortStringException extends Exception {

    }
}
