package br.edu.unis.alunos.projeto_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtMassa;
    EditText edtAltura;
    Button btnCalculo;
    TextView txtResultadoImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarComponentes();
        configuracaoBotao();
    }

    protected void carregarComponentes() {
        edtMassa = findViewById(R.id.edtMassa);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalculo = findViewById(R.id.btnCalculo);
        txtResultadoImc = findViewById(R.id.txtResultadoImc);
    }

    protected void configuracaoBotao() {
        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultadoFinal = calculoImc();
                exibiResultado(resultadoFinal);
                limpaCampos();
            }
        });
    }

    protected String calculoImc() {
        double massa = Double.parseDouble(edtMassa.getText().toString());
        double altura = Double.parseDouble(edtAltura.getText().toString());

        double imc = massa / (altura * altura);

        String resultadoFinal = "Calculo do seu IMC";

        if (imc < 16) {
            resultadoFinal = "Magreza grave";
        } else if (imc >= 16 && imc <= 16.99) {
            resultadoFinal = "Magreza moderada";
        } else if (imc >= 17 && imc <= 18.49 ) {
            resultadoFinal = "Magreza leve";
        } else if (imc >= 18.5 && imc <= 24.99) {
            resultadoFinal = "Saudavel";
        } else if (imc >= 25 && imc <= 29.99) {
            resultadoFinal = "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.99) {
            resultadoFinal = "Obesidade Grau I";
        } else if (imc >= 35 && imc < 39.99) {
            resultadoFinal = "Obesidade Grau II";
        } else if (imc >= 40) {
            resultadoFinal = "Obesidade Grau III (mórbida)";
        }

        return resultadoFinal;
    }

    protected void exibiResultado(String resultadoFinal) { txtResultadoImc.setText(resultadoFinal); }

    protected void limpaCampos() {
        edtMassa.setText("");
        edtMassa.requestFocus();

        edtAltura.setText("");
        edtAltura.requestFocus();
    }
}