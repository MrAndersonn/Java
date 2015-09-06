import Controller.Controller;
import model.HHStrategy;
import model.Model;
import model.Provider;
import view.HtmlView;

import java.io.IOException;


/**
 * Created by Neo on 15.07.2015.
 */
public class Aggregator
{
    public static void main(String[] args) throws IOException {

        HtmlView view=new HtmlView();
        Controller controllerl=new Controller(new Model(view,new Provider[]{new Provider(new HHStrategy())}));
        controllerl.onCitySelect("Kiev");

    }
}
