package Controller;

import model.Model;
import vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Neo on 15.07.2015.
 */
public class Controller
{
    Model model;

    private ArrayList<Vacancy> vacancies = new ArrayList<Vacancy>();

    public Controller(Model model)
    {
        if (model==null) throw new IllegalArgumentException();
        this.model = model;
    }
    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }
}
