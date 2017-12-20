package text.bwie.mrc.jdcom.ViewActivity;

import text.bwie.mrc.jdcom.Model.SeekActivityModle;
import text.bwie.mrc.jdcom.Presenter.BasePresenter;

public class SeekActivity_presenter extends BasePresenter<SeekActivity_View> {

    private SeekActivityModle modle;

    public SeekActivity_presenter(SeekActivity_View iview) {
        super(iview);
    }

    public void getData(String uri) {
        modle.getData(uri, new SeekActivityModle.Seek_DataCallBack<String>() {
            @Override
            public void getDataSucced(String result) {
                Iview.getResultSucced(result);
            }
        });
    }

    @Override
    public void InitModel() {
        modle = new SeekActivityModle();
    }
}