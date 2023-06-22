package Main.Java;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.enums.Alternativa;
import br.com.alura.screenmatch.enums.Ativa;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.Titulo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        Filme gog = new Filme("Guardiões da Galáxia Vol.3", 2023);
        gog.setIncuidoNoPlano(Alternativa.SIM);
        gog.setDuracaoMinutos(149);
        gog.setDiretor("James Gunn");

        gog.exibeFichaTecnica();
        gog.avalia(10);
        gog.avalia(8.9);
        gog.avalia(9.5);
        gog.pegaMedia();

        System.out.println();

        Filme milesMorales = new Filme("Spider-Man: Across the Spider Verse", 2023);
        milesMorales.setIncuidoNoPlano(Alternativa.SIM);
        milesMorales.setDuracaoMinutos(136);
        milesMorales.setDiretor("Joaquim Dos Santos, Justin K. Thompson, Kemp Powers");

        milesMorales.exibeFichaTecnica();
        milesMorales.avalia(10);
        milesMorales.avalia(10);
        milesMorales.avalia(9.9);
        milesMorales.pegaMedia();

        System.out.println();

        Filme spaceChimps = new Filme("Space Chimps - Micos no Espaço", 2008);
        spaceChimps.setIncuidoNoPlano(Alternativa.SIM);
        spaceChimps.setDuracaoMinutos(81);
        spaceChimps.setDiretor("Kirk DeMicco");

        spaceChimps.exibeFichaTecnica();
        spaceChimps.avalia(10);
        spaceChimps.avalia(7.9);
        spaceChimps.avalia(8.5);
        spaceChimps.pegaMedia();

        System.out.println();

        Serie arcane = new Serie("Arcane", 2021);
        arcane.setDuracaoMinutos(45);
        arcane.setDuracaoPorEpisodio(45);
        arcane.setIncuidoNoPlano(Alternativa.SIM);
        arcane.setTemporadas(1);
        arcane.setEpisodiosPorTemporada(9);
        arcane.setAtiva(Ativa.FINALIZADA);
        arcane.exibeFichaTecnica();

        arcane.avalia(10);
        arcane.avalia(10);
        arcane.avalia(9.5);
        arcane.pegaMedia();

        System.out.println();

        Serie house = new Serie("Dr. House", 2004);
        house.setDuracaoPorEpisodio(43);
        house.setIncuidoNoPlano(Alternativa.SIM);
        house.setTemporadas(8);
        house.setEpisodiosPorTemporada(23);
        house.setAtiva(Ativa.FINALIZADA);
        house.exibeFichaTecnica();

        house.avalia(10);
        house.avalia(8);
        house.avalia(9.5);
        house.pegaMedia();

        CalculadoraDeTempo calc = new CalculadoraDeTempo();

        calc.inclui(gog);
        calc.inclui(milesMorales);
        calc.inclui(arcane);
        System.out.println(calc.getTempoTotal());


        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        filtroRecomendacao.filtra(milesMorales);

        Episodio episodio = new Episodio();
        episodio.setNome("pilot");
        episodio.setNumero(1);
        episodio.setTotalVizualizacoes(400);
        episodio.setSerie(house);

        filtroRecomendacao.filtra(episodio);

        System.out.println();

        List<Filme> listaFilmes = new ArrayList<>();
        listaFilmes.add(gog);
        listaFilmes.add(milesMorales);
        listaFilmes.add(spaceChimps);
        System.out.println("Tamanho da lista: " + listaFilmes.size());
        System.out.println("Primeiro filme: " + listaFilmes.get(0).getNome());
        System.out.println(listaFilmes.get(0).toString());



    }


}
