package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.enums.Ativa;

public class Serie extends Titulo{

    private int temporadas;
    private int episodiosPorTemporada;
    private Ativa ativa;
    private int duracaoPorEpisodio;

    public Serie(String nome, int anoLancamento){
        super("Série", nome, anoLancamento);
    }

    @Override
    public void exibeFichaTecnica() {
        super.exibeFichaTecnica();
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println("Episodios por temporada: " + this.episodiosPorTemporada);
        System.out.println("Status: " + this.ativa);
        System.out.println("Duração média por episodio: " + getDuracaoMinutos());
    }

    @Override
    public int getDuracaoMinutos() {
        return temporadas * episodiosPorTemporada * duracaoPorEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public Ativa getAtiva() {
        return ativa;
    }

    public void setAtiva(Ativa ativa) {
        this.ativa = ativa;
    }

    public int getDuracaoPorEpisodio() {
        return duracaoPorEpisodio;
    }

    public void setDuracaoPorEpisodio(int duracaoPorEpisodio) {
        this.duracaoPorEpisodio = duracaoPorEpisodio;
    }
}
