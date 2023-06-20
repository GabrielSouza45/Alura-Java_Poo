package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.enums.Alternativa;

public class Titulo {

    private String tipo;
    private String nome;
    private int anoLancamento;
    private int duracaoMinutos;
    private Alternativa incuidoNoPlano;
    private double somaAvaliacoes;
    private int totalAvaliacoes;

    public Titulo(){

    }


    public void exibeFichaTecnica(){
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Duração: " + this.duracaoMinutos + " minutos");
        System.out.println("Ano de lançamento: " + this.anoLancamento);
        System.out.println("Incluído no plano? " + this.incuidoNoPlano);
    }

    public void avalia(double nota){
        this.somaAvaliacoes += nota;
        this.totalAvaliacoes++;
    }

    public double pegaMedia(){
        double avalia = this.somaAvaliacoes / this.totalAvaliacoes;
        System.out.println("Avaliação: " + avalia);
        return avalia;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Alternativa getIncuidoNoPlano() {
        return incuidoNoPlano;
    }

    public void setIncuidoNoPlano(Alternativa incuidoNoPlano) {
        this.incuidoNoPlano = incuidoNoPlano;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
