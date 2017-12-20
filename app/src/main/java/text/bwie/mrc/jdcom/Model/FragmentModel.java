package text.bwie.mrc.jdcom.Model;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import text.bwie.mrc.jdcom.Bean.ShouyeBean.shouyeFenlei;
import text.bwie.mrc.jdcom.util.ServerApi;

public class FragmentModel implements Imodel {
    @Override
    public void RequestData(String url, final OkClick okClick) {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ServerApi api = retrofit.create(ServerApi.class);
        Observable<shouyeFenlei> getdata = api.getdata();
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<shouyeFenlei>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(shouyeFenlei shouye) {
                    List<shouyeFenlei.ChildrenBean> list = shouye.getChildren();
                    okClick.Success(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}