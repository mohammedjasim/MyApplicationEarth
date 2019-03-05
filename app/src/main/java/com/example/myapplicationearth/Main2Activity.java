package com.example.myapplicationearth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView t1,t2;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(TextView)findViewById(R.id.textView3);
        t2=(TextView)findViewById(R.id.textView4);
        ed=(EditText)findViewById(R.id.editText2);

        final String s=getIntent().getStringExtra("Weight");
        t1.setText("Your Weight is : "+s);
        Button btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter your weight",Toast.LENGTH_LONG).show();
                    return;
                }
                t2.setText("BMI= "+(double)((Integer.valueOf(s))/(Double.valueOf(ed.getText().toString())*Double.valueOf(ed.getText().toString())))+"");
            }
        });
    }
    public void goToSecond2(View u) {


        Intent intent = new Intent(Main2Activity.this, MainActivity.class);

        startActivity(intent);
    }
}
