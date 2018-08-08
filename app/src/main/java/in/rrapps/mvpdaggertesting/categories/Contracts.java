package in.rrapps.mvpdaggertesting.categories;

import java.util.List;

import in.rrapps.mvpdaggertesting.models.response.Result;
import in.rrapps.mvpdaggertesting.models.response.ResultEntity;

/**
 * @author shishank
 */

public interface Contracts
{

    interface View
    {
        void initView();

        void populateData(List<ResultEntity> resultList);

        void onMovieItemSelected(Result result);

        void onError(Throwable throwable);

        void showLoading();

        void hideLoading();

        void sortingList();
    }

    interface Presenter
    {
        void init();

        public void fetchCategoryAndProductData();


        boolean shouldUpdate();

        void sortByPopularity(int pageIndex);

        void sortByRating(int pageIndex);

        void showLoading();

        void hideLoading();
    }
}
