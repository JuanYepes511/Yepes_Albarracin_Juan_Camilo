package com.example.yepes_albarracin_juan_camilo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity2 extends AppCompatActivity {

    private TextView tvTituloDetalle, tvPrecioDetalle;
    private ImageView ivImagenPrincipal;

        @SuppressLint("MissingInflatedId")
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle2);
        setTitle(getString(R.string.txt_listado));
        tvTituloDetalle = findViewById(R.id.tv_titulo_detalle);
        tvPrecioDetalle = findViewById(R.id.tv_precio_detalle);
        ivImagenPrincipal = findViewById(R.id.iv_imagen_detalle);
        Producto miPRoductoAtrapado = (Producto) getIntent().getSerializableExtra("Producto");
        tvTituloDetalle.setText(miPRoductoAtrapado.getNombre());
        tvPrecioDetalle.setText(miPRoductoAtrapado.getPrecio().toString());
        Picasso.get()
                .load(miPRoductoAtrapado.getUrlImagen())
                .error(R.drawable.ic_launcher_background)
                .into(ivImagenPrincipal);
    }
}