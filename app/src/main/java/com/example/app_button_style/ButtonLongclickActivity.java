package com.example.app_button_style;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonLongclickActivity extends AppCompatActivity
        implements View.OnLongClickListener {
    private TextView tv_result;//声明一个文本视图实例

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_longclick);
        tv_result = findViewById(R.id.tv_result);//获取名为tv_reuslt的文本视图
        //从布局文件中获取btn_longclick_single的按钮控件
        Button btn_longclick_single = findViewById(R.id.btn_longclick_single);
        //设置长按按钮监听器，一旦用户长按按钮，就会触发监听器的onLongClick()方法
        btn_longclick_single.setOnLongClickListener(new MyOnLongClickListener());
        //从布局文件中获取名叫btn_longclick_public的按钮控件
        Button btn_longclick_public = findViewById(R.id.btn_longclick_public);
        btn_longclick_public.setOnLongClickListener(this);
    }

    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btn_longclick_public) {
            //来自按钮btn_longclick_public
            String desc = String.format("%s您长按了按钮：%s",
                    DateUtil.getNowTime(), ((Button) v).getText());
            tv_result.setText(desc);//设置文本视图
        }
        return true;
    }


    // 定义一个长按监听器，它实现了接口View.OnLongClickListener
    class MyOnLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            String desc = String.format("%s您长按了按钮：%S",
                    DateUtil.getNowTime(), ((Button) v).getText());
            tv_result.setText(desc);
            return true;
        }
    }
}
