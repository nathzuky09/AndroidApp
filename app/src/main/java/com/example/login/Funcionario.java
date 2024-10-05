package com.example.login;

public class Funcionario {
    private String nombre;
    private String apellido;
    private String documento;
    private String numeroTelefono;
    private String email;
    private String cargo;
    private String aprobacion_id; // Asegúrate de que el nombre coincide con el JSON
    private String fecha_aprobacion; // Si es una fecha, usa el tipo adecuado

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    public String getAprobacionId() {
        return aprobacion_id;
    }

    public String getFechaAprobacion() {
        return fecha_aprobacion;
    }
}
