package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edNome, edAltura, edPeso;
    TextView msngIMC;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNome=findViewById(R.id.edNome);
        edAltura=findViewById(R.id.edAltura);
        edPeso=findViewById(R.id.edPeso);
        msngIMC =findViewById(R.id.msngIMC);

            }
        public void calculaIMC(View v){
            Intent i = new Intent(this, imcActivity.class);
            String nome = edNome.getText().toString();
            Double peso = Double.parseDouble(edPeso.getText().toString());
            Double altura = Double.parseDouble(edAltura.getText().toString());


            i.putExtra("nome",nome);
            i.putExtra("peso",peso);
            i.putExtra("altura",altura);

            startActivity(i);

    }
    }