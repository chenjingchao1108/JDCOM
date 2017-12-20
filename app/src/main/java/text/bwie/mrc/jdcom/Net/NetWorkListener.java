package text.bwie.mrc.jdcom.Net;

/**
 * Created by Mr.c on 2017/12/13.
 */

public interface NetWorkListener<T> {
    public void onError(Exception e);
    public void onSuccess(T t);
}
