package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText address=(EditText)findViewById(R.id.Address);
        final EditText subject=(EditText)findViewById(R.id.Subject);
        final EditText content=(EditText)findViewById(R.id.content);

        ((Button)findViewById(R.id.send)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("plain/text");
                String strAddressBuf[] = {address.getText().toString()};
                String strSubject = subject.getText().toString();
                String strContent = content.getText().toString();
                it.putExtra(Intent.EXTRA_EMAIL, strAddressBuf);
                it.putExtra(Intent.EXTRA_SUBJECT, strSubject);
                it.putExtra(Intent.EXTRA_TEXT, strContent);
                try
                {
                    startActivity(it);
                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        ((Button)findViewById(R.id.clear)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = findViewById(R.id.email);
                EditText address = findViewById(R.id.Address);
                    EditText subject = findViewById(R.id.Subject);
                EditText content = findViewById(R.id.content);
                email.setText("");
                address.setText("");
                subject.setText("");
                content.setText("");
            }

        });
        }
}