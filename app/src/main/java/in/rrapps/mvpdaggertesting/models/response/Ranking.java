package in.rrapps.mvpdaggertesting.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ranking
{

    @SerializedName("ranking")
    @Expose
    public String ranking;
    @SerializedName("products")
    @Expose
    public List<ProductRanking> products = null;

}