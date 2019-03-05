package com.example.myapplicationearth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView2;
    EditText editText;
String Planets []={"Mercury","Mars","Venus","Earth","Uranus","Neptune","Saturn","Jupiter"};
double Mass []={0.0553,0.107,	0.815	,1	,14.5,	17.1,95.2	,318};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_BMI){
            Intent in=new Intent(MainActivity.this,Main2Activity.class);
            in.putExtra("Weight",editText.getText().toString());
            startActivity(in);
        }

        return super.onOptionsItemSelected(item);
    }
    public void calculate(View v){
        editText=( EditText)findViewById(R.id.editText);
        if(editText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Please enter your weight",Toast.LENGTH_LONG).show();
            return;
        }

        textView2=(TextView)findViewById(R.id.textView2);
        for(int i=0;i<Mass.length;i++){
            textView2.setText(textView2.getText().toString()+Planets[i]+" = "+(Integer.valueOf(editText.getText().toString())*Mass[i])+"\n");
        }
    }
}
