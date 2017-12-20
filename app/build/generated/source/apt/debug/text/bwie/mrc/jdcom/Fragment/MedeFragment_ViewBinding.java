// Generated code from Butter Knife. Do not modify!
package text.bwie.mrc.jdcom.Fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import text.bwie.mrc.jdcom.R;

public class MedeFragment_ViewBinding implements Unbinder {
  private MedeFragment target;

  private View view2131296407;

  private View view2131296442;

  @UiThread
  public MedeFragment_ViewBinding(final MedeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.hander, "method 'onClick'");
    view2131296407 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.login_register_tv, "method 'onClick'");
    view2131296442 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131296407.setOnClickListener(null);
    view2131296407 = null;
    view2131296442.setOnClickListener(null);
    view2131296442 = null;
  }
}
