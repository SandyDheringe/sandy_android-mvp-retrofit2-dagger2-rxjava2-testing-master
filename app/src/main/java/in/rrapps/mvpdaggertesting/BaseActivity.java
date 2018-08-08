package in.rrapps.mvpdaggertesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import javax.inject.Inject;

import in.rrapps.mvpdaggertesting.api.ApiService;

public abstract class BaseActivity extends AppCompatActivity
{

    @Inject
    ApiService apiService;

    private FrameLayout contentFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.setContentView(in.rrapps.mvpdaggertesting.R.layout.activity_base);


        contentFrame = (FrameLayout) findViewById(in.rrapps.mvpdaggertesting.R.id.base_container);
    }

    @Override
    public void setContentView(int layoutResId)
    {
        getLayoutInflater().inflate(layoutResId, contentFrame, true);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
