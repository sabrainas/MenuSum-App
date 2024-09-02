package com.example.menusum;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtConsumo;
    private EditText edtCouvert;
    private EditText edtDividir;
    private Button btnCalcular;
    private TextView txtTaxaServico;
    private TextView txtTotal;
    private TextView txtValorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtDividir = findViewById(R.id.edtDividir);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtTaxaServico = findViewById(R.id.txtTaxaServico);
        txtTotal = findViewById(R.id.txtTotal);
        txtValorPessoa = findViewById(R.id.txtValorPessoa);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                double consumoTotal = Double.parseDouble(edtConsumo.getText().toString());
                double couvert = Double.parseDouble(edtCouvert.getText().toString());
                int dividirConta = Integer.parseInt(edtDividir.getText().toString());

                double subtotal = (consumoTotal + couvert);

                double taxaServico = subtotal * 0.10;
                double total = subtotal + taxaServico;

                double totalPessoa = total / dividirConta;

                txtTaxaServico.setText(String.format("%.2f", taxaServico));
                txtTotal.setText(String.format("%.2f", total));
                txtValorPessoa.setText(String.format("%.2f", totalPessoa));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view) {


    }
}