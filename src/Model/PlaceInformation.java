package Model;

import Controller.PlaceInformationViaCepAPI;

public class PlaceInformation
{
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;


    public PlaceInformation(PlaceInformationViaCepAPI placeInformationViaCepAPI)
    {
        this.cep = placeInformationViaCepAPI.cep();
        this.logradouro = placeInformationViaCepAPI.logradouro();
        this.bairro = placeInformationViaCepAPI.bairro();
        this.localidade = placeInformationViaCepAPI.localidade();
        System.out.println(this);
    }
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override

    public String toString()
    {
        return String.format("-------Place searched-------\ncep: %s \nlogradouro: %s \nbairro: %s \nlocalidade: %s",cep,logradouro,bairro,localidade);
    }
}
