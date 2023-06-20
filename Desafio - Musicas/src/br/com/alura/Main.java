package br.com.alura;

import br.com.alura.model.Audio;
import br.com.alura.model.Favoritos;
import br.com.alura.model.Musica;
import br.com.alura.model.Podcast;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        pularLinha();

        //criar
        Musica musica = new Musica();
        musica.setGenero("Rock");
        musica.setAlbum("Vermillion");
        musica.setTitulo("Vermillion pt.1");
        musica.setCantor("Slipknot");

        Musica musica2 = new Musica();
        musica2.setGenero("Rock");
        musica2.setAlbum("Vermillion");
        musica2.setTitulo("Vermillion pt.2");
        musica2.setCantor("Slipknot");

        Podcast podcast = new Podcast();
        podcast.setTitulo("Teste 01");
        podcast.setApresentador("Tester 01");
        podcast.setDescricao("Teste 01 do primeiro podcast");

        Podcast podcast2 = new Podcast();
        podcast2.setTitulo("Teste 02");
        podcast2.setApresentador("Tester 02");
        podcast2.setDescricao("Teste 02 do segundo podcast");

        //curtir
        for (int i = 0; i < 5; i++){
            musica.curtir();
        }
        for (int i = 0; i < 15; i++){
            musica2.curtir();
        }
        for (int i = 0; i < 3; i++){
            podcast.curtir();
        }
        for (int i = 0; i < 8; i++){
            podcast2.curtir();
        }

        //reproduzir
        for (int i = 0; i < 2655; i++){
            musica.reproduzir();
        }
        for (int i = 0; i < 879; i++){
            musica2.reproduzir();
        }
        for (int i = 0; i < 849; i++){
            podcast.reproduzir();
        }
        for (int i = 0; i < 587; i++){
            podcast2.reproduzir();
        }

        //exibir
        musica.exibirFichaTecnica();
        pularLinha();
        musica2.exibirFichaTecnica();
        pularLinha();
        podcast.exibirFichaTecnica();
        pularLinha();
        podcast2.exibirFichaTecnica();
        pularLinha();

        //adcionar favoritos
        Favoritos rock = new Favoritos();
        rock.setNomePlaylist("Rock & Roll");
        rock.adicionar(musica);
        rock.adicionar(musica2);

        Favoritos podcastList = new Favoritos();
        podcastList.setNomePlaylist("Podcasssttt");
        podcastList.adicionar(podcast);
        podcastList.adicionar(podcast2);

        Favoritos mistura = new Favoritos();
        mistura.setNomePlaylist("Minsstuuuraaa");
        mistura.adicionar(musica);
        mistura.adicionar(podcast);

        //exibir favoritos
        rock.exibirPlaylist();
        pularLinha();
        podcastList.exibirPlaylist();
        pularLinha();
        mistura.exibirPlaylist();
        pularLinha();

        //adcionar favoritos lista
        Audio[] audios = {musica, podcast, musica2, podcast2};
        Favoritos lista = new Favoritos();
        lista.setNomePlaylist("Adiciona em lista");
        lista.adicionar(audios);

        //exibir favoritos lista
        lista.exibirPlaylist();
        pularLinha();
    }

    public static void pularLinha(){
        System.out.println();
    }
}
