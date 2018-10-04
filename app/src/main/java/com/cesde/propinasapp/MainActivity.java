package com.cesde.propinasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etValorCuenta;
    ImageButton btnHappy;
    ImageButton btnNeutral;
    ImageButton btnSad;
    TextView tvPorPropina;
    TextView tvValPropina;
    TextView tvSubtotal;
    TextView tvPropina;
    TextView tvTotal;
    Button btnLimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se referencian los controles de la vista
        etValorCuenta = findViewById(R.id.etValorCuenta);
        btnHappy = findViewById(R.id.btnHappy);
        btnNeutral = findViewById(R.id.btnNeutral);
        btnSad = findViewById(R.id.btnSad);
        tvPorPropina = findViewById(R.id.tvPorPropina);
        tvValPropina = findViewById(R.id.tvValPropina);
        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvPropina = findViewById(R.id.tvPropina);
        tvTotal = findViewById(R.id.tvTotal);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        //Se asignan los eventos a los botones
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularTotales(v);
            }
        });

        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularTotales(v);
            }
        });

        btnNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularTotales(v);
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etValorCuenta.setText("");
                tvPorPropina.setText("0%");
                tvValPropina.setText("$0");
                tvSubtotal.setText("$0");
                tvPropina.setText("$0");
                tvTotal.setText("$0");
            }
        });
    }

    private void CalcularTotales(View v){

        if(etValorCuenta.getText().toString().equals("")){
            Toast.makeText(this,"Debe ingresar el valor de la factura", Toast.LENGTH_SHORT).show();
            return;
        }
        double valorFactura = Double.parseDouble(etValorCuenta.getText().toString());
        double porcentaje = 0;
        String porcentajeTexto = "0%";

        switch (v.getId()){
            case R.id.btnHappy:
                porcentaje = 0.2;
                porcentajeTexto = "20%";
                break;
            case R.id.btnNeutral:
                porcentaje = 0.1;
                porcentajeTexto = "10%";
                break;
        }

        double propina, total;
        propina = porcentaje * valorFactura;
        total = valorFactura + propina;

        tvValPropina.setText(propina+"");
        tvPorPropina.setText(porcentajeTexto);
        tvSubtotal.setText(valorFactura+"");
        tvPropina.setText(propina+"");
        tvTotal.setText(total+"");
    }
}
