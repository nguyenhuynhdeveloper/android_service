package com.example.android_service;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
// Tạo 1 cái quản lý Notification

public class MyApplication extends Application {
public static  final String CHANNEL_ID = "channel_service_example";

    @Override
    public void onCreate() {
        super.onCreate();

        // Chạy hàm tạo ra 1 cái ChannelNotification : trong onCreate
        createChannelNotification();
    }

    private void createChannelNotification() {
        // Từ android O - API I26 trở lên cần tạo channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            // Tạo 1 cái NotificationChannel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    "Channel Sercice Example",
                    NotificationManager.IMPORTANCE_DEFAULT);

            // Tạo 1 đối tượng quản lý NotificationManager
            NotificationManager manager = getSystemService( NotificationManager.class);
          if(manager != null) {
              manager.createNotificationChannel(channel);
          }
        }
    }
}
