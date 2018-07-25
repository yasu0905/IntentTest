package com.example.kazukiyasui.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //遷移元からのデータを取得
        intent = getIntent();
        String message = intent.getStringExtra("message");

        if (message != null) {
            //メッセージ出力
            Toast.makeText(SubActivity.this, message, Toast.LENGTH_LONG).show();
        }

        //「A」ボタン
        Button bt_a = findViewById(R.id.btn_A);
        bt_a.setOnClickListener(this);

        //「B」ボタン
        Button bt_b = findViewById(R.id.btn_B);
        bt_b.setOnClickListener(this);

        //「Cancel」ボタン
        Button bt_cancel = findViewById(R.id.btn_Cancel);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_A:
            case R.id.btn_B:
                intent.putExtra("button_text", ((Button)view).getText());
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_Cancel:
                setResult(Activity.RESULT_CANCELED, intent);
                finish();
                break;
        }
    }
}
