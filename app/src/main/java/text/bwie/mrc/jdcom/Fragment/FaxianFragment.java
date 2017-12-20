package text.bwie.mrc.jdcom.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import text.bwie.mrc.jdcom.Api.App;
import text.bwie.mrc.jdcom.Api.FragmentFactory;
import text.bwie.mrc.jdcom.R;
import text.bwie.mrc.jdcom.ViewActivity.TabPageIndicator;
import text.bwie.mrc.jdcom.util.CommonUtils;

/**
 * Created by Mr.c on 2017/12/4.
 */

public class FaxianFragment extends Fragment {

    private TabPageIndicator indicator;
    private ViewPager viewPager;
    /**
     * 在这里实现Fragment数据的缓加载.
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisibleToUser = true;
        } else {
            isVisibleToUser = false;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxianfragment, null);
        indicator = (TabPageIndicator)view.findViewById(R.id.indicator);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        BasePagerAdapter adapter = new BasePagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        setTabPagerIndicator();
        return view;
    }
    private void setTabPagerIndicator() {
        indicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_NOWEIGHT_EXPAND_SAME);// 设置模式，一定要先设置模式
        indicator.setDividerPadding(CommonUtils.dip2px(App.getContext(), 20));
        indicator.setIndicatorColor(Color.parseColor("#E3443B"));// 设置底部导航线的颜色
        indicator.setTextColorSelected(Color.parseColor("#E3443B"));// 设置tab标题选中的颜色
        indicator.setTextColor(Color.parseColor("#797979"));// 设置tab标题未被选中的颜色
        indicator.setTextSize(CommonUtils.sp2px(App.getContext(), 16));// 设置字体大小
    }
    class BasePagerAdapter extends FragmentPagerAdapter {

        String[] titles;

        public BasePagerAdapter(FragmentManager fm) {
            super(fm);
            this.titles = CommonUtils.getStringArray(R.array.expand_titles);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createForExpand(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
