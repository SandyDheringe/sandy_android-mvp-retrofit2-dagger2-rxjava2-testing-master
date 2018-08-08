package in.rrapps.mvpdaggertesting.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author SandeepD
 */

@Entity
public class Category
{
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "parentCategoryId")
    private int parentCategoryId;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getParentCategoryId()
    {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId)
    {
        this.parentCategoryId = parentCategoryId;
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
