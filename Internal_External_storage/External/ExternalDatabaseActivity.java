package com.example.jayhind.lecture_app.Internal_External_storage.External;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jayhind.lecture_app.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalDatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    Context context;
    EditText etnm;
    Button btnins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_database);
        context=this;
        etnm=findViewById(R.id.etname);
        btnins=findViewById(R.id.btnins);
        btnins.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        File file=Environment.getExternalStorageDirectory();
        file=new File(file,"AndroidDatabase");
        if(!file.exists())
        {
            if(file.mkdir())
                Toast.makeText(this, "Directory Created", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Directory Create Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            File f1 = new File(file, "DatabaseFile.txt");
            try {
                FileOutputStream fos = new FileOutputStream(f1, true);
                String data = String.valueOf(etnm.getText());
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                fos.write(data.getBytes());
                Toast.makeText(context, "Data inseted", Toast.LENGTH_SHORT).show();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
