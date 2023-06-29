package Main.Java;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.model.Titulo;
import br.com.alura.screenmatch.model.TituloOMDb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String apiKey = "67855098";
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        //Utiliza a biblioteca Gjon para manipular o arquivo Json,
        // define a politica de nomenclatura do meu arquivo Json para automaticamente mesclar o Json PascalCase com minha classe camelCase
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite o nome do filme: ");
            busca = sc.nextLine().replaceAll(" ", "+");

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + apiKey;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                //Pega a resposta do servidor e adiciona num arquivo String
                String json = response.body();
                System.out.println(json);

                //Pega os dados do arquivo Json para alimentar minha classe Record
                TituloOMDb tituloOmdb = gson.fromJson(json, TituloOMDb.class);
                System.out.println("TituloOmdb: \n" + tituloOmdb);

                System.out.println();

                //Instancia a classe Titulo passando a classe record no parâmetro para criar um titulo a partir da classe record que recebe o json
                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println("Titulo: \n" + titulo);

                titulos.add(titulo);

            } catch (NumberFormatException ex) {
                System.out.println("Ocorreu um erro");
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println("Erro de argumento");
                System.out.println(ex.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMensagem());
            } catch (NullPointerException ex){
                System.out.println("Erro nulo");
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(titulos);


        //Escrever um arquivo novo
        FileWriter writer = new FileWriter("Filme.txt");
        writer.write(gson.toJson(titulos));
        writer.close();

        //Selecionar um arquivo existente
        File file = new File("Filme.txt");

        //Ler um arquivo selecionado
        FileReader reader = new FileReader(file);
        int data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }
        reader.close();

        System.out.println();

        System.out.println("Programa finalizado");

    }

}
