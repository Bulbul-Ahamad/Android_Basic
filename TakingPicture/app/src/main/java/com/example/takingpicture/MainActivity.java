package com.example.takingpicture;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgCam;

    private final int CAMERA_REQ_CODE = 100;
    private final int GALLERY_REQ_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgCam = findViewById(R.id.imgCam);
        Button btnCam = findViewById(R.id.btnCam);
        Button btnGal = findViewById(R.id.btnGal);

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCam = new Intent();
                iCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCam,CAMERA_REQ_CODE);
            }
        });
        btnGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGal = new Intent(Intent.ACTION_PICK);
                iGal.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGal,GALLERY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){

            if (requestCode==CAMERA_REQ_CODE){
                //for Camera
                Bitmap img = (Bitmap)(data.getExtras().get("data"));
                imgCam.setImageBitmap(img);

            }
            else{
                imgCam.setImageURI(data.getData());
            }

        }

    }
}