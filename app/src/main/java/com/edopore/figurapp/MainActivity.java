package com.edopore.figurapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eValor, eValor2;
    RadioButton rCuadrado, rCubo, rCirculo, rTriangulo;
    String Arista, Altura;
    Button bCalcular;
    TextView Area, Perimetro, Volumen;
    TextView Texto1, Texto2, tVolumen;
    int fop = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eValor = findViewById(R.id.eValor);
        eValor2 = findViewById(R.id.eValor2);
        bCalcular = findViewById(R.id.bCalcular);
        rCuadrado = findViewById(R.id.rCuadro);
        rCubo = findViewById(R.id.rCubo);
        rCirculo = findViewById(R.id.rCirculo);
        rTriangulo = findViewById(R.id.rTriangulo);
        Area = findViewById(R.id.eArea);
        Perimetro = findViewById(R.id.ePerimetro);
        Volumen = findViewById(R.id.eVolumen);
        Texto1 = findViewById(R.id.tText1);
        Texto2 = findViewById(R.id.tText2);
        tVolumen = findViewById(R.id.tVolumen);

        Texto1.setText(R.string.arista);
        Texto2.setVisibility(View.INVISIBLE);
        Volumen.setVisibility(View.INVISIBLE);
        tVolumen.setVisibility(View.INVISIBLE);
        eValor2.setVisibility(View.INVISIBLE);
        eValor.setText("");
        eValor2.setText("1");
        Area.setText("");
        Perimetro.setText("");
        Volumen.setText("");
    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.rCuadro:
                fop = 1;
                Texto1.setText(R.string.arista);
                Texto2.setVisibility(View.INVISIBLE);
                Volumen.setVisibility(View.INVISIBLE);
                tVolumen.setVisibility(View.INVISIBLE);
                eValor2.setVisibility(View.INVISIBLE);
                eValor2.setText("1");
                eValor.setText("");
                Area.setText("");
                Perimetro.setText("");
                Volumen.setText("");
                break;
            case R.id.rCirculo:
                fop = 2;
                Texto1.setText(R.string.radio);
                Texto2.setVisibility(View.INVISIBLE);
                Volumen.setVisibility(View.INVISIBLE);
                tVolumen.setVisibility(View.INVISIBLE);
                eValor2.setVisibility(View.INVISIBLE);
                eValor2.setText("1");
                eValor.setText("");
                Area.setText("");
                Perimetro.setText("");
                Volumen.setText("");
                break;
            case R.id.rTriangulo:
                fop = 3;
                Texto1.setText(R.string.base);
                Texto2.setVisibility(View.VISIBLE);
                Volumen.setVisibility(View.INVISIBLE);
                tVolumen.setVisibility(View.INVISIBLE);
                eValor2.setVisibility(View.VISIBLE);
                eValor2.setText("");
                eValor.setText("");
                Area.setText("");
                Perimetro.setText("");
                Volumen.setText("");
                break;
            case R.id.rCubo:
                fop = 4;
                Texto1.setText(R.string.arista);
                Texto2.setVisibility(View.INVISIBLE);
                Volumen.setVisibility(View.VISIBLE);
                tVolumen.setVisibility(View.VISIBLE);
                eValor2.setVisibility(View.INVISIBLE);
                eValor2.setText("1");
                eValor.setText("");
                Area.setText("");
                Perimetro.setText("");
                Volumen.setText("");
                break;
        }
    }

    public void OnButtonClicked(View view) {
        Arista = eValor.getText().toString();
        Altura = eValor2.getText().toString();

        if ((eValor.getText().toString().isEmpty()) || (eValor2.getText().toString().isEmpty()) || (eValor.getText().toString().isEmpty() && eValor2.getText().toString().isEmpty())) {
            Toast.makeText(this, "Por Favor ingresa un valor", Toast.LENGTH_SHORT).show();
        } else if (!eValor.getText().toString().isEmpty() || !eValor2.getText().toString().isEmpty()) {
            float num1, num2, area, volumen, perimetro;
            int a, b;
            area = volumen = perimetro = 0;
            a = 2;
            b = 3;
            num1 = Float.parseFloat(Arista);
            num2 = Float.parseFloat(Altura);

            switch (fop) {
                case 1:
                    area = num1 * num1;
                    perimetro = 4 * num1;
                    volumen = 0;
                    if (area - Math.floor(area) == 0) {
                        Area.setText(String.valueOf((int) area));
                    } else {
                        Area.setText(String.valueOf(area));
                    }
                    if (perimetro - Math.floor(perimetro) == 0) {
                        Perimetro.setText(String.valueOf((int) perimetro));
                    } else {
                        Perimetro.setText(String.valueOf(perimetro));
                    }
                    break;
                case 2:
                    area = (float) Math.PI * (float) Math.pow(num1, a);
                    perimetro = 2 * (float) Math.PI * num1;
                    volumen = 0;
                    if (area - Math.floor(area) == 0) {
                        Area.setText(String.valueOf((int) area));
                    } else {
                        Area.setText(String.valueOf(area));
                    }
                    if (perimetro - Math.floor(perimetro) == 0) {
                        Perimetro.setText(String.valueOf((int) perimetro));
                    } else {
                        Perimetro.setText(String.valueOf(perimetro));
                    }
                    break;
                case 3:
                    area = (num1 * num2) / 2;
                    float hip = (float) Math.sqrt((float) Math.pow(num1, a) + (float) Math.pow(num2, a));
                    perimetro = hip + num1 + num2;
                    volumen = 0;
                    if (area - Math.floor(area) == 0) {
                        Area.setText(String.valueOf((int) area));
                    } else {
                        Area.setText(String.valueOf(area));
                    }
                    if (perimetro - Math.floor(perimetro) == 0) {
                        Perimetro.setText(String.valueOf((int) perimetro));
                    } else {
                        Perimetro.setText(String.valueOf(perimetro));
                    }
                    break;
                case 4:
                    area = 6 * (float) Math.pow(num1, a);
                    perimetro = 12 * (float) Math.pow(num1, a);
                    volumen = (float) Math.pow(num1, b);
                    if (area - Math.floor(area) == 0) {
                        Area.setText(String.valueOf((int) area));
                    } else {
                        Area.setText(String.valueOf(area));
                    }
                    if (perimetro - Math.floor(perimetro) == 0) {
                        Perimetro.setText(String.valueOf((int) perimetro));
                    } else {
                        Perimetro.setText(String.valueOf(perimetro));
                    }
                    if (volumen - Math.floor(volumen) == 0) {
                        Volumen.setText(String.valueOf((int) volumen));
                    } else {
                        Volumen.setText(String.valueOf(volumen));
                    }
                    break;
            }

        }
    }
}
