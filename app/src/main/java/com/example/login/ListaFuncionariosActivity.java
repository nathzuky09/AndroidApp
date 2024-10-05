package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List; // Asegúrate de importar List
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFuncionariosActivity extends AppCompatActivity {

    private TextView tvFuncionarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_funcionarios);

        tvFuncionarios = findViewById(R.id.tv_funcionarios);

        // Llama a la API para obtener los funcionarios
        obtenerFuncionarios();
    }

    private void obtenerFuncionarios() {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<List<Funcionario>> call = apiService.obtenerFuncionarios();

        call.enqueue(new Callback<List<Funcionario>>() {
            @Override
            public void onResponse(Call<List<Funcionario>> call, Response<List<Funcionario>> response) {
                Log.d("API Response", "Código de respuesta: " + response.code());
                if (response.isSuccessful() && response.body() != null) {
                    StringBuilder funcionarios = new StringBuilder();
                    for (Funcionario f : response.body()) {
                        funcionarios.append("Nombre: ").append(f.getNombre()).append("\n")
                                .append("Apellido: ").append(f.getApellido()).append("\n")
                                .append("Documento: ").append(f.getDocumento()).append("\n")
                                .append("Teléfono: ").append(f.getNumeroTelefono()).append("\n")
                                .append("Email: ").append(f.getEmail()).append("\n")
                                .append("Cargo: ").append(f.getCargo()).append("\n")
                                .append("Aprobación ID: ").append(f.getAprobacionId()).append("\n")
                                .append("Fecha Aprobación: ").append(f.getFechaAprobacion()).append("\n")
                                .append("--------------------------\n"); // Separador para mejor legibilidad
                    }
                    tvFuncionarios.setText(funcionarios.toString());
                } else {
                    Log.e("API Error", "Error: " + response.message());
                    tvFuncionarios.setText("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Funcionario>> call, Throwable t) {
                Log.e("API Failure", "Error al cargar funcionarios: " + t.getMessage());
                tvFuncionarios.setText("Error al cargar funcionarios: " + t.getMessage());
            }
        });
    }
}
