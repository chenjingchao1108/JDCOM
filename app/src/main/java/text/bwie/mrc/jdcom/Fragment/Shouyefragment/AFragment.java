package text.bwie.mrc.jdcom.Fragment.Shouyefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.ArrayList;

import text.bwie.mrc.jdcom.Api.App;
import text.bwie.mrc.jdcom.R;
import text.bwie.mrc.jdcom.ViewActivity.SeekActivity_View;
import text.bwie.mrc.jdcom.ViewActivity.SeekActivity_presenter;
import text.bwie.mrc.jdcom.util.GlideImageLoader;

/**
 * Created by Mr.c on 2017/12/14.
 */

public class AFragment extends Fragment implements SeekActivity_View {
    private RecyclerView mShouyeRecyclerView;
    private View view;
    private SeekActivity_presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shouye_banner, null);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Banner mSYViewpager = (Banner) view.findViewById(R.id.SY_viewpager);
        //设置图片集合
        mSYViewpager.setImageLoader(new GlideImageLoader());
        ArrayList<String> list = new ArrayList<>();
        list.add("http://omsproductionimg.yangkeduo.com/images/2017-12-06/be39e10c45cde21586c72bfd45a94a62.png");
        list.add("http://omsproductionimg.yangkeduo.com/images/2017-11-30/21cf9f66e67ef81e6a2268483061fc00.png");
        list.add("http://img1.360buyimg.com/da/jfs/t13045/5/2021036467/85335/1c8963cd/5a2fbd3cN93918361.jpg");
        list.add("http://m.360buyimg.com/mobilecms/jfs/t14308/288/330773590/195505/65a1385f/5a2a6733Ne50116e7.jpg!q70.jpg");
        list.add("http://omsproductionimg.yangkeduo.com/images/2017-12-06/e2d720d40ca9bed9c03618c67b7ece0e.png");
        list.add("http://omsproductionimg.yangkeduo.com/images/2017-12-12/5f06372b3fc3de94e16ad92e41aaa05e.jpeg@750w_1l_50Q.webp");
        mSYViewpager.setImages(list);
        mSYViewpager.setDelayTime(2000);
        //banner设置方法全部调用完毕时最后调用
        mSYViewpager.start();
    }

    private void initView() {
        mShouyeRecyclerView = (RecyclerView) view.findViewById(R.id.shouye_recyclerView);
        mShouyeRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        presenter = new SeekActivity_presenter(this);

    }

    @Override
    public void getResultSucced(String result) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
//                SeekActivity_Bean bean = gson.fromJson(result, SeekActivity_Bean.class);
//                List<SeekActivity_Bean.DatasBean.GoodsListBean> goods_list = bean.getDatas().getGoods_list();
//
//                Activity_Seek_Adapter adapter = new Activity_Seek_Adapter(goods_list, getContext());
//                shouye_recyclerView.setAdapter(adapter);
//                shouye_recyclerView.addItemDecoration(new SpaceItemDecoration(5));
            }
        });
    }
    @Override
    public Context context() {
        return App.getContext();
    }
}
