package in.rrapps.mvpdaggertesting.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductRanking
{

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("view_count")
    @Expose
    public Integer viewCount;
    @SerializedName("order_count")
    @Expose
    public Integer orderCount;
    @SerializedName("shares")
    @Expose
    public Integer shares;

}