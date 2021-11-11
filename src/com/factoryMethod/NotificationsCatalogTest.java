package com.factoryMethod;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotificationsCatalogTest {
    @Test
    public void shouldSelectSMS() {
        NotificationsCatalog nc = new NotificationsCatalog("SMS");
        Assertions.assertEquals(new SMSNotifications().show(), nc.createNotification().show());
    }

    @Test
    public void showPush() {
        NotificationsCatalog nc = new NotificationsCatalog("Push");
        Assertions.assertEquals(new PushNotifications().show(), nc.createNotification().show());
    }


    @Test
    public void shouldReturnNull() {
        NotificationsCatalog nc = new NotificationsCatalog("Not Matching");
        Assertions.assertEquals("Invalid Notification Type", nc.createNotification().show());
    }
}
