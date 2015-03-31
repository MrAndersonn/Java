package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Neo on 15.01.2015.
 */
public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(int i)
    {
        super(i);
    }

    public SubSolution(int k, float s)
    {
        super(k, s);
    }

    SubSolution(String s)
    {
        super(s);
    }

    SubSolution(String s, int l)
    {
        super(s, l);
    }

    SubSolution(String s, float l)
    {
        super(s, l);
    }

    protected SubSolution(boolean l)
    {
        super(l);
    }

    protected SubSolution(boolean l, int u)
    {
        super(l, u);
    }

    protected SubSolution(boolean l, float s)
    {
        super(l, s);
    }

    private SubSolution(Object o){}
    private SubSolution(Object o,int i ){}
    private SubSolution(Object o , float k){}
}
