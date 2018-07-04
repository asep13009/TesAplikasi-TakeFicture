package com.example.asep.tesaplikasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tes = findViewById(R.id.button);
        tes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.helo);
                Toast.makeText(getApplicationContext(),textView.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Button lanjut1 = findViewById(R.id.button2);
        lanjut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.helo);
                Intent intent= new Intent(getApplicationContext(),TesActivity.class);
                intent.putExtra("helo",textView.getText());
                startActivity(intent);

            }
        });
    }
}
