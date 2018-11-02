package com.czbix.smbsteamer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;


public class VideoActivity extends AppCompatActivity {
    private  String TAG="VideoActivity";
    private JzvdStd myJzvdStd;
    String testUrl;
    public VideoActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_video);
        Intent intent=getIntent();
        testUrl=intent.getStringExtra("uriPath");
        myJzvdStd= (JzvdStd)findViewById(R.id.videoplayer);
        /**
         * 使用ijkplayer内核
         */
        Jzvd.setMediaInterface(new JZMediaIjkplayer());
        //Jzvd.setMediaInterface(new JZMediaSystem());
        /**
         * 使用exoplyer内核
         */
        //   Jzvd.setMediaInterface(new JZExoPlayer());  //exo
        myJzvdStd.setUp(testUrl
                , "嫂子快长大", JzvdStd.SCREEN_WINDOW_NORMAL);
        Glide.with(this).load("http://192.168.43.227:8080/1.jpg").into(myJzvdStd.thumbImageView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}


