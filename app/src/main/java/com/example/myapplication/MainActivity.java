package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText note1;
    EditText note2;
    EditText note3;
    EditText note4;
    TextView moyResult;
    TextView mentsResult;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        note4 = findViewById(R.id.note4);

        button = findViewById(R.id.btn);
        moyResult = findViewById(R.id.moyResult);
        mentsResult = findViewById(R.id.mentsResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculeMoy();
            }
        });
    }

    private void calculeMoy() {
        String noteStr1 = note1.getText().toString();
        String noteStr2 = note2.getText().toString();
        String noteStr3 = note3.getText().toString();
        String noteStr4 = note4.getText().toString();

        float noteFlt1 = Float.parseFloat(noteStr1);
        float noteFlt2 = Float.parseFloat(noteStr2);
        float noteFlt3 = Float.parseFloat(noteStr3);
        float noteFlt4 = Float.parseFloat(noteStr4);

        if (TextUtils.isEmpty(noteStr1) || TextUtils.isEmpty(noteStr2) || TextUtils.isEmpty(noteStr3) || TextUtils.isEmpty(noteStr4)) {
           Toast.makeText(this,"Please enter the note!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (noteFlt1>20 || noteFlt2>20 || noteFlt3>20 || noteFlt4>20) {
            Toast.makeText(this,"The note is > 20!",Toast.LENGTH_SHORT).show();
            return;
        }
        float moy = (noteFlt1 + noteFlt2 + noteFlt3 + noteFlt4) /4;
        String mention = mentions(moy);
        moyResult.setText("Your Moyen is: "+moy);
        mentsResult.setText(mention);

    }

    private String mentions(float moy){
        if (moy >= 16){return "Excellent";}
        else if (moy >= 14 && moy < 16) {
            return "Très bien";
        } else if (moy >= 12 && moy < 14) {
            return "Bien";
        }
         else if (moy >= 10 && moy < 12) {
            return "Assez bien";
        }
         else {
             return "Échec";
        }
    }
}