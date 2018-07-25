package com.example.kazukiyasui.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String packageName = getPackageName();

        //「遷移1」ボタン
        Button bt_toSub = findViewById(R.id.btn_toSub);
        bt_toSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClassName(packageName, packageName + ".SubActivity");
                startActivity(intent);
            }
        });

        //「遷移2」ボタン
        Button bt_toSub2 = findViewById(R.id.btn_toSub2);
        bt_toSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClassName(packageName, packageName + ".SubActivity");

                EditText et_message = findViewById(R.id.et_Message);
                String message = et_message.getText().toString();
                intent.putExtra("message", message);

                startActivity(intent);
            }
        });

        //「遷移3」ボタン
        Button bt_toSub3 = findViewById(R.id.btn_toSub3);
        bt_toSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClassName(packageName, packageName + ".SubActivity");

                //画面遷移（戻ってくること前提）
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 0) {
            String btn_str = "";
            switch (resultCode) {
                case Activity.RESULT_OK:
                    btn_str = data.getStringExtra("button_text");
                    break;
                case Activity.RESULT_CANCELED:
                    btn_str = "キャンセルされました。";
                    break;
            }
            Toast.makeText(this, btn_str, Toast.LENGTH_LONG).show();
        }

    }
}
