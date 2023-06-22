package Main.Java;

import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme gog = new Filme("Guardiões da Galáxia Vol.3", 2023);
        gog.avalia(9);
        Filme milesMorales = new Filme("Spider-Man: Across the Spider Verse", 2023);
        milesMorales.avalia(10);
        Filme spaceChimps = new Filme("Space Chimps - Micos no Espaço", 2008);
        spaceChimps.avalia(8);
        Serie arcane = new Serie("Arcane", 2021);
        arcane.avalia(10);
        Serie house = new Serie("Dr. House", 2004);
        house.avalia(9.9);


        List<Titulo> lista = new ArrayList<>();
        lista.add(gog);
        lista.add(milesMorales);
        lista.add(spaceChimps);
        lista.add(arcane);
        lista.add(house);
        for (Titulo titulo : lista){
            if (titulo instanceof Filme filme){
                //Filme filme = (Filme) titulo;
                System.out.println(filme.getClassificacao());
            }
        }

        ArrayList<String> buscaArtista = new ArrayList<>();
        buscaArtista.add("Adam Sandler");
        buscaArtista.add("Jinx");
        buscaArtista.add("Sam");
        buscaArtista.add("Chris Pratt");
        System.out.println(buscaArtista);

        Collections.sort(buscaArtista);
        System.out.println(buscaArtista);


        Collections.sort(lista);
        System.out.println(lista.toString());

        lista.sort(Comparator.comparing(Titulo::getNome));
        System.out.println("Filtro por nome: \n" + lista.toString());

        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println("Filtro por data: \n" + lista.toString());

        lista.sort(Comparator.comparing(Titulo::getTipo));
        System.out.println("Filtro por Tipo: \n" + lista.toString());
    }
}
