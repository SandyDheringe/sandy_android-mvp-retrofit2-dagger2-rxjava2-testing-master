package in.rrapps.mvpdaggertesting.categories;

import android.os.Bundle;

import in.rrapps.mvpdaggertesting.BaseToolBarActivity;
import in.rrapps.mvpdaggertesting.R;


public class CategoryListActivity extends BaseToolBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

    }

}
