package com.example.cacau2.pratica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class calculadoraSimples extends AppCompatActivity implements OnClickListener {

    EditText value1,value2;
    Button opPlus, opMinus, opDivide, opMulti;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_simples);
        this.setTitle("Calculadora Simples"); //Muda nome da barra superior da activity

        //Initialize variables
        opPlus = (Button) findViewById(R.id.opPlus);
        opMinus = (Button) findViewById(R.id.opMinus);
        opDivide = (Button) findViewById(R.id.opDivide);
        opMulti = (Button) findViewById(R.id.opMulti);

        result = (TextView) findViewById(R.id.resultadoTxt);

        value1 = (EditText) findViewById(R.id.valor1Txt);
        value2 = (EditText) findViewById(R.id.valor2Txt);

        //Set listeners from buttons
        opPlus.setOnClickListener(this);
        opMinus.setOnClickListener(this);
        opDivide.setOnClickListener(this);
        opMulti.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Integer v1 = Integer.valueOf(value1.getText().toString());
        Integer v2 = Integer.valueOf(value2.getText().toString());
        Integer res = 0;
        switch (view.getId()) {
            //case will be determine by Button's Id (R.id.blablabla)
            case R.id.opPlus:
                res = v1 + v2;
                break;
            case R.id.opMinus:
                res = v1 - v2;
                break;
            case R.id.opMulti:
                res = v1 * v2;
                break;
            case R.id.opDivide:
                res = v1 / v2;
                break;
        }
        String valorFinal = res.toString();
        result.setText(valorFinal);
    }

}