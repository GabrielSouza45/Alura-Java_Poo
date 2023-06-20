package br.com.alura.model;

public class Podcast extends Audio{

    private String apresentador;
    private String descricao;


    public Podcast(){}

    @Override
    public void exibirFichaTecnica() {
        super.exibirFichaTecnica();
        System.out.println("Apresentador: " + this.apresentador);
        System.out.println("Descrição: " + this.descricao);
    }

    public String getApresentador() {
        return apresentador;
    }

    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
