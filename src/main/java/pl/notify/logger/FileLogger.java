package pl.notify.logger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
@Primary //domyślna implementacja interfejsu NotifyLogger, bez tego otrzymamy NoUniqueBeanDefinitionException
public class FileLogger implements NotifyLogger {

    @Override
    public void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))){
            writer.write("LOG INFO " + System.currentTimeMillis() + " " + message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
