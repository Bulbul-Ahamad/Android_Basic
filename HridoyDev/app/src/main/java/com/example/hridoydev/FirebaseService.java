package com.example.hridoydev;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("RefreshedToken",token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        if (message.getNotification()!=null) {
            pushNotification(message.getNotification().getTitle(), message.getNotification().getBody());
        }
    }

    private void pushNotification(String title, String msg) {

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        final String CHANNEL_ID = "My Channel";
        Intent iNotify  = new Intent(getApplicationContext(),MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent Pi;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Pi = PendingIntent.getActivity(this,100,iNotify,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        }
        else{
            Pi = PendingIntent.getActivity(this,100,iNotify,PendingIntent.FLAG_UPDATE_CURRENT);
        }


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            CharSequence name  = "Custom Channel";
            String description = "Channel for Push Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,importance);
            channel.setDescription(description);


            if (nm!=null)
                nm.createNotificationChannel(channel);

            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.notification)
                    .setContentTitle(title)
                    .setSubText(msg)
                    .setContentIntent(Pi)
                    .setAutoCancel(true)
                    .setChannelId(CHANNEL_ID)
                    .build();
//            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"new channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.notification)
                    .setContentTitle(title)
                    .setSubText(msg)
                    .setContentIntent(Pi)
                    .setAutoCancel(true)
                    .build();
        }

        if (nm != null) {
            nm.notify(1,notification);
        }

    }

}
