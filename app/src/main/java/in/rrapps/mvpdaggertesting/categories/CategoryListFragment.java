package in.rrapps.mvpdaggertesting.categories;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.rrapps.mvpdaggertesting.BaseApplication;
import in.rrapps.mvpdaggertesting.BaseFragment;
import in.rrapps.mvpdaggertesting.Constants;
import in.rrapps.mvpdaggertesting.R;
import in.rrapps.mvpdaggertesting.api.ApiService;
import in.rrapps.mvpdaggertesting.models.response.Result;
import in.rrapps.mvpdaggertesting.models.response.ResultEntity;
import in.rrapps.mvpdaggertesting.movie.detail.MovieDetailActivity;

/**
 * @author shishank
 */

public class CategoryListFragment extends BaseFragment implements Contracts.View
{

    @BindView(R.id.rv_movie_list)
    RecyclerView rvCategoryList;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_info)
    AppCompatTextView tvInfo;

    Unbinder unbinder;

    @Inject
    CategoryListPresenter presenter;

    private GridLayoutManager gridLayoutManager;

    private static int pageIndex = 1;
    private CategoryListAdapter categoryListAdapter;

    @Inject
    ApiService apiService;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getActivity().getApplication())
                .getAppComponent()
                .newCategoryComponent(new CategoryModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        presenter.init();
        /*RxRecyclerView.scrollEvents(rvCategoryList)
                .filter(event -> presenter.shouldUpdate())
                .filter(event1 -> hasScrolledToLast())
                .map(event -> pageIndex = pageIndex + 1)
                .subscribe(recyclerViewScrollEvent -> presenter.fetchMovies(pageIndex),
                        this::onError);*/

        presenter.fetchCategoryAndProductData();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }

    private Boolean hasScrolledToLast()
    {
        int pastVisibleItems, visibleItemCount, totalItemCount;
        visibleItemCount = gridLayoutManager.getChildCount();
        totalItemCount = gridLayoutManager.getItemCount();
        pastVisibleItems = gridLayoutManager.findFirstVisibleItemPosition();
        return (visibleItemCount + pastVisibleItems) >= totalItemCount;
    }

    private void resetPageIndex()
    {
        pageIndex = 1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_high_rated:
                resetPageIndex();
                presenter.sortByPopularity(pageIndex);
                break;
            case R.id.action_most_popular:
                resetPageIndex();
                presenter.sortByRating(pageIndex);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //View methods
    @Override
    public void initView()
    {
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        rvCategoryList.setLayoutManager(gridLayoutManager);
        categoryListAdapter = new CategoryListAdapter(getContext(), this);
        rvCategoryList.setAdapter(categoryListAdapter);
        presenter.fetchMovies(pageIndex);
    }

    @Override
    public void populateData(List<ResultEntity> resultList)
    {
        categoryListAdapter.addAll(resultList);
        hideLoading();
    }

    @Override
    public void onMovieItemSelected(Result result)
    {
        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        intent.putExtra(Constants.MOVIE_DETAIL, result);
        startActivity(intent);
    }

    @Override
    public void onError(Throwable throwable)
    {
        hideLoading();
        Snackbar.make(tvInfo, R.string.something_went_wrong, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading()
    {
        rvCategoryList.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        tvInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        progressBar.setVisibility(View.GONE);
        tvInfo.setVisibility(View.GONE);
        rvCategoryList.setVisibility(View.VISIBLE);
    }

    @Override
    public void sortingList()
    {
        showLoading();
        categoryListAdapter.clear();
    }
}
