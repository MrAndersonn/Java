package model;



import vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 15.07.2015.
 */
public class Provider
{
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString){

        return strategy.getVacancies(searchString);
    }
}
