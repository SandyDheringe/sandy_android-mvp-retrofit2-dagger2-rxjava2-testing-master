package in.rrapps.mvpdaggertesting.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant
{

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("size")
    @Expose
    public String size;
    @SerializedName("price")
    @Expose
    public int price;

}