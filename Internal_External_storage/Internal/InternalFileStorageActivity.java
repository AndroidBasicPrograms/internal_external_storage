package com.example.jayhind.lecture_app.Internal_External_storage.Internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jayhind.lecture_app.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalFileStorageActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    Context context;
    String count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_file_storage);
        context=this;
        btn=findViewById(R.id.btncounter);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        writedata();
    }

    private void writedata() {
        int c = 0;
        if(count==null) {
            count = "0";
        }
        else
        {
            count=readdata();
            c=Integer.parseInt(count);
            c++;
        }
        try {
            FileOutputStream fos=openFileOutput("Internal",MODE_PRIVATE);
            fos.write(String.valueOf(c).getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String readdata() {
        String S="0";
        try {
            FileInputStream fis=openFileInput("Internal");
            byte[] bts=new byte[fis.available()];
            fis.read(bts);
            S=new String(bts);
            Toast.makeText(context, S, Toast.LENGTH_SHORT).show();
            fis.close();
            return S;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return S;
    }
}
