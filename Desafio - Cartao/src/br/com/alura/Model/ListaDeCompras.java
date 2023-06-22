package br.com.alura.Model;

public class ListaDeCompras implements Comparable<ListaDeCompras>{

    private String descricao;
    private double valor;


    public ListaDeCompras(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Compra: descrição = " + descricao +
                " valor = " + valor;
    }

    @Override
    public int compareTo(ListaDeCompras outraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.getValor()));
    }
}
