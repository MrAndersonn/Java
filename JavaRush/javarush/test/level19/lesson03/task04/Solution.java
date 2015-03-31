package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String s = scanner.nextLine();
            String[] mas = s.split(" ");
            Calendar calendar =new GregorianCalendar(Integer.parseInt(mas[5]),Integer.parseInt(mas[4])-1,Integer.parseInt(mas[3]));
//            calendar.ge
            return new Person(mas[1],mas[2],mas[0],calendar.getTime());


        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
}
