package br.com.alura.model;

import br.com.alura.interfaces.Classificacoes;

public class Audio {
    Avaliacao avaliacao = new Avaliacao();
    private String titulo;
    private int totalReproducoes;
    private int curtidas;
    private int classificacao;
    private String totalClassificacoes = avaliacao.inclui(this);

    public Audio(){

    }

    public void curtir(){
        this.curtidas ++;
    }
    public void reproduzir(){
        this.totalReproducoes ++;
    }
    public void exibirFichaTecnica(){

        System.out.println("Título: " + this.titulo);
        System.out.println("Reproduções: " + this.totalReproducoes);
        System.out.println("Curtidas: " + this.curtidas);
        System.out.println("Classificação: " + this.totalClassificacoes);
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

}
