package pl.notify.app;

import org.springframework.stereotype.Component;
import pl.notify.logger.NotifyLogger;
import pl.notify.model.Notification;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.IReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.ISender;

import java.io.IOException;
import java.util.List;

@Component
public class NotificationFacade {

    private IReader iReader;
    private ISender iSender;

    private NotifyLogger logger;

    public NotificationFacade(IReader reader, ISender iSender, NotifyLogger logger) {
        this.iReader = reader;
        this.iSender = iSender;
        this.logger = logger;
    }

    public void sendNotifications() throws IOException {
        List<Notification> notifications = iReader.getNotifications();
        for (Notification notification : notifications) {
            iSender.send(notification);
            logger.log(notification.toString());
        }
    }

}
