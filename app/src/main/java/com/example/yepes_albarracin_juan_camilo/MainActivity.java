package com.example.yepes_albarracin_juan_camilo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto>listaPrincipalProductos;
    private RecyclerView rvListadoProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();
        rvListadoProductos = findViewById(R.id.rv_Listado_Productos);
        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado((listaPrincipalProductos));
        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void cargarDatos(){
        Producto producto1 = new Producto();
        producto1.setNombre("ComputadorHP");
        producto1.setPrecio(8000000.0);
        producto1.setUrlImagen("");

        listaPrincipalProductos=new ArrayList<>();

        Producto producto2 = new Producto("Teclado", 250000.0, "");
        Producto producto3 = new Producto("Mouse",50000.0,"");
        listaPrincipalProductos.add(producto1);
        listaPrincipalProductos.add(producto2);
        listaPrincipalProductos.add(producto3);
    }
}