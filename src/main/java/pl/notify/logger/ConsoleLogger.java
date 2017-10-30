package pl.notify.logger;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements NotifyLogger {

    public void log(String message) {
        System.out.println("LOG INFO " + System.currentTimeMillis() + " " + message);
    }

}
