package View;

import Model.ApiCepCommunicator;
import Model.jsonFiles.ConvertJson;
import Model.saveFiles.SearchStore;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner reader = new Scanner(System.in);
        ApiCepCommunicator apiCepCommunicator = new ApiCepCommunicator();
        ConvertJson convertJson = new ConvertJson();
        SearchStore searchStore = new SearchStore();
        var option = 0;

        do
        {
            System.out.println("Digite 0 para sair, Digite 1 para buscar o seu cep e suas respectivas informacoes");
            try
            {
                option = reader.nextInt();

                switch (option)
                {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:

                        var searchCompleted = apiCepCommunicator.SearchCepPlace();

                        if(searchCompleted)
                        {
                            String json = apiCepCommunicator.getJson();
                            var place = searchStore.getPlaceInformationList().add(convertJson.jsonToPlace(json));
                            searchStore.setJsonFinal(convertJson.placeToJson(searchStore.getPlaceInformationList()));
                        }
                        else
                        {
                            System.out.println("CEP não encontrado, tente novamente mais tarde");
                        }

                        break;
                    default:
                        System.out.println("Digite o comando valido");
                        break;
                }
            }
            catch (InputMismatchException ex)
            {
                option = 23; // valor aleatorio para que o loop continue
                reader.nextLine();
                System.out.println("Erro, digite novamente com os valores adequados");
            }



        }while (option !=0);


    }
}
