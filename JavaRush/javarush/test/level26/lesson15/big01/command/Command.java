package com.javarush.test.level26.lesson15.big01.command;

import java.io.IOException;

/**
 * Created by Yaroslav on 02.03.2015.
 */
interface Command
{
    public void execute() throws IOException;
}
