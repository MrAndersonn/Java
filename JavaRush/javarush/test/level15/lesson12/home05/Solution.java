package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/



public class Solution {

    public Solution(){}
    public Solution(int i){}
    public Solution(int k,float s ){}

    Solution(String s){}
    Solution(String s, int l){}
    Solution(String s,float l){}

    protected Solution(boolean l){}
    protected Solution(boolean l ,int u){}
    protected Solution(boolean l, float s){}

    private Solution(Object o){}
    private Solution(Object o,int i ){}
    private Solution(Object o , float k){}




}



