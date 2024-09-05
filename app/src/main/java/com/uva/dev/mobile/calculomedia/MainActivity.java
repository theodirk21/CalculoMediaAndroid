package com.uva.dev.mobile.calculomedia;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editAva1, editAva2, editA2, editA3;
    Button buttonCalcular;
    TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editAva1 = findViewById(R.id.editAva1);
        editAva2 = findViewById(R.id.editAva2);
        editA2 = findViewById(R.id.editA2);
        editA3 = findViewById(R.id.editA3);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textResultado = findViewById(R.id.textResultado);

        buttonCalcular = findViewById(R.id.buttonCalcular);
        textResultado = findViewById(R.id.textResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ava1 = Double.parseDouble(editAva1.getText().toString());
                double ava2 = Double.parseDouble(editAva2.getText().toString());
                double a2 = Double.parseDouble(editA2.getText().toString());
                String a3Text = editA3.getText().toString();

                double a1 = calcularMedia(ava1, ava2);
                double mediaFinal = calcularMediaFinal(a1, a2, a3Text);

                String resultado = mediaFinal >= 6 ? "Passou" : "Reprovou";
                textResultado.setText("A média final é: " + mediaFinal + " - " + resultado);
            }
        });
    }

    private double calcularMedia(double nota1, double nota2) {
        return (nota1 + nota2) / 2;
    }

    private double calcularMediaFinal(double a1, double a2, String a3Text) {
        double a3 = a3Text.isEmpty() ? a2 : Double.parseDouble(a3Text);
        if (!a3Text.isEmpty() && a3 > a2) {
            a2 = a3;
        }
        double mediaFinal = ((a1 * 4) + (a2 * 6)) / 10;
        return mediaFinal;
    }
}
