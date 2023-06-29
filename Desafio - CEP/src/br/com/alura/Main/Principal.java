package br.com.alura.Main;

import br.com.alura.Model.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        String tipoArquivo = "json";

        System.out.println("Digite seu cep:\nOu digite 'Não sei meu CEP'");
        String cep = sc.nextLine();

        Endereco endereco = null;
        if (cep.equalsIgnoreCase("nao sei meu cep")) {
            BuscaPorRua buscaPorRua = new BuscaPorRua();
            endereco = buscaPorRua.buscaCep();
        }

        if (endereco != null) {
            System.out.println(endereco);

            System.out.println("Fim da execução");
            System.exit(0);
        }

        System.out.println("Digite o número da sua casa.");
        String numero = sc.nextLine();

        System.out.println("Digite o complemento: ");
        String complemento = sc.nextLine();

        cep = cep.replaceAll("[^\\d]", "");
        if (cep.length() > 8) {
            System.out.println("Cep invalido, por favor informe um cep com no máximo 8 caracteres");
        }

        endereco = buscaCep(cep, tipoArquivo, numero, complemento);

        System.out.println(endereco.toString());

        System.out.println("Fim da execução");

    }


    public static Endereco buscaCep(String cep, String tipoArquivo, String numero, String complemento) throws IOException, InterruptedException {

        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/" + tipoArquivo + "/"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Endereco endereco = gson.fromJson(json, Endereco.class);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);

        return endereco;

    }

}
