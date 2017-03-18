package homePage.tests_page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kanak on 16/10/16.
 */

public class PagerAdapterHomePage extends FragmentPagerAdapter {
    public PagerAdapterHomePage(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f =null;
        switch (position)
        {
            case 0:
            {
                f = new test_physics();
            }
            break;
            case 1:
            {
                f = new test_chemistry();
            }
            break;
            case 2:
            {
                f = new test_maths();
            }
            break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
