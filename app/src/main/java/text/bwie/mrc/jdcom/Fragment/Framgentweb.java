package text.bwie.mrc.jdcom.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.gson.Gson;

import text.bwie.mrc.jdcom.Bean.FenleiBean.GoodsDetails;

/**
 * Created by C on 2017/12/12.
 */
@SuppressLint("ValidFragment")
public class Framgentweb extends Fragment {
    private Context context;
    private GoodsDetails details;
    private WebView wb;

    public Framgentweb(Context context, GoodsDetails details) {
        this.context = context;
        this.details = details;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        wb = new WebView(getActivity());
        return wb;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        String json = arguments.getString("json", null);
        GoodsDetails goodsDetails = new Gson().fromJson(json, GoodsDetails.class);
        String detailUrl = goodsDetails.data.detailUrl;
        wb.loadUrl(detailUrl);
    }
}
