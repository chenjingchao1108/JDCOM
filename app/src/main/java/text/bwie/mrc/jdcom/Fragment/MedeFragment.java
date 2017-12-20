package text.bwie.mrc.jdcom.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import text.bwie.mrc.jdcom.Model.FirstEvent;
import text.bwie.mrc.jdcom.R;
import text.bwie.mrc.jdcom.ViewActivity.LoginActivity;

import static android.view.View.inflate;

/**
 * Created by Mr.c on 2017/12/4.
 */

public class MedeFragment extends Fragment {


    private ImageView mHander;


    private TextView mLoginRegisterTv;
    private Unbinder unbinder;
    private SharedPreferences hander_sp;//保存头像

    /**
     * 登录/注册 &gt;
     */
    private RelativeLayout mLoginRegisterLayout;
    private View view;
    private ImageView mDengluTop1;
    private ImageView mDengluTop2;
    private ImageView mDengluTop3;
    private ImageView mDengluTop4;
    private ImageView mDengluTop5;
    private ImageView mDengluTop6;
    private ImageView mDengluTop7;
    private ImageView mDengluTop8;
    private ImageView mDengluTop9;
    private ImageView mDengluTop10;
    private ImageView mDengluTop11;
    private ImageView mDengluTop12;
    private ImageView mDengluTop13;
    private ImageView mDengluTop14;
    private ImageView mDengluTop15;
    private ImageView mDengluTop16;
    private ImageView mDengluTop17;
    private ImageView mDengluTop18;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册EventBus
        EventBus.getDefault().register(this);
    }

    /**
     * 在这里实现Fragment数据的缓加载.
     *
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
        View view = inflate(getActivity(), R.layout.medefragment, null);
        // initView(View.inflate(getActivity(), R.layout.medefragment, null));
        unbinder = ButterKnife.bind(this, inflate(getActivity(), R.layout.medefragment, null));
        hander_sp = getActivity().getSharedPreferences("handerImage", Context.MODE_PRIVATE);
        mLoginRegisterTv = view.findViewById(R.id.login_register_tv);
        mHander = view.findViewById(R.id.hander);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //加载默认显示头像
        if (hander_sp.getString("ImageKey", null) != null) {
            setImageByImageLoader(hander_sp.getString("ImageKey", null), mHander);
        }
        //加载显示名称
        if (hander_sp.getString("NameKey", null) != null) {
            mLoginRegisterTv.setText(hander_sp.getString("NameKey", null));
        }
        mLoginRegisterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Subscribe
    public void onEventMainThread(FirstEvent event) {
        hander_sp.edit().putString("ImageKey", event.getImg()).commit();
        hander_sp.edit().putString("NameKey", event.getName()).commit();
        if (hander_sp.getString("ImageKey", null) != null) {
            setImageByImageLoader(hander_sp.getString("ImageKey", null), mHander);
        }
        if (hander_sp.getString("NameKey", null) != null) {
            mLoginRegisterTv.setText(hander_sp.getString("NameKey", null));
        }
    }

    //imageLoader 加载图片
    public static void setImageByImageLoader(String uri, ImageView img) {
        DisplayImageOptions build = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageForEmptyUri(R.mipmap.b3h)
                .showImageOnFail(R.mipmap.b3h)
                .showImageOnLoading(R.mipmap.loading)
                .displayer(new CircleBitmapDisplayer())
                .build();
        ImageLoader.getInstance().displayImage(uri, img, build);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);//反注册EventBus
        unbinder.unbind();
    }

    @OnClick({R.id.hander, R.id.login_register_tv})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.hander:
                break;
            case R.id.login_register_tv:

                break;
        }
    }

    private void initView(View view) {
        mHander = (ImageView) view.findViewById(R.id.hander);
        mLoginRegisterTv = (TextView) view.findViewById(R.id.login_register_tv);
        mLoginRegisterLayout = (RelativeLayout) view.findViewById(R.id.login_register_layout);
        mDengluTop1 = (ImageView) view.findViewById(R.id.denglu_top1);
        mDengluTop2 = (ImageView) view.findViewById(R.id.denglu_top2);
        mDengluTop3 = (ImageView) view.findViewById(R.id.denglu_top3);
        mDengluTop4 = (ImageView) view.findViewById(R.id.denglu_top4);
        mDengluTop5 = (ImageView) view.findViewById(R.id.denglu_top5);
        mDengluTop6 = (ImageView) view.findViewById(R.id.denglu_top6);
        mDengluTop7 = (ImageView) view.findViewById(R.id.denglu_top7);
        mDengluTop8 = (ImageView) view.findViewById(R.id.denglu_top8);
        mDengluTop9 = (ImageView) view.findViewById(R.id.denglu_top9);
        mDengluTop10 = (ImageView) view.findViewById(R.id.denglu_top10);
        mDengluTop11 = (ImageView) view.findViewById(R.id.denglu_top11);
        mDengluTop12 = (ImageView) view.findViewById(R.id.denglu_top12);
        mDengluTop13 = (ImageView) view.findViewById(R.id.denglu_top13);
        mDengluTop14 = (ImageView) view.findViewById(R.id.denglu_top14);
        mDengluTop15 = (ImageView) view.findViewById(R.id.denglu_top15);
        mDengluTop16 = (ImageView) view.findViewById(R.id.denglu_top16);
        mDengluTop17 = (ImageView) view.findViewById(R.id.denglu_top17);
        mDengluTop18 = (ImageView) view.findViewById(R.id.denglu_top18);
    }
}
