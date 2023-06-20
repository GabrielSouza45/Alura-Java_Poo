package br.com.alura.model;

import br.com.alura.interfaces.Classificacoes;

public class Musica extends Audio implements Classificacoes {

    private String album;
    private String cantor;
    private String genero;

    public Musica() {
    }

    @Override
    public void exibirFichaTecnica() {
        super.exibirFichaTecnica();
        System.out.println("Cantor: " + this.cantor);
        System.out.println("Album: " + this.album);
        System.out.println("Gênero: " + this.genero);
    }

    @Override
    public int getClassificacao() {
        if ((this.getCurtidas() * this.getTotalReproducoes()) / 2 > 8){
            return 10;
        }else if ((this.getCurtidas() * this.getTotalReproducoes()) / 2 > 5){
            return 5;
        }else {
            return 3;
        }
    }


    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
