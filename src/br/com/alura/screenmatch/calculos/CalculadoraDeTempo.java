package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.model.Titulo;

public class CalculadoraDeTempo {

private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void inclui(Filme filme){ // Impota uma classe especifica, nao funciona se eu usar series
//        tempoTotal += filme.getDuracaoMinutos();
//    }

    public void inclui(Titulo titulo){ // importa a super class, funciona tanto serie quanto filme
        tempoTotal += titulo.getDuracaoMinutos();
    }
}
