package com.gmail.Jay9011.Jet2004.blockgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
// 현재 화면이 가로/세로 변경되지 않도록 지정하기
// AndroidManifest.xml 에 screenOrientation="portrait" 지정

// 액션바 없애기 -> styles.xml 에서 NoActionBar 지정
public class Intro extends AppCompatActivity {
    // 초기화면
    // 3초동안 보이고, 다음 화면 (Main) 으로 넘어가기...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        Handler mhandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);  // 화면 전환
                finish();   // intro 화면 종료
            }
        };

        mhandler.sendEmptyMessageDelayed(1, 3000);

    } // end onCreate
} // end Intro
