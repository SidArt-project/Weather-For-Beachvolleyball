import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner (System.in);
        System.out.println("Gebe den Tag ein in diesem Format 'dd.m.yyyy':" );
        String user_date = scanner.nextLine();
        System.out.println("Um wie viel Uhr 'HH:MM' soll ich die Wetterdaten abfragen? ");
        String user_time = scanner.nextLine();
        scanner.close();
        new getData().getWeather(user_date, user_time);

    }
}
