import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class getData {

    public NodeList getDatafromAPI() throws Exception {
        String url = "http://api.weatherapi.com/v1/forecast.xml?key=07e03fd333d9409c99a111028231106&q=Kiel&days=3&aqi=no&alerts=no";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse(url);
        NodeList hours = document.getElementsByTagName("hour");
        return hours;

    }


    public void getWeather(String user_date, String user_time) throws Exception {

        for (int i = 0; i < getDatafromAPI().getLength(); i++) {
            String day_and_hour = getDatafromAPI().item(i).getChildNodes().item(1).getTextContent();
            String divider[] = day_and_hour.split(" ");
            String date = divider[0];
            String day = date.substring(divider[0].length() - 2);
            String month = date.substring(divider[0].length() - 4, divider[0].length() - 3);
            String year = date.substring(0, 4);
            String new_date = String.join(".", day, month, year);
            String hour = divider[1];


            double temperature = Double.parseDouble(getDatafromAPI().item(i).getChildNodes().item(2).getTextContent());
            if (user_time.equals(hour) && user_date.equals(new_date)) {
                System.out.printf("Die Temperatur beträgt am %s um %s Uhr: %1.2f°C%n", new_date, hour, temperature);
                break;
            } else {
                continue;
            }
        }
    }


    public void getWind(String user_date, String user_time) throws Exception {
        for (int i = 0; i < getDatafromAPI().getLength(); i++) {
            String day_and_hour = getDatafromAPI().item(i).getChildNodes().item(1).getTextContent();
            String divider[] = day_and_hour.split(" ");
            String date = divider[0];
            String day = date.substring(divider[0].length() - 2);
            String month = date.substring(divider[0].length() - 4, divider[0].length() - 3);
            String year = date.substring(0, 4);
            String new_date = String.join(".", day, month, year);
            String hour = divider[1];


            double wind = Double.parseDouble(getDatafromAPI().item(i).getChildNodes().item(6).getTextContent());
            if (user_date == new_date && user_time == hour) {
                System.out.printf("Der Wind betr\u00E4gt am %s um %s Uhr: %1.1fkm/h%n", new_date, hour, wind);
            } else {
                continue;
            }
        }


    }
}


