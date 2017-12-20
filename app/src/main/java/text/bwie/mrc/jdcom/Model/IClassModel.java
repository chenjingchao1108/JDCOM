package text.bwie.mrc.jdcom.Model;

import text.bwie.mrc.jdcom.Bean.FenleiBean.Catagory;
import text.bwie.mrc.jdcom.Bean.FenleiBean.ProductCatagoryBean;
import text.bwie.mrc.jdcom.Net.OnNetListener;

/**
 * Created by Mr.c on 2017/12/8.
 */

public interface IClassModel {
    public void getCatagory(OnNetListener<Catagory> onNetListener);

    public void getProductCatagory(String cid, OnNetListener<ProductCatagoryBean> onNetListener);
}
