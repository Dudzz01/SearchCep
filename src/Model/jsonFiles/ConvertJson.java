package Model.jsonFiles;

import Controller.PlaceInformationViaCepAPI;
import Model.PlaceInformation;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConvertJson
{
    private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create(); // setando que o gson para converter, utilizará o padrao camelCase para reconhecer atributos json, além de formatar bonito


    public PlaceInformation jsonToPlace(String json)
    {

        PlaceInformationViaCepAPI placeInformationViaCepAPI = gson.fromJson(json, PlaceInformationViaCepAPI.class);
        PlaceInformation placeInformation = new PlaceInformation(placeInformationViaCepAPI);

        return placeInformation;
    }

    public String placeToJson(List<PlaceInformation> placeInformationList) throws IOException
    {
        var path = "C:\\CEPbusca.json";
        FileWriter fileWriter = new FileWriter(path);

        var json = gson.toJson(placeInformationList);

        fileWriter.write(json);
        fileWriter.close();

        return json;
    }

    public void saveJsonInFileTxt(String json)
    {

    }
}
