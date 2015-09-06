package view;


import Controller.Controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import vo.Vacancy;

import java.io.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neo on 17.07.2015.
 */
public class HtmlView implements View {
    private final String filePath = "D:\\Agregator(Java)\\src\\main\\java\\view\\vacancies.html";
    private Controller controller;//= new Controller(new Provider(new HHStrategy()));


    public List sortVacancies(List<Vacancy> vacancies) {
        ArrayList<Vacancy> list = new ArrayList<>();
        for (Vacancy vacancy : vacancies) {
//            if (vacancy.getTitle().toLowerCase().contains("java"))
//            {
                if (vacancy.getTitle().toLowerCase().contains("java developer"))
                    list.add(0, vacancy);
                else list.add(vacancy);
//            }
        }
        return list;
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(sortVacancies(vacancies)));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        Document document = null;
        String updatedFileContent;


        document = getDocument();

        Element tempElement = document.select("tr[class*=\"template\"]").first();
        Element element = tempElement.clone();
        element.removeClass("template");
        element.removeAttr("style");
        document.select("tr[class=\"vacancy\"]").remove();
//          System.out.println(element.);
        for (Vacancy vacancy : vacancies) {
            Element currentElement = element.clone();
            currentElement.select("td[class=\"city\"]").first().text(vacancy.getCity());
            currentElement.select("td[class=\"companyName\"]").first().text(vacancy.getCompanyName());
            currentElement.select("td[class=\"salary\"]").first().text(vacancy.getSalary());
            currentElement.getElementsByTag("a").first().text(vacancy.getTitle());
            int trim = vacancy.getUrl().indexOf("=");
            String id = vacancy.getUrl().substring(trim + 1);

            currentElement.select("a[href]").attr("href", "http://hh.ua/vacancy/" + id);
            tempElement.before(currentElement.outerHtml());
        }
        //        element.select("class=[\"city\"]").first(
        //        System.out.println(tempElement.getElementsByAttributeValue("class", "title").text());
        //        System.out.println("elements = "+tempElement+ "\n");
        //        System.out.println("elements = "+element);


        return document.toString();
    }

    private void updateFile(String string) throws IOException {
        BufferedWriter bufWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(filePath),
                        Charset.forName("UTF-8")
                )
        );
        bufWriter.write(string);
        bufWriter.flush();
        bufWriter.close();
        /*FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(string.getBytes("UTF-8"));
        fileWriter.flush();
        fileWriter.close();*/
    }

    private Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }


    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Kiev");
    }
}
/*    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            String newVacanciesFileHtml = getUpdatedFileContent(vacancies);
            updateFile(newVacanciesFileHtml);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {
        Document document = null;
        document = getDocument();
        Element original = document.getElementsByClass("template").first();
        Element template = original.clone();
        template.removeClass("template").addClass("vacancy").removeAttr("style");
        document.getElementsByAttributeValue("class","vacancy").remove();
        //document.select("tr[class=\"vacancy\"]").remove();
        for (Vacancy vacancy : vacancies)
        {
            Element vac = template.clone();
            vac.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
            vac.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
            vac.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
            vac.getElementsByAttribute("href").get(0).attr("href", vacancy.getUrl()).text(vacancy.getTitle());
            original.before(vac.outerHtml());
        }
        return document.html();
    }

    private void updateFile(String newData) throws IOException
    {
//      класс с методами записи строк // класс-преобразователь // класс записи байтов в файл
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
        pw.write(newData);
        pw.close();
    }

    protected Document getDocument() throws IOException
    {
        File file = new File(filePath);
        return Jsoup.parse(file, "UTF-8");
    }
}*/
