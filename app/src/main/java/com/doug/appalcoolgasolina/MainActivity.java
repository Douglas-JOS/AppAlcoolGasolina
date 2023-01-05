package com.doug.appalcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoAlcool, precoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAcool);
        precoGasolina = findViewById(R.id.precoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        //Recuperar valores digitados
        String precoAlc = precoAlcool.getText().toString();
        String precoGas = precoGasolina.getText().toString();
        //Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlc, precoGas);
        if (camposValidados){
            //Convertendo string para números
            Double valorAlcool = Double.parseDouble(precoAlc);
            Double valorgasolina = Double.parseDouble(precoGas);
            Double resultado = valorAlcool/valorgasolina;
            if(resultado >= 0.7){
                textResultado.setText("Melhor utilizar gasolina!");
            }else{
                textResultado.setText("Melhor utilizar álcool!");
            }
        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }
}