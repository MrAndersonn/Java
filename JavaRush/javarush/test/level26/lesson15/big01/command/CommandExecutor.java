package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yaroslav on 02.03.2015.
 */
public  class CommandExecutor
{
    private static Map<Operation, Command> operationCommandMap ;

    private CommandExecutor()
    {
    }

    static {
        operationCommandMap=new HashMap<>();
        operationCommandMap.put(Operation.INFO,new InfoCommand());
        operationCommandMap.put(Operation.DEPOSIT,new DepositCommand());
        operationCommandMap.put(Operation.EXIT, new ExitCommand());
        operationCommandMap.put(Operation.WITHDRAW,new WithdrawCommand());

    }

    public static final void execute(Operation operation) throws IOException
    {
       /* for (Map.Entry<Operation, Command> entry : operationCommandMap.entrySet())
        {
            if (entry.getKey()==operation)
                entry.getValue().execute();
        }*/
        operationCommandMap.get(operation).execute();
    }
}
