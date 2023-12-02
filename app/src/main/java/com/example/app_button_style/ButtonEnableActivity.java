package com.example.app_button_style;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonEnableActivity extends AppCompatActivity
        implements View.OnClickListener {
    private TextView tv_result;
    private Button btn_test;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);
        tv_result = findViewById(R.id.tv_result);

        findViewById(R.id.btn_enalbe).setOnClickListener(this);
        findViewById(R.id.btn_disable).setOnClickListener(this);
        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
    }

    public void onClick(View v) {//设置点击事件
        if (v.getId() == R.id.btn_test) {
            String desc = String.format("%s您点击了按钮：%s",
                    DateUtil.getNowTime(), ((Button) v).getText());
            tv_result.setText(desc);
        }else if(v.getId()==R.id.btn_disable){
            tv_result.setTextColor(Color.GRAY);
            btn_test.setEnabled(false);
        }else if(v.getId()==R.id.btn_enalbe){
            btn_test.setTextColor(Color.BLACK);
            btn_test.setEnabled(true);
        }
    }
}
