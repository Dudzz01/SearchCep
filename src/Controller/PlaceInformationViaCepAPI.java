package Controller;

import com.google.gson.annotations.SerializedName;

public record PlaceInformationViaCepAPI(@SerializedName("cep")String cep, @SerializedName("logradouro")String logradouro, @SerializedName("bairro")String bairro, @SerializedName("localidade")String localidade)
{

}
