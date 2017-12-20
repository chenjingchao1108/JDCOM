package text.bwie.mrc.jdcom.Fragment.Shouyefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import text.bwie.mrc.jdcom.Adapter.FragmentAdp.FragmentBAdapter;
import text.bwie.mrc.jdcom.Api.Api;
import text.bwie.mrc.jdcom.Bean.ShouyeBean.shouyeFenlei.ChildrenBean;
import text.bwie.mrc.jdcom.Presenter.Persenter;
import text.bwie.mrc.jdcom.R;
import text.bwie.mrc.jdcom.ViewActivity.Iview1;

/**
 * Created by Mr.c on 2017/12/14.
 */

public class BFragment extends Fragment implements Iview1{
    private View view;
    private RecyclerView mShouyeRecyclerView;
    private RecyclerView mShouyeRecyclerView1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fenleiiteml, null);
        initView(view);
        GridLayoutManager glide = new GridLayoutManager(getContext(), 2);
        glide.setOrientation(LinearLayoutManager.HORIZONTAL);
        mShouyeRecyclerView.setLayoutManager(glide);
        Persenter presenter = new Persenter(this);
        presenter.loadlist(Api.SYFL);

        return view;
    }

    private void initView(View view) {
        mShouyeRecyclerView = (RecyclerView) view.findViewById(R.id.shouye_recyclerView);
        mShouyeRecyclerView1 = (RecyclerView) view.findViewById(R.id.shouye_recyclerView1);
    }


    @Override
    public void Success(List<ChildrenBean> list) {
        FragmentBAdapter adapter=new FragmentBAdapter(getActivity(),list);
        mShouyeRecyclerView.setAdapter(adapter);
    }
}
