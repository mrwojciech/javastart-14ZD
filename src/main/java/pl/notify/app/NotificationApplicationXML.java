package pl.notify.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.FileNotificationReader;
import pl.notify.sender.EmailNotificationSender;

import java.io.IOException;

/**
 * Konfiguracja beanów springa w pliku beans-config.xml
 */
public class NotificationApplicationXML {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
        NotificationFacade facade = context.getBean(NotificationFacade.class);
        try {
            facade.sendNotifications();
        } catch (IOException e) {
            System.err.println("Nie udało się wysłać powiadomień");
        }
    }
}
