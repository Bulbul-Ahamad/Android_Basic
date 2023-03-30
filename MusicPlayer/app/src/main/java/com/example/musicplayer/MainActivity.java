package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button play,pause,btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   {
            play = findViewById(R.id.play);
            pause = findViewById(R.id.pause);
            btnstop = findViewById(R.id.btnstop);

            MediaPlayer mp = new MediaPlayer();

            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

//        String aPath = "android.resource://"+getPackageName()+"/raw/amiakshpathabo";
            String OnlinePath = "http://socialdance.stanford.edu/music/Waltz_Virginia_Reel.m4a";

//        Uri audioURI = Uri.parse(aPath);
            Uri onlinepathURI = Uri.parse(OnlinePath);

            try {
                mp.setDataSource(MainActivity.this, onlinepathURI);
                mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp.pause();
                }
            });
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp.start();
                }
            });
            btnstop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp.pause();
                    mp.seekTo(0);
                }
            });

//        mp.seekTo();
//        mp.getDuration();
//        mp.getCurrentPosition();
//        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//
//            }
//        });
        }*/
        VideoView videoView = findViewById(R.id.videoView);
//        String vpath = "android.resource://"+getPackageName()+"/raw/avm";
        String vOPath = "http://mediamusic-journal.com/video/Backstreet%20Boys%20-%20I%20Want%20It%20That%20Way%20(1999).mp4";
//        Uri videoRaw = Uri.parse(vpath);
        Uri videoOnline = Uri.parse(vOPath);
        videoView.setVideoURI(videoOnline);
        videoView.start();
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



    }
}