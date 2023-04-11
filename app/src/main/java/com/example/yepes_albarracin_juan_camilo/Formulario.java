package com.example.yepes_albarracin_juan_camilo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {
    private EditText etNombreProductoAdd;
    private EditText etPrecioProductoAdd;
    private EditText etUrlAdd;
    private Button btnAddProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
    }
}