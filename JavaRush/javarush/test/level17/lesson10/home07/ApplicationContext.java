package com.javarush.test.level17.lesson10.home07;

import java.util.HashMap;
import java.util.Map;

/* ApplicationContext
ApplicationContext будет доступен множеству нитей.
Сделать так, чтобы данные не терялись: подумай, какое ключевое слово необходимо поставить и где.
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {
    volatile private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    synchronized public GenericsBean getByName(String name) {
          return container.get(name);
    }

   synchronized public GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();
}
