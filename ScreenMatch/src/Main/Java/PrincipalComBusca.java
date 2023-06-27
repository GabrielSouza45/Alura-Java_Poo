package Main.Java;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.model.Titulo;
import br.com.alura.screenmatch.model.TituloOMDb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        String busca = sc.nextLine();

        busca = busca.replaceAll("\s", "+");

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + apiKey;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOMDb tituloOmdb = gson.fromJson(json, TituloOMDb.class);
            System.out.println("TituloOmdb: \n" + tituloOmdb);

            System.out.println();

            Titulo titulo = new Titulo(tituloOmdb);
            System.out.println("Titulo: \n" + titulo);

        } catch (NumberFormatException ex) {
            System.out.println("Ocorreu um erro");
            System.out.println(ex.getMessage());
        } catch (IllegalArgumentException ex){
            System.out.println("Erro de argumento");
            System.out.println(ex.getMessage());
        } catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMensagem());
        }


    }

}
