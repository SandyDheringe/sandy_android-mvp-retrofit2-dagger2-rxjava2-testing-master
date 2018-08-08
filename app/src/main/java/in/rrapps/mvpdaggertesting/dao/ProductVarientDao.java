package in.rrapps.mvpdaggertesting.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import in.rrapps.mvpdaggertesting.models.MovieData;
import io.reactivex.Single;

/**
 * @author shishank
 */

@Dao
public interface ProductVarientDao
{

    @Query("SELECT * FROM MovieData WHERE id = :id")
    Single<MovieData> getMovieData(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMovieData(MovieData movieData);

    @Update
    void updateMovieData(MovieData movieData);

}
