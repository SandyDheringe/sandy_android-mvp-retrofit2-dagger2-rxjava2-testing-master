package in.rrapps.mvpdaggertesting.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author SandeepD
 */

@Entity
public class Product
{
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "categoryId")
    private int categoryId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "dateAdded")
    private String dateAdded;

    @ColumnInfo(name = "taxName")
    private String taxName;

    @ColumnInfo(name = "taxValue")
    private String taxValue;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int geCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
