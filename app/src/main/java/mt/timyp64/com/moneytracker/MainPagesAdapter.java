package mt.timyp64.com.moneytracker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagesAdapter extends FragmentPagerAdapter {

    private static final int PAGE_INCOMES = 0;
    private static final int PAGE_EXPEMSES = 1;
    private static final int PAGE_BALANCE = 2;

    private String[] titles;

    public MainPagesAdapter(FragmentManager fm, Context context) {
        super(fm);

        titles = context.getResources().getStringArray(R.array.tab_title);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case PAGE_INCOMES:
                return ItemsFragment.createItemsFragmensFragment(Item.TYPE_INCOMES);
            case PAGE_EXPEMSES:
                return ItemsFragment.createItemsFragmensFragment(Item.TYPE_EXPENSES);
            case PAGE_BALANCE:
                return null;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
