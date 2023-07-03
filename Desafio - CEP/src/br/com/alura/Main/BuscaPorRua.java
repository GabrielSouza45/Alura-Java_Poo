package br.com.alura.Main;

import br.com.alura.Model.Endereco;
import br.com.alura.Model.EnderecoArray;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaPorRua {
    private String cidade;
    private String estado;
    private String rua;
    private String formato = "json";

    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaPorRua buscaPorRua = new BuscaPorRua();
        buscaPorRua.buscaCep();
    }

    public EnderecoArray[] buscaCep() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua cidade: ");
        this.cidade = sc.nextLine();

        System.out.println("Digite sua Rua:");
        this.rua = sc.nextLine();

        System.out.println("Digite seu Estado: (2 letras)");
        this.estado = sc.nextLine();

        this.cidade = Normalizer.normalize(cidade, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "%20");
        this.rua = Normalizer.normalize(rua, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "%20");
        this.estado = Normalizer.normalize(estado, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(
                        "https://viacep.com.br/ws/%s/%s/%s/%s/",
                        this.estado,
                        this.cidade,
                        this.rua,
                        this.formato)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        Gson gson = new Gson();
        String json = response.body();
//        System.out.println(json);

        EnderecoArray[] enderecos = gson.fromJson(json, EnderecoArray[].class);
//        if (enderecos.length >= 1){
//            System.out.println(enderecos[0]);
//        }
//        for (EnderecoArray end : enderecos){
//            System.out.println(end.toString());
//        }

        return enderecos;
    }
}
