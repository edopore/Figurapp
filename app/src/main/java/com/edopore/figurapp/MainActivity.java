package com.edopore.figurapp;
//revisar el por que no funciona el radio button cuando se pone a cambiar los edittext
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eValor,eValor2;
    RadioButton rCuadrado, rCubo, rCirculo, rTriangulo;
    String Arista, Altura;
    Button bCalcular;
    TextView Area, Perimetro, Volumen;
    TextView Texto1, Texto2;
    int fop;
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
        Texto1 =  findViewById(R.id.tText1);
        Texto2 =  findViewById(R.id.tText2);

        Texto1.setText(R.string.arista);
        Texto2.setVisibility(View.INVISIBLE);
        eValor2.setVisibility(View.INVISIBLE);
        eValor2.setText("1");
    }

    public void onRadioButtonClicked(View view) {
        int id=view.getId();
        switch (id){
            case R.id.rCuadro:
                fop=1;
                Texto1.setText(R.string.arista);
            break;
            case R.id.rCirculo:
                fop=2;
                Texto1.setText(R.string.radio);
            break;
            case R.id.rTriangulo:
                fop=3;
                Texto2.setVisibility(View.VISIBLE);
                Texto1.setText(R.string.base);
                eValor2.setVisibility(View.VISIBLE);
                eValor2.setText("");
            break;
            case R.id.rCubo:
                fop=4;
            break;
        }
    }

    public void OnButtonClicked(View view) {
        Arista = eValor.getText().toString();
        Altura = eValor2.getText().toString();

        if((eValor.getText().toString().isEmpty())||(eValor2.getText().toString().isEmpty())||(eValor.getText().toString().isEmpty() && eValor2.getText().toString().isEmpty())){
            Toast.makeText(this,"Por Favor ingresa un valor",Toast.LENGTH_SHORT).show();
        }
        else if(!eValor.getText().toString().isEmpty()||!eValor2.getText().toString().isEmpty()){

            float num1,num2,area,volumen,perimetro;
            int a,b;
            area=volumen=perimetro=0;
            a=2;
            b=3;
            num1 = Float.parseFloat(Arista);
            num2 = Float.parseFloat(Altura);

            switch (fop){
                case 1:
                    area = num1*num1;
                    perimetro = 4*num1;
                    volumen = 0;
                    break;
                case 2:
                    area = (float)Math.PI*(float)Math.pow(num1,a);
                    perimetro = 2*(float)Math.PI*num1;
                    volumen = 0;
                    break;
                case 3:
                    area = (num1*num2)/2;
                    perimetro = 0;
                    volumen = 0;
                    break;
                case 4:
                    area = 6*(float)Math.pow(num1,a);
                    perimetro = 12*(float)Math.pow(num1,a);
                    volumen = (float)Math.pow(num1,b);
                    break;
            }
            Area.setText(String.valueOf(area));
            Perimetro.setText(String.valueOf(perimetro));
            Volumen.setText(String.valueOf(volumen));
        }
    }
}
