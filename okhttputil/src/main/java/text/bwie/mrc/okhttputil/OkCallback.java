package text.bwie.mrc.okhttputil;

public interface OkCallback {
    void onFailure(String e, String msg);//e:异常数据，msg：请求失败提示
    void onResponse(String result);//请求成功json串
}
