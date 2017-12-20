package text.bwie.mrc.jdcom.Net;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Mr.c on 2017/12/13.
 */

public class LoginHttpclient {
    static   OkHttpClient okHttpClient;
    static    LoginHttpclient loginHttpclient;

    private LoginHttpclient() {

    }

    public static LoginHttpclient getHttpClient()
    {
        if(loginHttpclient==null)
        {
            synchronized (LoginHttpclient.class)
            {
                if(loginHttpclient==null)
                {
                    loginHttpclient=new LoginHttpclient();
                    okHttpClient=new OkHttpClient();
                }
            }
        }
        return loginHttpclient;
    }

    //Post请求
    public void doPost(Map<String,String> param, String url, Callback callback)
    {
        FormBody.Builder builder=new FormBody.Builder();
        for(Map.Entry<String,String> map:param.entrySet())
        {
            builder.add(map.getKey(),map.getValue());
        }
        FormBody formBody=builder.build();
        Request request=new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(callback);

    }
}
