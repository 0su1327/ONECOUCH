package com.professionalandroid.apps.onecouch_activitiy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class OneCouch_Activity1 extends AppCompatActivity {
    Button next_id;
    EditText et1_name;
    EditText et2_tall;
    EditText et3_act;
    ImageButton btn1_id;
    ImageButton btn2_id;
    ImageButton btn3_id;
    String name;
    int tall;
    int act;
    double cal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("OneCouch_Start");


        btn1_id = findViewById(R.id.btn1_id);
        btn1_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OneCouch_Activity1.this, "이름 저장 완료!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btn2_id = findViewById(R.id.btn2_id);
        btn2_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OneCouch_Activity1.this, "숫자만 입력했다면 저장 완료!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btn3_id = findViewById(R.id.btn3_id);
        btn3_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OneCouch_Activity1.this, "모두 완료했으면 다음 버튼으로!",
                        Toast.LENGTH_SHORT).show();
            }
        });


        et1_name = findViewById(R.id.et1_name);
        et2_tall = findViewById(R.id.et2_tall);
        et3_act = findViewById(R.id.et3_act);


        SharedPreferences a = getSharedPreferences("name", 0);
        SharedPreferences b = getSharedPreferences("tall", 0);
        SharedPreferences c = getSharedPreferences("act", 0);

        String d = a.getString("name", "");
        String e = b.getString("tall", "");
        String f = c.getString("act", "");

        et1_name.setText(d);
        et2_tall.setText(String.valueOf(e));
        et3_act.setText(String.valueOf(f));

        next_id = findViewById(R.id.next_id);
        next_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneCouch_Activity1.this, OneCouch_Activity2.class);
                tall = Integer.parseInt(et2_tall.getText().toString());
                act = Integer.parseInt(et3_act.getText().toString());
                name = et1_name.getText().toString();
                cal = ((tall-100) * 0.9)*act;
                String recal = String.format("%.2f", cal);
                intent.putExtra("cal", recal);
                intent.putExtra("name", name);
                startActivity(intent);//다음 화면 이동
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences a = getSharedPreferences("name", 0);
        SharedPreferences.Editor editor = a.edit();
        SharedPreferences b = getSharedPreferences("tall", 0);
        SharedPreferences.Editor editor1 = b.edit();
        SharedPreferences c = getSharedPreferences("act", 0);
        SharedPreferences.Editor editor2 = c.edit();
        String d = et1_name.getText().toString();
        String e = et2_tall.getText().toString();
        String f = et3_act.getText().toString();
        editor.putString("name", d);
        editor1.putString("tall", e);
        editor2.putString("act",f);
        editor.commit();
        editor1.commit();
        editor2.commit();
    }
    protected void onStop(){
        super.onStop();
        SharedPreferences a = getSharedPreferences("name", 0);
        SharedPreferences.Editor editor = a.edit();
        SharedPreferences b = getSharedPreferences("tall", 0);
        SharedPreferences.Editor editor1 = b.edit();
        SharedPreferences c = getSharedPreferences("act", 0);
        SharedPreferences.Editor editor2 = c.edit();
        String d = et1_name.getText().toString();
        String e = et2_tall.getText().toString();
        String f = et3_act.getText().toString();
        editor.putString("name", d);
        editor1.putString("tall", e);
        editor2.putString("act",f);
        editor.commit();
        editor1.commit();
        editor2.commit();
    }
}