package br.com.alura.screenmatch.model;

public class Filme extends Titulo{

    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void exibeFichaTecnica() {
        super.exibeFichaTecnica();
        System.out.println("Diretor do filme: " + this.diretor);
    }
}
