package in.rrapps.mvpdaggertesting.categories;

import dagger.Subcomponent;


/**
 * Created by SandeepD
 * on 15/05/18.
 * <p>
 * Custom scope for category screen, this is a child component of App Component
 * and needs to be smaller in size
 */
@CategoryScope
@Subcomponent(modules = {CategoryModule.class})
public interface CategoryComponent
{
    void inject(CategoryListFragment categoryListFragment);
}