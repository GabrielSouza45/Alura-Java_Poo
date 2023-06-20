package br.com.alura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Favoritos{

    private String nomePlaylist;
    private List<Audio> favorito = new ArrayList<>();

    public void adicionar(Audio audio){
        Scanner sc = new Scanner(System.in);

        if (this.favorito.contains(audio)){
            System.out.println("Esta música já existe na playlist, deseja adicionar novamente? 'S' ou 'N'");
            String escolha = sc.nextLine();
            if (escolha.equals("S")){
                this.favorito.add(audio);
            }
        } else {
            this.favorito.add(audio);
        }


    }

    public void adicionar(Audio[] audio){
        for (Audio aud : audio){
            this.favorito.add(aud);
        }
    }

    public void exibirPlaylist(){
        if (this.favorito.size() < 1){
            System.out.println("Playlist vazia.");
        }
        else {
            System.out.println(this.nomePlaylist);
            for (Audio audio : this.favorito){
                audio.exibirFichaTecnica();
                System.out.println();
            }
            System.out.println("========================//========================");
        }

    }

    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }
}
