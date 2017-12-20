package text.bwie.mrc.jdcom.Presenter;

import android.content.Context;

import text.bwie.mrc.jdcom.Api.App;
import text.bwie.mrc.jdcom.ViewActivity.IView;

public abstract class BasePresenter<T extends IView> {
    protected T Iview;

    public BasePresenter(T iview) {
        this.Iview = iview;
        InitModel();
    }

    public abstract void InitModel();

    Context Basecontext() {
        if (Iview != null && Iview.context() != null) {
            return Iview.context();
        }
        return App.getContext();
    }
}
