package br.com.alura.model;

public class Audio {

    private String titulo;
    private double duracao;
    private int totalReproducoes;
    private int curtidas;
    private double classificacao;
    private int totalClassificacoes;

    public Audio(){}

    public void curtir(int curtidas){
        this.curtidas += curtidas;
    }

    public void reproduzir(int reproducoes){
        this.totalReproducoes += reproducoes;
    }

    public void classificar()


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public double getClassificacao() {
        return classificacao;
    }

}
