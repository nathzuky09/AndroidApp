package com.example.login;

import android.content.Intent; // Importar Intent para navegar a otras actividades
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText edContraseña;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.et_usuario);
        edContraseña = findViewById(R.id.ed_contraseña);
        btnIngresar = findViewById(R.id.btn_ingresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = etUsuario.getText().toString();
        String password = edContraseña.getText().toString();

        LoginRequest loginRequest = new LoginRequest(username, password);
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<LoginResponse> call = apiService.login(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String mensaje = response.body().getMensaje();

                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso: " + mensaje, Toast.LENGTH_SHORT).show();

                    // Iniciar la actividad FuncionariosActivity después del inicio de sesión exitoso
                    Intent intent = new Intent(MainActivity.this, FuncionariosActivity.class);
                    startActivity(intent); // Navegar a la nueva actividad

                } else {
                    String error = response.body() != null ? response.body().getError() : "Error desconocido";
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    Log.e("LoginError", "Código de respuesta: " + response.code() + ", Cuerpo: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
