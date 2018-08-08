package in.rrapps.mvpdaggertesting.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import in.rrapps.mvpdaggertesting.dao.MovieDataDao;
import in.rrapps.mvpdaggertesting.models.MovieData;

/**
 * @author shishank
 */

@Database(entities = {MovieData.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract MovieDataDao movieDataDao();
}
