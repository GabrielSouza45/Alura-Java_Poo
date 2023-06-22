package Main.Java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        String apiKey = "67855098";

        System.out.println("Digite o nome do filme: ");
        String busca = sc.next();


        String result = busca.replace(" ", "");
        System.out.println(result);
//        String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey="+apiKey;
//
//        String buscar = "Spider+man+across+the+spider+verse";
//
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(endereco))
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());
    }

}
