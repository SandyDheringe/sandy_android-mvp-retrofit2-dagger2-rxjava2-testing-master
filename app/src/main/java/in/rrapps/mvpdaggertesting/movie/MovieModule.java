package in.rrapps.mvpdaggertesting.movie;

import dagger.Module;
import dagger.Provides;
import in.rrapps.mvpdaggertesting.api.ApiService;

/**
 * Created by abhishek
 * on 14/12/17.
 */

@Module
public class MovieModule
{

    private final Contracts.View movieView;

    public MovieModule(Contracts.View movieView)
    {
        this.movieView = movieView;
    }

    @Provides
    @MovieScope
    MovieListPresenter provideMovieListPresenter(ApiService apiService)
    {
        return new MovieListPresenter(movieView, apiService);
    }
}
