package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class FuncionariosActivity extends AppCompatActivity {

    private Button btnFuncionarios; // Asegúrate de que este botón está definido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);

        btnFuncionarios = findViewById(R.id.btn_funcionarios); // Asegúrate de que el ID sea correcto

        btnFuncionarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAListaFuncionarios(); // Llama al método para navegar a la siguiente actividad
            }
        });
    }

    private void irAListaFuncionarios() {
        Intent intent = new Intent(FuncionariosActivity.this, ListaFuncionariosActivity.class);
        startActivity(intent); // Navega a la actividad de lista de funcionarios
    }
}
