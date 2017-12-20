package text.bwie.mrc.jdcom.ViewActivity;

import java.util.List;

import text.bwie.mrc.jdcom.Bean.FenleiBean.Catagory;
import text.bwie.mrc.jdcom.Bean.FenleiBean.ProductCatagoryBean;

/**
 * Created by Mr.c on 2017/12/8.
 */

public interface IClassActivity {
    public void showData(List<Catagory.DataBean> list);

    public void showElvData(List<ProductCatagoryBean.DataBean> list);
}
