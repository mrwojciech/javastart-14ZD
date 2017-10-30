package pl.notify.app;

import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.CustomReader;
import pl.notify.reader.IReader;
import pl.notify.sender.ISender;
import pl.notify.sender.SmsSender;

import java.io.IOException;

/**
 * Konfiguracja beanów springa w pliku beans-config.xml
 */
public class NotificationApplication {

    public static void main(String[] args) {
        IReader reader = new CustomReader();
        ISender sender = new SmsSender();
        NotifyLogger logger = new FileLogger();

        NotificationFacade facade = new NotificationFacade(reader, sender, logger);
        try {
            facade.sendNotifications();
        } catch (IOException e) {
            System.err.println("Nie udało się wysłać powiadomień");
        }
    }
}
