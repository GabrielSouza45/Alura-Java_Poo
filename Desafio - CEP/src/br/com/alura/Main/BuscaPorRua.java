package br.com.alura.Main;

import br.com.alura.Model.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.Normalizer;
import java.util.List;
import java.util.Scanner;

public class BuscaPorRua {
    public Endereco buscaCep() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua cidade: ");
        String cidade = sc.nextLine();

        System.out.println("Digite sua Rua:");
        String rua = sc.nextLine();

        System.out.println("Digite seu Estado: (2 letras)");
        String estado = sc.nextLine();

        String formato = "json";

        cidade = Normalizer.normalize(cidade, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "%20");
        rua = Normalizer.normalize(rua, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "%20");
        estado = Normalizer.normalize(estado, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(
                        "https://viacep.com.br/ws/%s/%s/%s/%s/",
                        estado,
                        cidade,
                        rua,
                        formato)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);

        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(json, Endereco.class);

        return endereco;
    }
}
