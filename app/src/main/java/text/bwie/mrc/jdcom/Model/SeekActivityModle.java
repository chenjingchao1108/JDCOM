package text.bwie.mrc.jdcom.Model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import text.bwie.mrc.jdcom.Api.App;

public class SeekActivityModle {
    public SeekActivityModle() {

    }

    public void getData(String uri, final Seek_DataCallBack<String> seek_dataCallBack) {
        Request build = new Request.Builder().url(uri).build();
        App.okHttpClient().newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    seek_dataCallBack.getDataSucced(response.body().string());
                }
            }
        });
    }

    public interface Seek_DataCallBack<T> {
        void getDataSucced(T result);
    }
}
