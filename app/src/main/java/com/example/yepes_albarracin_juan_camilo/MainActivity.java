package com.example.yepes_albarracin_juan_camilo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto>listaPrincipalProductos;
    private RecyclerView rvListadoProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();
        setTitle(getString(R.string.txt_listado));
        rvListadoProductos = findViewById(R.id.rv_Listado_Productos);
        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado((listaPrincipalProductos));
        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.onItemClickListener() {
            @Override
            public void onItemClick(Producto miProducto, int posicion) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity2.class);
                intent.putExtra("producto", miProducto);
                startActivity(intent);
            }

            @Override
            public void onItemBtnEliminarClick(Producto miProducto, int posicion) {
                listaPrincipalProductos.remove(posicion);
                miAdaptador.setListadoInformacion(listaPrincipalProductos);
            }

        });
        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void cargarDatos(){
        Producto producto1 = new Producto();
        producto1.setNombre("ComputadorHP");
        producto1.setPrecio(8000000.0);
        producto1.setUrlImagen("https://www.lenovo.com/medias/wmd00000468.png?context=bWFzdGVyfHJvb3R8MjE0MDA3fGltYWdlL3BuZ3xoMWMvaGZmLzE0Mjc4MDA3NDU1Nzc0LnBuZ3xlZTk5MTljMTNhYjJhMTBlMGJiZjgxNjY3MzVjYjc0ZDFkYzI2NDM5MzZiZDgyYWJjY2NhY2Q4NGYyZmQzZWIy");

        listaPrincipalProductos=new ArrayList<>();

        Producto producto2 = new Producto("Teclado", 250000.0, "https://www.computerevolution.com.co/wp-content/uploads/teclado-logitech-league-of-legends-pro.jpg");
        Producto producto3 = new Producto("Mouse",50000.0,"https://www.ktronix.com/medias/097855149435-001-750Wx750H?context=bWFzdGVyfGltYWdlc3wxMjIxMDZ8aW1hZ2UvanBlZ3xpbWFnZXMvaGNjL2g2ZC8xMDczMDA1NTkyNTc5MC5qcGd8MjcwNDhmNDg3MmIwY2QxMWZlYjI0M2ExMzkyYjg3MmJmMGIwMmZlMWExYmNkNDJjNTI0MDZmZTg3NzBiNDJhNw");
        listaPrincipalProductos.add(producto1);
        listaPrincipalProductos.add(producto2);
        listaPrincipalProductos.add(producto3);
    }
}