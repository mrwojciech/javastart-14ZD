package pl.notify.sender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

@Component
@Primary
public class SmsSender implements  ISender {

    @Override
    public void send(Notification notification) {
        System.out.println("Sending SMS to " + notification.getTelephone());

    }
}
