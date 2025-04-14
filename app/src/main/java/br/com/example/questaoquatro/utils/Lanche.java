package br.com.example.questaoquatro.utils;

public class Lanche {
    private String nome;
    private int valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Lanche(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }

}
