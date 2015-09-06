package view;


import Controller.Controller;
import vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by Neo on 17.07.2015.
 */
public interface View
{
    public void update(List<Vacancy> vacancies) throws IOException;
    public void setController(Controller controller);
}
