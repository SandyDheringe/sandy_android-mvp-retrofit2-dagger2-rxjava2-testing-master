package in.rrapps.mvpdaggertesting.categories;

import dagger.Module;
import dagger.Provides;
import in.rrapps.mvpdaggertesting.api.ApiService;

/**
 * Created by abhishek
 * on 14/12/17.
 */

@Module
public class CategoryModule
{

    private final Contracts.View categoryView;

    public CategoryModule(Contracts.View categoryView)
    {
        this.categoryView = categoryView;
    }

    @Provides
    @CategoryScope
    CategoryListPresenter provideMovieListPresenter(ApiService apiService)
    {
        return new CategoryListPresenter(categoryView, apiService);
    }
}
