package in.rrapps.mvpdaggertesting.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author SandeepD
 */

@Entity
public class Varient
{
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "productId")
    private int productId;

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "size")
    private String size;

    @ColumnInfo(name = "price")
    private int price;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }


}
