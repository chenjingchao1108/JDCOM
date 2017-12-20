package text.bwie.mrc.jdcom.Net;

/**
 * Created by Mr.c on 2017/12/8.
 */

public interface OnNetListener<T> {
    //成功回调
    public void onSuccess(T t);

    //失败回调
    public void onFailure(Exception e);

}
