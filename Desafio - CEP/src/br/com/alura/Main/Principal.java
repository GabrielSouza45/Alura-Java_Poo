package br.com.alura.Main;

import br.com.alura.Model.Endereco;
import br.com.alura.Model.EnderecoArray;
import br.com.alura.Model.GerarArquivos;
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

        System.out.println("Digite o número da sua casa: ");
        String numero = sc.nextLine();

        System.out.println("Digite o complemento: ");
        String complemento = sc.nextLine();

        System.out.println("Digite seu cep:\nOu digite 'Não sei meu CEP'");
        String cep = sc.nextLine();

        EnderecoArray[] enderecoArrays = null;
        Endereco endereco = null;
        if (cep.equalsIgnoreCase("nao sei meu cep")) {
            BuscaPorRua buscaPorRua = new BuscaPorRua();
            enderecoArrays = buscaPorRua.buscaCep();
        }

        if (enderecoArrays != null) {

            int length = enderecoArrays.length;
            if (length > 1){
                endereco = voltaEndereco(enderecoArrays);
            }
            else {
                endereco = enderecoArrays[0];
            }

            endereco.setNumero(numero);
            endereco.setComplemento(complemento);

            System.out.println(endereco);

            GerarArquivos gerarArquivos = new GerarArquivos();
            gerarArquivos.salvarJson(endereco);

            System.out.println("Fim da execução");
            System.exit(0);
        }

        cep = cep.replaceAll("[^\\d]", "");
        if (cep.length() > 8) {
            System.out.println("Cep invalido, por favor informe um cep com no máximo 8 caracteres");
        }

        endereco = buscaCep(cep, tipoArquivo, numero, complemento);

        System.out.println(endereco.toString());

        GerarArquivos gerarArquivos = new GerarArquivos();
        gerarArquivos.salvarJson(endereco);

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
//        System.out.println(json);

        Endereco endereco = gson.fromJson(json, Endereco.class);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);

        return endereco;

    }

    public static Endereco voltaEndereco(EnderecoArray[] enderecoArrays){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor selecione seu endereço digitando o número dele: ");
        int n =1;
        for (Endereco endereco : enderecoArrays){
            System.out.println(
                    n + ": \n" + endereco.toString()
            );
            n++;
        }
        int escolha = sc.nextInt();
        if (escolha > enderecoArrays.length){
            System.out.println("Endereço para este número não existe.");

            System.out.println("Fim da execução.");
            System.exit(0);
        }
        return enderecoArrays[escolha -1];

    }

}
