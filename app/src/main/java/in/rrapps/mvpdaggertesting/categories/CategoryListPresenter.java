package in.rrapps.mvpdaggertesting.categories;

import in.rrapps.mvpdaggertesting.api.ApiService;
import in.rrapps.mvpdaggertesting.models.response.DiscoverResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author shishank
 */

public class CategoryListPresenter implements Contracts.Presenter
{
    private Contracts.View categoryView;
    private boolean isUpdating;
    private ApiService apiService;

    public CategoryListPresenter(Contracts.View categoryView, ApiService apiService)
    {
        super();
        this.categoryView = categoryView;
        this.apiService = apiService;
    }

    @Override
    public void init()
    {
        categoryView.initView();
    }

    @Override
    public void fetchCategoryAndProductData()
    {
        showLoading();
        apiService.getCategoryAndProductDetails().observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> isUpdating = false)
                .map(DiscoverResponse::getResults)
                .subscribe(saveData(), categoryView::onError);
    }

    void saveData()
    {

    }

    @Override
    public boolean shouldUpdate()
    {
        return !isUpdating;
    }

    @Override
    public void sortByPopularity(int pageIndex)
    {
    }

    @Override
    public void sortByRating(int pageIndex)
    {

    }

    @Override
    public void showLoading()
    {
        categoryView.showLoading();
    }

    @Override
    public void hideLoading()
    {
        categoryView.hideLoading();
    }
}
