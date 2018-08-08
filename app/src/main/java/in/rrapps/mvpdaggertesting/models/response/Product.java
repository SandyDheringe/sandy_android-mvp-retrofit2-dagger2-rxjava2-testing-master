package in.rrapps.mvpdaggertesting.models.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product implements Parcelable
{

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("date_added")
    @Expose
    public String dateAdded;
    @SerializedName("variants")
    @Expose
    public List<Variant> variants = null;
    @SerializedName("tax")
    @Expose
    public Tax tax;

    protected Product(Parcel in)
    {
        if (in.readByte() == 0)
        {
            id = null;
        } else
        {
            id = in.readInt();
        }
        name = in.readString();
        dateAdded = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>()
    {
        @Override
        public Product createFromParcel(Parcel in)
        {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size)
        {
            return new Product[size];
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
        dest.writeString(dateAdded);
    }
}