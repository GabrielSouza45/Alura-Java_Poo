package br.com.alura.model;

public class Musica extends Audio{

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
