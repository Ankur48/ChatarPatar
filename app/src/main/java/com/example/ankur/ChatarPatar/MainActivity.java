package com.example.ankur.ChatarPatar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView demotext;
    ImageView demoImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        demotext = (TextView) findViewById(R.id.demoText);
        demotext.setText(Prefs.getUSERNAME(this));
        demoImage = (ImageView) findViewById(R.id.demoImage);
        Bitmap bitmap = new ImageSaver(this).
                setFileName("myImage.png").
                setDirectoryName("images").
                load();
        demoImage.setImageBitmap(bitmap);
    }
}
