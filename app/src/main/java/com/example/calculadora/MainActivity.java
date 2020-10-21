package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText resultado = null;
    EditText numero1 = null;
    EditText numero2 = null;
    public void sumar(View view){
        resultado = findViewById(R.id.editResultado);
        numero1 = findViewById(R.id.editNumero1);
        numero2 = findViewById(R.id.editNumero2);
        if (numero1.getText().length()!=0&&numero2.getText().length()!=0)
        {
            resultado.setTextSize(50);
            resultado.setText(String.valueOf(Integer.valueOf(numero1.getText().toString())+
                    Integer.valueOf(numero2.getText().toString())));
        }else{
            resultado.setTextSize(18);
            resultado.setText("ERROR: Hay campos vacíos.");
        }
        ocultarTeclado(view);
    }
    public void restar(View view){
        resultado = findViewById(R.id.editResultado);
        numero1 = findViewById(R.id.editNumero1);
        numero2 = findViewById(R.id.editNumero2);
        if (numero1.getText().length()!=0&&numero2.getText().length()!=0)
        {
            resultado.setTextSize(50);
            resultado.setText(String.valueOf(Integer.valueOf(numero1.getText().toString())-
                    Integer.valueOf(numero2.getText().toString())));
        }else{
            resultado.setTextSize(18);
            resultado.setText("ERROR: Hay campos vacíos.");
        }
        ocultarTeclado(view);
    }
    public void multiplicar(View view){
        resultado = findViewById(R.id.editResultado);
        numero1 = findViewById(R.id.editNumero1);
        numero2 = findViewById(R.id.editNumero2);
        if (numero1.getText().length()!=0&&numero2.getText().length()!=0)
        {
            resultado.setTextSize(50);
            resultado.setText(String.valueOf(Integer.valueOf(numero1.getText().toString())*
                    Integer.valueOf(numero2.getText().toString())));
        }else{
            resultado.setTextSize(18);
            resultado.setText("ERROR: Hay campos vacíos.");
        }
        ocultarTeclado(view);
    }

    public void dividir(View view){
        resultado = findViewById(R.id.editResultado);
        numero1 = findViewById(R.id.editNumero1);
        numero2 = findViewById(R.id.editNumero2);
        if (numero1.getText().length()!=0&&numero2.getText().length()!=0&& Integer.valueOf(numero2.getText().toString())!=0){
            resultado.setTextSize(50);
            resultado.setText(String.valueOf((float)(Math.round(Float.valueOf(numero1.getText().toString())/
                    Float.valueOf(numero2.getText().toString())*100)/100.00)));
        }else if(Integer.valueOf(numero2.getText().toString())!=0){
            resultado.setTextSize(18);
            resultado.setText("ERROR: Hay campos vacíos.");
        }else{
            resultado.setTextSize(18);
            resultado.setText("ERROR: No puedes dividir por 0");
        }
        ocultarTeclado(view);
    }
    public void operar(View view){
        switch(view.getId()){
            case R.id.btnSumar:
                sumar(view);
                break;
            case R.id.btnRestar:
                restar(view);
                break;
            case R.id.btnMultiplicar:
                multiplicar(view);
                break;
            case R.id.btnDividir:
                dividir(view);
                break;
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ocultarTeclado(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}