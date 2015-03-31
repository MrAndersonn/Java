package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        if (o.quality!=this.quality)
            return o.quality-this.quality;
        else  return (int) (this.distance-o.distance);

//       return  (int) ((o.quality-this.getQuality())+(o.distance-this.getDistance())+(this.name.compareTo(o.getName())));
    }
    public static void main(String[] args)
    {
        Beach beach1 = new Beach("beach", 1.0f, 2);
        Beach beach2 = new Beach("beach", 2.0f, 1);
        System.out.println(beach1.compareTo(beach2));
    }
}
