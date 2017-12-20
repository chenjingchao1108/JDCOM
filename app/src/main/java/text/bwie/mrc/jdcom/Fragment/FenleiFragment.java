package text.bwie.mrc.jdcom.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import text.bwie.mrc.jdcom.Adapter.FenleiAdapter.LeftAdapater;
import text.bwie.mrc.jdcom.Adapter.FenleiAdapter.RightAdapter;
import text.bwie.mrc.jdcom.Bean.FenleiBean.Catagory;
import text.bwie.mrc.jdcom.Bean.FenleiBean.ProductCatagoryBean;
import text.bwie.mrc.jdcom.Presenter.ClassPresenter;
import text.bwie.mrc.jdcom.R;
import text.bwie.mrc.jdcom.ViewActivity.IClassActivity;
import text.bwie.mrc.jdcom.util.GlideImageLoader;

/**
 * Created by Mr.c on 2017/12/4.
 */

public class FenleiFragment extends Fragment implements IClassActivity {
    private ListView mLvLeft;
    private ClassPresenter classPresenter;
    private LeftAdapater adapter;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表数据
    private ExpandableListView mElv;
    private Banner mBanner;
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
        View view = View.inflate(getActivity(), R.layout.fenleifragment_item, null);
        initView(view);
        classPresenter = new ClassPresenter(this);
        //去P层，调用getCatagory
        classPresenter.getCatagory();
        //给listview 设置点击事件
        mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.press(position);
                //请求对应的右侧数据
                //先获取cid
                Catagory.DataBean dataBean = (Catagory.DataBean) parent.getItemAtPosition(position);
                int cid = dataBean.getCid();
                classPresenter.getProductCatagory(cid + "");
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mLvLeft = (ListView) view.findViewById(R.id.lv_left);
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        Banner banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        images.add("http://img1.360buyimg.com/da/jfs/t13045/5/2021036467/85335/1c8963cd/5a2fbd3cN93918361.jpg");
        images.add("http://m.360buyimg.com/mobilecms/jfs/t14308/288/330773590/195505/65a1385f/5a2a6733Ne50116e7.jpg!q70.jpg");
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-12-06/e2d720d40ca9bed9c03618c67b7ece0e.png");
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-12-12/5f06372b3fc3de94e16ad92e41aaa05e.jpeg@750w_1l_50Q.webp");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void showData(List<Catagory.DataBean> list) {
        //创建适配器
        adapter = new LeftAdapater(getActivity(), list);
        mLvLeft.setAdapter(adapter);
    }

    /**
     * 用于elv展示数据
     *
     * @param list
     */
    @Override
    public void showElvData(List<ProductCatagoryBean.DataBean> list) {
        groupList.clear();
        childList.clear();
        //给二级列表封住数据
        for (int i = 0; i < list.size(); i++) {
            ProductCatagoryBean.DataBean dataBean = list.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }
        //创建适配器
        RightAdapter rightAdapter = new RightAdapter(getActivity(), groupList, childList);
        mElv.setAdapter(rightAdapter);
        //设置默认全部展开
        for (int i = 0; i < list.size(); i++) {
            mElv.expandGroup(i);
        }
    }
}

