package model;


import view.View;
import vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 17.07.2015.
 */
public class Model
{
    private View view;
    private Provider[] providers;
    private List<Vacancy> vacancies =new ArrayList<>() ;
    public Model(View view, Provider[] providers)
    {
        if (view == null || providers == null || providers.length == 0)
            throw new IllegalArgumentException();

            this.view = view;
            this.providers = providers;

    }
    public void selectCity(String city)
    {

        for (Provider provider : providers)
        {
            for (Vacancy vacancy : provider.getJavaVacancies(city))
            {
                vacancies.add(vacancy);
            }
        }
        try
        {
            view.update(vacancies);
        }
        catch (IOException e)
        {
            /*e.printStackTrace();*/
        }
    }
}
