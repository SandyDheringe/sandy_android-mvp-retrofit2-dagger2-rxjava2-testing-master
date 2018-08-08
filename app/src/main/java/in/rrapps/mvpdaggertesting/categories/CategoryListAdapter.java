package in.rrapps.mvpdaggertesting.categories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.rrapps.mvpdaggertesting.R;
import in.rrapps.mvpdaggertesting.models.Category;
import lombok.Getter;

/**
 * @author shishank
 */

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>
{
    private Context context;

    @Getter
    private List<Category> movieList;
    private LayoutInflater layoutInflater;
    private Contracts.View categoryView;

    public CategoryListAdapter(Context context, Contracts.View categoryView)
    {
        this.context = context;
        movieList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
        this.categoryView = categoryView;
    }

    public void addAll(List<Category> results)
    {
        movieList.addAll(results);
        notifyDataSetChanged();
    }

    public List<Category> getList()
    {
        return movieList;
    }

    public void clear()
    {
        if (movieList != null)
        {
            movieList.clear();
        }
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new CategoryViewHolder(layoutInflater.inflate(R.layout.view_category_item, parent,
                false));
    }


    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position)
    {
        holder.bindViews(movieList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return movieList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_category_name)
        TextView tvCategoryName;

        CategoryViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindViews(Category result)
        {
            tvCategoryName.setText(result.getName());
        }
    }
}
