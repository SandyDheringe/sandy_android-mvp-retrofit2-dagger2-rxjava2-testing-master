package in.rrapps.mvpdaggertesting.movie;

import java.util.List;

import in.rrapps.mvpdaggertesting.models.response.Result;

/**
 * @author shishank
 */

public interface Contracts
{

    interface View
    {
        void initView();

        void populateData(List<Result> resultList);

        void onMovieItemSelected(Result result);

        void onError(Throwable throwable);

        void showLoading();

        void hideLoading();

        void sortingList();
    }

    interface Presenter
    {
        void init();

        void fetchMovies(int pageIndex);

        boolean shouldUpdate();

        void sortByPopularity(int pageIndex);

        void sortByRating(int pageIndex);

        void showLoading();

        void hideLoading();
    }
}
