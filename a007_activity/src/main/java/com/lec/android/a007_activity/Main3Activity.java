package com.lec.android.a007_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    EditText et1, et2;
    Button btnStart;
    TextView tvResult;
    private final int REQUEST_CODE_CALC = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btnStart = findViewById(R.id.btnStart);
        tvResult = findViewById(R.id.tvResult);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(et1.getText().toString());
                int b = Integer.parseInt(et2.getText().toString());

                Intent intent = new Intent(getApplicationContext(), CalcActivity.class);
                intent.putExtra("num1", a);
                intent.putExtra("num2", b);

                // 일반적인 액티비티 실행
//                startActivity(intent);    // 값을 돌려받지 못함

                // 값을 돌려받기 위한 액티비티 실행
                startActivityForResult(intent, REQUEST_CODE_CALC);
            }
        });



    } // onCreate

    // startActivityForResult() 로 넘어갔던 화면으로부터 결과값을 돌려받으면 호출되는 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {  // 정상 반환의 경우
            switch (requestCode) {
                case REQUEST_CODE_CALC :
                    int a = data.getIntExtra("plus", 0);
                    int b = data.getIntExtra("minus", 0);

                    tvResult.setText(requestCode + "] 받아온 값 : " + a + " : " + b);
                    break;

            }
        } else {
                                        // 정상 반환이 아닌 경우 처리
        }

    }
} // Main3Activity
