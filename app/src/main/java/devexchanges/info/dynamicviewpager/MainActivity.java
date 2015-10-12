package devexchanges.info.dynamicviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_PAGES = 10;
    private DynamicViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (DynamicViewPager) findViewById(R.id.pager);
        viewPager.setMaxPages(MAX_PAGES);
        viewPager.setBackgroundAsset(R.mipmap.background);
        viewPager.setAdapter(new MyPagerAdapter());

        /*if (savedInstanceState != null) {
            num_pages = savedInstanceState.getInt("num_pages");
            viewPager.setCurrentItem(savedInstanceState.getInt("current_page"), false);
        }*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /*outState.putInt("num_pages", num_pages);
        outState.putInt("current_page", viewPager.getCurrentItem());*/
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return MAX_PAGES;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.layout_page, null);
            TextView num = (TextView) view.findViewById(R.id.page_number);
            String pos = "This is page " + (position + 1);
            num.setText(pos);

            container.addView(view);

            return view;
        }
    }
}
