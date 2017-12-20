package text.bwie.mrc.jdcom.Model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.Response;
import text.bwie.mrc.jdcom.Api.Api;
import text.bwie.mrc.jdcom.Bean.FenleiBean.Catagory;
import text.bwie.mrc.jdcom.Bean.FenleiBean.ProductCatagoryBean;
import text.bwie.mrc.jdcom.Net.HttpUtils;
import text.bwie.mrc.jdcom.Net.OnNetListener;

/**
 * Created by Mr.c on 2017/12/8.
 */

public class ClassModel extends BaseModel implements IClassModel{
    @Override
    public void getCatagory(final OnNetListener<Catagory> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.CLASS, new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                String string = response.body().string();
                final Catagory catagory = new Gson().fromJson(string, Catagory.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(catagory);
                    }
                });
            }

        });
    }

    @Override
    public void getProductCatagory(String cid, final OnNetListener<ProductCatagoryBean> onNetListener) {
        Map<String, String> params = new HashMap<>();
        params.put("cid", cid);
        HttpUtils.getHttpUtils().doPost(Api.PRODUCT_CATAGORY, params, new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                String string = response.body().string();
                final ProductCatagoryBean productCatagoryBean = new Gson().fromJson(string, ProductCatagoryBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(productCatagoryBean);
                    }
                });
            }
        });
    }
}
