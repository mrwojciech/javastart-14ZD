package pl.notify.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.notify.config.AppConfig;

import java.io.IOException;

/**
 * Automatyczna konfiguracja oparta o skanowanie klas oznaczonych adnotacjami
 * @Component, @Service, @Repository
 * Adnotacja @ComponentScan wskazuje, które pakiety chcemy skanować
 * należy usunąć adnotację @Configuration z klasy AppConfig inaczej spring utworzy zduplikowane
 * obiekty w kontenerze
 */

@Configuration
@ComponentScan("pl.notify")
public class NotificationApplicationAuto {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(NotificationApplicationAuto.class);
        NotificationFacade notificationFacade = context.getBean(NotificationFacade.class);
        try {
            notificationFacade.sendNotifications();
        } catch (IOException e) {
            System.err.println("Nie udało się wysłać powiadomień");
        }
    }
}
