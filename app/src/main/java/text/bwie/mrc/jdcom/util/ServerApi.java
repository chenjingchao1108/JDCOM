package text.bwie.mrc.jdcom.util;

import io.reactivex.Observable;
import retrofit2.http.GET;
import text.bwie.mrc.jdcom.Bean.ShouyeBean.shouyeFenlei;

/**
 * Created by Mr.c on 2017/12/13.
 */

public interface ServerApi {
    @GET("home_operations?pdduid=3470667255")
    Observable<shouyeFenlei> getdata();
}
