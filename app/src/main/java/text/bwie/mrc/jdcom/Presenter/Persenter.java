package text.bwie.mrc.jdcom.Presenter;

import java.util.List;

import text.bwie.mrc.jdcom.Bean.ShouyeBean.shouyeFenlei;
import text.bwie.mrc.jdcom.Model.FragmentModel;
import text.bwie.mrc.jdcom.Model.Imodel;
import text.bwie.mrc.jdcom.Model.OkClick;
import text.bwie.mrc.jdcom.ViewActivity.Iview1;

public class Persenter implements Ipersenter {
    Imodel imodel;
    Iview1 iview;

    public Persenter(Iview1 iview) {
        this.iview = iview;
        this.imodel=new FragmentModel();
    }

    @Override
    public void loadlist(String url) {
        imodel.RequestData(url, new OkClick() {
            @Override
            public void Success(List<shouyeFenlei.ChildrenBean> list) {
                    iview.Success(list);
            }
        });
    }

}