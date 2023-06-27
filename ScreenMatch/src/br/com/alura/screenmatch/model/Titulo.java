package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.enums.Alternativa;
import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

import java.text.Format;

public class Titulo implements Comparable<Titulo>{

    private String tipo;
    private final String nome;
    private final int anoLancamento;
    private int duracaoMinutos;
    private Alternativa incuidoNoPlano;
    private double somaAvaliacoes;
    private int totalAvaliacoes;


    public Titulo(String tipo, String nome, int anoLancamento){
        this.tipo = tipo;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOMDb tituloOmdb) {
        this.nome = tituloOmdb.title();
        if (tituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Impossível converter ano\n"+
                    "Tamanho do ano é maior que 4 caracteres");
        }
        this.anoLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracaoMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, 2));
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

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
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

    @Override
    public String toString() {
        return String.format( "%s: %s (%s), Duração: %s \n", this.tipo, this.nome, this.anoLancamento, this.duracaoMinutos);
    }
}
