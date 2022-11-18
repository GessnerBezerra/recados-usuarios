package com.recados.entities;

import java.util.Objects;

public class Recados {
//    private Usuario usuario;
    private Long id;
    private String recados;
    private String usuario;

    public Recados() {
    }
    public Recados(String usuario) {
        this.usuario = usuario;
    }

    public Recados(Long id, String recados, String usuario) {
        this.id = id;
        this.recados = recados;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recados)) return false;
        Recados recados1 = (Recados) o;
        return Objects.equals(id, recados1.id) && Objects.equals(recados, recados1.recados) && Objects.equals(usuario, recados1.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recados, usuario);
    }
}
