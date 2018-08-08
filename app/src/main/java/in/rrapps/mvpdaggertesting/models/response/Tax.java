package in.rrapps.mvpdaggertesting.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax
{

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("value")
    @Expose
    public Integer value;

}