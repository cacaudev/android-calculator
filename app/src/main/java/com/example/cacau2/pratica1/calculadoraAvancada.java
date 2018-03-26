package com.example.cacau2.pratica1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class calculadoraAvancada extends AppCompatActivity implements OnClickListener {

    Button opPlus, opMinus, opDivide, opMulti, opClear, opEqual, opDot, opBackspace;
    Button n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;
    TextView calculateField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_avancada);
        this.setTitle("Calculadora Avancada"); //Change activity name bar

        //Initialize variables and listeners

        // Operators
        opPlus = (Button) findViewById(R.id.opPlus); opPlus.setOnClickListener(this);
        opMinus = (Button) findViewById(R.id.opMinus); opMinus.setOnClickListener(this);
        opDivide = (Button) findViewById(R.id.opDivide); opDivide.setOnClickListener(this);
        opMulti = (Button) findViewById(R.id.opMulti); opMulti.setOnClickListener(this);
        opClear = (Button) findViewById(R.id.opClear); opClear.setOnClickListener(this);
        opEqual = (Button) findViewById(R.id.opEqual); opEqual.setOnClickListener(this);
        opDot = (Button) findViewById(R.id.opDot); opDot.setOnClickListener(this);
        opBackspace = (Button) findViewById(R.id.opBackspace); opBackspace.setOnClickListener(this);

        // Numbers
        n0 = (Button) findViewById(R.id.btn_zero); n0.setOnClickListener(this);
        n1 = (Button) findViewById(R.id.btn_one); n1.setOnClickListener(this);
        n2 = (Button) findViewById(R.id.btn_two); n2.setOnClickListener(this);
        n3 = (Button) findViewById(R.id.btn_three); n3.setOnClickListener(this);
        n4 = (Button) findViewById(R.id.btn_four); n4.setOnClickListener(this);
        n5 = (Button) findViewById(R.id.btn_five); n5.setOnClickListener(this);
        n6 = (Button) findViewById(R.id.btn_six); n6.setOnClickListener(this);
        n7 = (Button) findViewById(R.id.btn_seven); n7.setOnClickListener(this);
        n8 = (Button) findViewById(R.id.btn_eight); n8.setOnClickListener(this);
        n9 = (Button) findViewById(R.id.btn_nine); n9.setOnClickListener(this);

        calculateField = (TextView) findViewById(R.id.values_to_calculate);
    }

    @Override
    public void onClick(View view) {
        String valuesTyped = calculateField.getText().toString();

        switch (view.getId()) {
            //case will be determine by Button's Id (R.id.blablabla)
            case R.id.opPlus:
                valuesTyped += "+";
                break;
            case R.id.opMinus:
                valuesTyped += "-";
                break;
            case R.id.opMulti:
                valuesTyped += "*";
                break;
            case R.id.opDivide:
                valuesTyped += "/";
                break;
            case R.id.opClear:
                valuesTyped = " ";
                break;
            case R.id.opDot:
                valuesTyped += ".";
                break;
            case R.id.opBackspace:
                if(!valuesTyped.isEmpty()) {
                    valuesTyped = valuesTyped.substring(0,valuesTyped.length()-1);
                }
                break;
            case R.id.btn_zero:
                valuesTyped += "0";
                break;
            case R.id.btn_one:
                valuesTyped += "1";
                break;
            case R.id.btn_two:
                valuesTyped += "2";
                break;
            case R.id.btn_three:
                valuesTyped += "3";
                break;
            case R.id.btn_four:
                valuesTyped += "4";
                break;
            case R.id.btn_five:
                valuesTyped += "5";
                break;
            case R.id.btn_six:
                valuesTyped += "6";
                break;
            case R.id.btn_seven:
                valuesTyped += "7";
                break;
            case R.id.btn_eight:
                valuesTyped += "8";
                break;
            case R.id.btn_nine:
                valuesTyped += "9";
                break;

            case R.id.opEqual:
                String[] individualValues;
                Boolean soma = false, subtracao = false, divisao = false, multiplicacao = false;
                Float value;

                if(!valuesTyped.isEmpty()) {

                    if(valuesTyped.indexOf("+") != -1)
                        soma = true;
                    if(valuesTyped.indexOf("-") != -1)
                        subtracao = true;
                    if(valuesTyped.indexOf("/") != -1)
                        divisao = true;
                    if(valuesTyped.indexOf("*") != -1)
                        multiplicacao = true;

                    // Regular Expression to match '+' '-' '*' '/'
                    // check https://regexr.com for more examples
                    String delimiters = "[\\+\\-\\*\\/]";

                    individualValues = valuesTyped.split(delimiters);
                    Float finalResult = 0f;

                    // If the values typed actually have numbers
                    if(individualValues.length != 0){

                        // Debug numbers divided (Log)
                        /*for(String i : individualValues) {
                            value = Float.valueOf(i);
                            Log.v("CATEGORIA", "Valor: " + value);
                        }*/

                        if(soma) finalResult =  Float.valueOf(individualValues[0]) +  Float.valueOf(individualValues[1]);
                        else if(subtracao) finalResult = Float.valueOf(individualValues[0]) -  Float.valueOf(individualValues[1]);
                        else if(divisao) {
                            if(Float.valueOf(individualValues[1]) == 0)
                                Toast.makeText(getApplicationContext(),"Não é possível dividir por 0",Toast.LENGTH_SHORT).show();
                            else
                                finalResult = Float.valueOf(individualValues[0]) /  Float.valueOf(individualValues[1]);
                        }
                        else if(multiplicacao) finalResult = Float.valueOf(individualValues[0]) *  Float.valueOf(individualValues[1]);

                        Log.v("CATEGORIA", "Valor final: " + finalResult);

                        //if result is integer (so won't print a float number)
                        if(finalResult == Math.round(finalResult)) {
                            Integer aux = Math.round(finalResult);
                            valuesTyped = aux.toString();
                            Log.v("CATEGORIA", "Valor final integer: " + valuesTyped);
                        }
                        else { //if result is float
                            valuesTyped = finalResult.toString();
                            Log.v("CATEGORIA", "Valor final float: " + valuesTyped);
                        }

                        soma = false; subtracao=false; multiplicacao=false; divisao=false;
                    }

                }
                break;


            default:
                break;
        }

        calculateField.setText(valuesTyped);
    }
}
