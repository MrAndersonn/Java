package model;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 16.07.2015.
 */

public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    public static final String CITY = "Киев";
    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        Document document = null;
        int page=0;
        Vacancy vacancy;
        ArrayList<Vacancy> list = new ArrayList<>();
        while (true)
        {
            try
            {
                document = getDocument(searchString,page);
                //document.html();
//                document =Jsoup.connect("http://javarush.ru/testdata/big28data.html").userAgent("Chrome /43.0.2357.134").referrer("google.com").get();
               // document = Jsoup.connect("C:\\Users\\Neo\\Desktop\\1.html").userAgent("Chrome /43.0.2357.134").referrer("google.com").get();
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size()==0) break;
                for (Element element : elements)
                {

                        vacancy = new Vacancy();
                        vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                        vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                        vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                        vacancy.setSiteName(document.title());
                        vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                        vacancy.setUrl(element.getElementsByAttributeValue("target", "_blank").attr("href"));
                        //System.out.println(element.getElementsByAttributeValue("target","_blank").attr("href"));
                        list.add(vacancy);

                }

            }
            catch (IOException e)
            {
                break;
            }
            page++;
        }
        //System.out.println(page);
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent("Chrome /43.0.2357.134").referrer("hh.ua/").get();
    }
}
