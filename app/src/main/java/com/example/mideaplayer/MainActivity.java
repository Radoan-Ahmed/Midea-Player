package com.example.mideaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.khizar1556.mkvideoplayer.MKPlayer;
import com.khizar1556.mkvideoplayer.MKPlayerActivity;
import com.pd.lookatme.LookAtMe;

import net.alhazmy13.mediapicker.Video.VideoPicker;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    private LookAtMe lookAtMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lookAtMe = findViewById(R.id.lookAtMe);


                new VideoPicker.Builder(MainActivity.this)
                        .mode(VideoPicker.Mode.CAMERA_AND_GALLERY)
                        .directory(VideoPicker.Directory.DEFAULT)
                        .extension(VideoPicker.Extension.MP4)
                        .enableDebuggingMode(true)
                        .build();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths =  data.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH);
            //Your Code

            lookAtMe.init(this);
            lookAtMe.setVideoPath(mPaths.get(0));
        
            lookAtMe.start();
            lookAtMe.setLookMe();


        }
    }


}