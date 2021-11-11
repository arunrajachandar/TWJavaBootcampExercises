package com.factoryMethod;

public class NotificationsCatalog {

    private String notificationCategory;
    public NotificationsCatalog(String notificationCategory) {
        this.notificationCategory = notificationCategory;
    }

    public Notifications createNotification() {
        if(this.notificationCategory == "SMS") {
            return new SMSNotifications();
        } else if(this.notificationCategory == "Push") {
            return new PushNotifications();
        }
        return () ->  "Invalid Notification Type";
        };
    }
