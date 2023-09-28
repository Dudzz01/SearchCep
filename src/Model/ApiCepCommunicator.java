package Model;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApiCepCommunicator
{
    private String url;
    private String searchEncoded;

    private String json;

    public boolean SearchCepPlace() throws IOException, InterruptedException {

        Scanner reader = new Scanner(System.in);

        boolean canSearch = false;
        boolean searchCompleted = false;
        String search = "";

        while (canSearch == false)
        {
            try
            {
                System.out.println("Digite o Cep que você deseja buscar");
                search = reader.nextLine().trim();

                if(search.length() == 8 && search.matches("\\d+")) // Verificando se o cep tem 8 digitos
                {
                    searchEncoded = URLEncoder.encode(search,StandardCharsets.UTF_8);
                    url = String.format("https://viacep.com.br/ws/%s/json/",searchEncoded);
                    canSearch = true;
                    searchCompleted = RequestDataCep(url);
                }
                else
                {
                    System.out.println("Digitou o cep incorretamente, nao utilize caracteres especiais e espacos entre os números");
                }

            }
            catch (InputMismatchException ex)
            {
                reader.nextLine(); // LIMPANDO BUFFER DE ENTRADA
                System.out.println("Valor inválido, digite 8 dígitos do CPF sem caracteres especiais!");
                System.out.println("Exemplo correto de digitar o CEP no nosso programa: 24451230");


            }

        }
        return searchCompleted;

    }

    private boolean RequestDataCep(String url) throws IOException, InterruptedException
    {
        var searchCompleted = false;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());


        json = response.body().toString();
        if(json.length() != 18)
        {
            searchCompleted = true;

        }

        return searchCompleted;
    }

    public String getJson()
    {
        return json;
    }


}
