package com.javarush.test.level14.lesson08.bonus01;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.List;


/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileInputStream in = new  FileInputStream("dada");
        }catch (Exception e){
            exceptions.add(e);
        }
        try
        {
            throw new InputMismatchException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        int[] buff =new int[2];
        try{
            buff[3]=3;
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new EmptyStackException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new ClassNotFoundException() ;
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new EOFException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw  new ClassCastException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new ClassFormatException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw  new IOException();
        }catch (Exception e){
            exceptions.add(e);
        }



    }
}
