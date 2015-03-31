package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String  name ;
        String lastname;
        int age;
        int age2;
        int age3;
        String getName;

        public Human(String name)
        {

            this.name = name;
        }
        public Human(String name,String lastname)
        {
            this.lastname = lastname;
            this.name = name;
        }
        public Human(int age2,int age)
        {
            this.age=age;
            this.age2 = age2;
        }
        public Human(int age,String name){
            this.age=age;
            this.name=name;
        }
        public Human(){}

        public Human(int age,int age2,int age3){
            this.age=age;
            this.age2=age2;
            this.age3=age3;
        }
        public Human(String name,int age2)
        {
            this.age2=age2;
            this.name = name;
        }
        public Human(String name,int age,int age2)
        {
            this.age2=age2;
            this.age = age;
            this.name = name;
        }

        public Human(String name,String  lastname,int age2)
        {
            this.lastname=lastname;
            this.age2=age2;

            this.name = name;
        }
        public Human(String name,String lastname,int age2,int age3)
        {
            this.lastname=lastname;
            this.age2=age2;
            this.age3=age3;

            this.name = name;
        }

    }
}
