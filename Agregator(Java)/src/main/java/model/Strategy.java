package model;



import vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by Neo on 15.07.2015.
 */
public interface Strategy
{
    public List<Vacancy> getVacancies(String searchString);
}
