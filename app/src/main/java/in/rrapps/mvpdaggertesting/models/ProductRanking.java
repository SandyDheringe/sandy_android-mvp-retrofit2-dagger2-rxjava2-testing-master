package in.rrapps.mvpdaggertesting.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

/**
 * @author SandeepD
 */

@Entity
public class ProductRanking
{
    @ColumnInfo(name = "productId")
    private int productId;
    @ColumnInfo(name = "rankingId")
    private int rankingId;
    @ColumnInfo(name = "value")
    private String value;

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public int getRankingId()
    {
        return rankingId;
    }

    public void setRankingId(int rankingId)
    {
        this.rankingId = rankingId;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
