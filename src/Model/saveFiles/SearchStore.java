package Model.saveFiles;

import Model.PlaceInformation;

import java.util.ArrayList;
import java.util.List;

public class SearchStore
{
    private List<PlaceInformation> placeInformationList = new ArrayList<>();

    private String jsonFinal;

    public List<PlaceInformation> getPlaceInformationList() {
        return placeInformationList;
    }

    public String getJsonFinal() {
        return jsonFinal;
    }

    public void setJsonFinal(String jsonFinal) {
        this.jsonFinal = jsonFinal;
    }

    public void showJsonFinal()
    {
        System.out.println(jsonFinal);
    }
}
