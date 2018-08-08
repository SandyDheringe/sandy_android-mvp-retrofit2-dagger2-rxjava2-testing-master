package in.rrapps.mvpdaggertesting.models.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category implements Parcelable
{

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("products")
    @Expose
    public List<Product> products = null;
    @SerializedName("child_categories")
    @Expose
    public List<Integer> childCategories = null;

    protected Category(Parcel in)
    {
        if (in.readByte() == 0)
        {
            id = null;
        } else
        {
            id = in.readInt();
        }
        name = in.readString();
        products = in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>()
    {
        @Override
        public Category createFromParcel(Parcel in)
        {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size)
        {
            return new Category[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        if (id == null)
        {
            dest.writeByte((byte) 0);
        } else
        {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeTypedList(products);
    }
}