package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQUEST_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.notification,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap LargeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        Intent iNotify  = new Intent(getApplicationContext(),MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent Pi = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Pi = PendingIntent.getActivity(this,REQUEST_CODE,iNotify,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        }else{
            Pi = PendingIntent.getActivity(this,REQUEST_CODE,iNotify,PendingIntent.FLAG_UPDATE_CURRENT);
        }

        //Big Picture Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(),R.drawable.profile,null))).getBitmap())
                .bigLargeIcon(LargeIcon)
                .setBigContentTitle("Image Sent By Queen")
                .setSummaryText("Image messgae");
        //Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("D")
                .addLine("E")
                .addLine("F")
                .addLine("G")
                .addLine("H")
                .addLine("I")
                .addLine("J")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message From Raman");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(LargeIcon)
                    .setSmallIcon(R.drawable.notification)
                    .setContentText("New Message")
                    .setSubText("message from Queen")
                    .setContentIntent(Pi)
//                    .setStyle(inboxStyle)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"new channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(LargeIcon)
                    .setSmallIcon(R.drawable.notification)
                    .setContentText("New Message")
                    .setSubText("message from Queen")
                    .setContentIntent(Pi)
//                    .setStyle(inboxStyle)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification


    }
}