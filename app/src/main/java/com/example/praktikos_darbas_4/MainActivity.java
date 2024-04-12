package com.example.praktikos_darbas_4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button downloadButton;
    private ListView currecyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currecyList = findViewById(R.id.currencyListView);
        downloadButton = findViewById(R.id.getDataButton);
        downloadButton.setOnClickListener(v -> DownloadData());
    }

    private void DownloadData(){
        try {
            new DataLoader(this, currecyList).execute();
            Toast.makeText(this, getString(R.string.successMessage), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, getString(R.string.failureMessage), Toast.LENGTH_SHORT).show();
        }
    }
}