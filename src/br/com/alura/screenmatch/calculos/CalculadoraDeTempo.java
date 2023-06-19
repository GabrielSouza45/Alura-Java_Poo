package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.model.Filme;

public class CalculadoraDeTempo {

private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Filme filme){
        tempoTotal += filme.getDuracaoMinutos();
    }
}
