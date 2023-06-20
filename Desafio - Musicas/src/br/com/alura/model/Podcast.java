package br.com.alura.model;

import br.com.alura.interfaces.Classificacoes;

public class Podcast extends Audio implements Classificacoes {

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

    @Override
    public int getClassificacao() {
        if (this.getCurtidas() > 500){
            return 10;
        }else {
            return 8;
        }
    }
}
