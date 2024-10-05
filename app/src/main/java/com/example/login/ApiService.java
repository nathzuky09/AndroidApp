package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("http://10.0.2.2:8000/api/login/") // Endpoint para inicio de sesión
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("http://10.0.2.2:8000/api/funcionarios/") // Endpoint para obtener la lista de funcionarios
    Call<List<Funcionario>> obtenerFuncionarios(); // Devuelve una lista de objetos Funcionario
}
