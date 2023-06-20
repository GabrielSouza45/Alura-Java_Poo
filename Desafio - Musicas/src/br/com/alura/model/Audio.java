package br.com.alura.model;

public class Audio {

    private String titulo;
    private int totalReproducoes;
    private int curtidas;
    private double classificacao;
    private int totalClassificacoes;

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
        System.out.println("Classificação: " + this.classificacao);
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

    public double getClassificacao() {
        return classificacao;
    }

}
