package Main.Java;

import br.com.alura.screenmatch.enums.Alternativa;
import br.com.alura.screenmatch.enums.Ativa;
import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.Titulo;

public class Principal {
    public static void main(String[] args) {

        Filme gog = new Filme();
        gog.setTipo("Filme");
        gog.setNome("Guardiões da Galáxia Vol.3");
        gog.setAnoLancamento(2023);
        gog.setIncuidoNoPlano(Alternativa.SIM);
        gog.setDuracaoMinutos(149);
        gog.setDiretor("James Gunn");

        gog.exibeFichaTecnica();
        gog.avalia(10);
        gog.avalia(8.9);
        gog.avalia(9.5);
        gog.pegaMedia();

        System.out.println();

        Serie arcane = new Serie();
        arcane.setTipo("Série");
        arcane.setNome("Arcane");
        arcane.setAnoLancamento(2021);
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

        Serie house = new Serie();
        house.setTipo("Série");
        house.setNome("Dr. House");
        house.setAnoLancamento(2004);
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



    }

}
