package pl.notify.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.notify.config.AppConfig;

import java.io.IOException;

/**
 * Konfiguracja Java, podobna jak XML, ale beany springa konfigurujemy w klasie konfiguracji
 * oznaczonej @Configuration - w naszym przypadku AppConfig
 */
public class NotificationApplicationJava {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NotificationFacade notificationFacade = context.getBean(NotificationFacade.class);
        try {
            notificationFacade.sendNotifications();
        } catch (IOException e) {
            System.err.println("Nie udało się wysłać powiadomień");
        }
    }
}
