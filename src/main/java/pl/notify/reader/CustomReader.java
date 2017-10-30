package pl.notify.reader;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Primary
public class CustomReader implements IReader{
    private final String EXIT = "EXIT";


    public List<Notification> getNotifications() throws IOException {

        List<Notification> notifications = new ArrayList<>();

        String answare = null;

        do {
            answare = getNotification();
            if (!EXIT.equals(answare)){
                String[] split = answare.split(";");
                Notification notificaion = new Notification(split[0], split[1], split[2], split[3]);
                notifications.add(notificaion);
            }
        } while (!EXIT.equals(answare));
        return notifications;
    }

    private String getNotification() {
        Scanner scanner = new Scanner(System.in);
        String answare = "EXIT", answare1;
        System.out.println("Wpisz NEXT, aby dodac kolejne powiadomienie lub EXIT, aby zakonczyc");
        answare1 = scanner.nextLine();
        if (!EXIT.equals(answare1)){
            System.out.println("Podaj nazwe uzytkownika:");
            answare = scanner.nextLine()+";";
            System.out.println("Podaj email:");
            answare += scanner.nextLine()+";";
            System.out.println("Podaj nr. telefonu: ");
            answare += scanner.nextLine()+";";
            System.out.println("Podaj tresc do wyslania: ");
            answare += scanner.nextLine();
        }
        return answare;
    }

}