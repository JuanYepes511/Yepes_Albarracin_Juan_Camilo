package com.example.yepes_albarracin_juan_camilo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public void goToSecondActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private EditText NombreUsuario, etLoginPassword;
    private SharedPreferences misPreferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        referenciar();
        misPreferencias = getSharedPreferences("tienda_app",MODE_PRIVATE);
        //Check login
        if(misPreferencias.getBoolean("logueado", false)==true){
            Intent login = new Intent(this, MainActivity.class);
            startActivity(login);
            finish();
        }
    }
    private void referenciar(){
        NombreUsuario = findViewById(R.id.NombreUsuario);
        etLoginPassword = findViewById((R.id.etLoginPassword));
    }
    public void clickIniciarSesion(View view){
        String PASS = "12345";
        String USER = "juan";
        String passUser = etLoginPassword.getText().toString() ;
        String userUser = NombreUsuario.getText().toString();
        if (PASS.equals(passUser)&&USER.equals(userUser)){
            SharedPreferences.Editor myEditor = misPreferencias.edit();
            myEditor.putBoolean("logueado", true);
            myEditor.apply();
            Intent login = new Intent(this, MainActivity.class);
            startActivity(login);
            finish();
        }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }

    }
}