package br.com.alura.screenmatch.model;

//Classe Abstrata Record : cria automaticamente construtores e atributos do tipo FINAL que estão dentro do parâmetro
public record TituloOMDb(String title, String year, String runtime) {
}
