package com.example.atv7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resposta;
    private EditText n1;
    private EditText n2;
    private Button sortear;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        n1 = findViewById(R.id.valor1);
        n2 = findViewById(R.id.valor2);
        sortear = findViewById(R.id.button);
        resposta = findViewById(R.id.txtresult);

        sortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int valor1 = Integer.parseInt(String.valueOf(n1.getText()));
                int valor2 = Integer.parseInt(String.valueOf(n2.getText()));
                if(valor1 <= valor2) {
                    int resut = valor2 - valor1 + 1;

                    int numero1 = (int) (Math.random()  *resut) + valor1;


                    resposta.setText(numero1);
                }else {
                    resposta.setText("Resultado invalido");
                }
            }
        });

    }
}