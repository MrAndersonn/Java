package com.javarush.test.level16.lesson10.task02;

public class Solution {
    public static volatile int countSeconds = 5;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут

        Thread.sleep(3500);
        if (clock.isAlive())
        {
            clock.interrupt();
        }


    }

    public static class RacingClock extends Thread {

        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try{
                long startTime = System.currentTimeMillis();
                while (countSeconds > 0)
                {
                    System.out.print(countSeconds + " ");
                    Thread.sleep(1000);
                    countSeconds--;

                }
                System.out.println("Марш!");
            }catch (InterruptedException e)
            {
                System.out.println("Прервано!");
            }
        }
    }
}