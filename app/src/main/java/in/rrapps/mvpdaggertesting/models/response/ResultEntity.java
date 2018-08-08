package in.rrapps.mvpdaggertesting.models.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultEntity implements Parcelable
{

    @SerializedName("categories")
    @Expose
    public List<Category> categories = null;
    @SerializedName("rankings")
    @Expose
    public List<Ranking> rankings = null;

    protected ResultEntity(Parcel in)
    {
        categories = in.createTypedArrayList(Category.CREATOR);
    }

    public static final Creator<ResultEntity> CREATOR = new Creator<ResultEntity>()
    {
        @Override
        public ResultEntity createFromParcel(Parcel in)
        {
            return new ResultEntity(in);
        }

        @Override
        public ResultEntity[] newArray(int size)
        {
            return new ResultEntity[size];
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
        dest.writeTypedList(categories);
    }
}