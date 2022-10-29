package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
            soma, subtracao, multiplicacao, divisao, igual, ponto, limpar;

    private TextView resultado, expressao;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        Objects.requireNonNull(getSupportActionBar()).hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        igual.setOnClickListener(this);
        ponto.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText("");
                expressao.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()) {
                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                resultado.setText(" ");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expression = new ExpressionBuilder(expressao.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if (result == (double) longResult) {
                        resultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        resultado.setText((CharSequence) String.valueOf(result));
                    }
                }catch (Exception e){

                }
            }
        });
    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.numero_0);
        numeroUm = findViewById(R.id.numero_1);
        numeroDois = findViewById(R.id.numero_2);
        numeroTres = findViewById(R.id.numero_3);
        numeroQuatro = findViewById(R.id.numero_4);
        numeroCinco = findViewById(R.id.numero_5);
        numeroSeis = findViewById(R.id.numero_6);
        numeroSete = findViewById(R.id.numero_7);
        numeroOito = findViewById(R.id.numero_8);
        numeroNove = findViewById(R.id.numero_9);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.adicao);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        limpar = findViewById(R.id.limpar);
        resultado = findViewById(R.id.txt_resultado);
        expressao = findViewById(R.id.txt_expressao);
        backspace = findViewById(R.id.backspace);

    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_Dados) {
        if (resultado.getText().equals("")) {
            expressao.setText(" ");
        }

        if (limpar_Dados) {
            resultado.setText(" ");
            expressao.append(string);
        } else {
            expressao.append(resultado.getText());
            expressao.append(string+" ");
            resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.numero_0:
                AcrescentarUmaExpressao("0", true);
                break;

            case R.id.numero_1:
                AcrescentarUmaExpressao("1", true);
                break;

            case R.id.numero_2:
                AcrescentarUmaExpressao("2", true);
                break;

            case R.id.numero_3:
                AcrescentarUmaExpressao("3", true);
                break;

            case R.id.numero_4:
                AcrescentarUmaExpressao("4", true);
                break;

            case R.id.numero_5:
                AcrescentarUmaExpressao("5", true);
                break;

            case R.id.numero_6:
                AcrescentarUmaExpressao("6", true);
                break;

            case R.id.numero_7:
                AcrescentarUmaExpressao("7", true);
                break;

            case R.id.numero_8:
                AcrescentarUmaExpressao("8", true);
                break;

            case R.id.numero_9:
                AcrescentarUmaExpressao("9", true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".", true);
                break;

            case R.id.adicao:
                AcrescentarUmaExpressao("+", false);
                break;

            case R.id.subtracao:
                AcrescentarUmaExpressao("-", false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;

            case R.id.divisao:
                AcrescentarUmaExpressao("/", false);
                break;
        }
    }
}