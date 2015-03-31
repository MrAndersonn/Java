package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Yaroslav on 10.02.2015.
 */
public class LoggingStateThread extends Thread
{
    Thread thread;
    public LoggingStateThread( Thread thread)
    {
        this.thread = thread;
    }

    @Override
    public void run()
    {
        if (thread.getState()==State.TERMINATED)
        {

            switch (thread.getState())
            {
                case NEW:
                    System.out.printf("New".toUpperCase());
                    break;
                case RUNNABLE:
                    System.out.printf("Runnable".toUpperCase());
                    break;
                case TERMINATED:
                    System.out.printf("TERMINATED");
                    break;
            }
        }
    }
}
