package com.example.app_button_style;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_result;//声明一个文本视图实例

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        tv_result = findViewById(R.id.tv_result); // 获取名叫tv_result的文本视图
        // 从布局文件中获取名叫btn_click_single的按钮控件
        Button btn_click_single = findViewById(R.id.btn_click_single);
        // 设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        btn_click_single.setOnClickListener(new MyOnClickListener());
        // 从布局文件中获取名叫btn_click_public的按钮控件
        Button btn_click_public = findViewById(R.id.btn_click_public);
        // 设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        btn_click_public.setOnClickListener(this);
    }

    // 定义一个点击监听器，它实现了接口View.OnClickListener
    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {//点击事件的处理方法
            String desc = String.format("%s您点击了按钮%s",
                    DateUtil.getNowTime(), ((Button) view).getText());
            tv_result.setText(desc);//文本视图的文本内容l
        }
    }

    @Override
    public void onClick(View view) {//点击事件的处理方法
        if (view.getId() == R.id.btn_click_public) {// 来自按钮btn_click_public
            String desc = String.format("%s您点击了%s",
                    DateUtil.getNowTime(), ((Button) view).getText());
            tv_result.setText(desc);
        }
    }
}
