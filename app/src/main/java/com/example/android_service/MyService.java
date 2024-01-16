package com.example.android_service;

import static com.example.android_service.MyApplication.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

   String strDataIntent = intent.getStringExtra("key_data_intent");
   sendNotification(strDataIntent);

        return START_NOT_STICKY ;  // Không yêu cầu khởi động lại khi bị  kill đi
    }

    private void sendNotification(String strDataIntent) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE |PendingIntent.FLAG_UPDATE_CURRENT);
        //  Để có thể mở được màn hình MainActivity khi bấm vào notification

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)   //  CHANNEL_ID được import ở bên MyApplication
                .setContentTitle("Title notification service example")
                .setContentText(strDataIntent)
                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);   //  Khởi động chạy chế độ foreground để hiện được notification
        // Để có thể hiển thị được notification

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Tincoder", "onDestroy: My Service onDestroy" );
    }
}
