package com.raulburigo;

public class Pessoa {
    
    private String nome;
    private String perfil;
    private Integer matricula;

    public Pessoa() {
    }

    public Pessoa(String nome, String perfil, Integer matricula) {
        this.nome = nome;
        this.perfil = perfil;
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return this.perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            " perfil='" + getPerfil() + "'" +
            ", matricula='" + getMatricula() + "'" +
            "}";
    }


}
