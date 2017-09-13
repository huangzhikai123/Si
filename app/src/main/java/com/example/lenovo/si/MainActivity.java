package com.example.lenovo.si;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String Huang = "huang.txt";
        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try {
                    FileOutputStream fileOutputStream=openFileOutput(Huang,MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);
                    EditText et = (EditText)findViewById(R.id.editText1);
                    String Et = et.getText().toString();
                    try {
                        out.write(Et.getBytes(StandardCharsets.UTF_8));
                    }
                    finally {
                        if(out!=null)
                            out.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Button button1 =(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    int Buff=8192;
                    BufferedReader in=null;
                    FileInputStream fileInputStream=openFileInput(Huang);
                    in=new BufferedReader(new InputStreamReader(fileInputStream,"UTF-8"),Buff);
                    int c;
                    StringBuilder stringBuilder=new StringBuilder("");
                    try{
                        while((c=in.read())!=-1){
                            stringBuilder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
                    }
                    finally {
                        if(in!=null)
                            in.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });



    }
    }
