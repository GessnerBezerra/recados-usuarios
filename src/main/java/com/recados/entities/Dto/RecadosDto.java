package com.recados.entities.Dto;

import com.recados.entities.Recados;
import com.recados.entities.Usuario;

import java.util.Random;

public class RecadosDto {


    private long id;
    private String recados;

    private String usuarioNome;

    Random aux= new Random();

    int num = aux.nextInt(500);

    public RecadosDto() {
        this.id = num;
    }

    public RecadosDto(long id, String recados, String usuarioNome) {
        this.id = num;
        this.recados = recados;
        this.usuarioNome = usuarioNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecados() {
        return recados;
    }

    public void setRecados(String recados) {
        this.recados = recados;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }
}
