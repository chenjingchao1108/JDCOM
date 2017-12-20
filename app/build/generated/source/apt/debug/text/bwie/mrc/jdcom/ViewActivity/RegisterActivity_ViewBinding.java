// Generated code from Butter Knife. Do not modify!
package text.bwie.mrc.jdcom.ViewActivity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import text.bwie.mrc.jdcom.R;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view2131296271;

  private View view2131296272;

  private View view2131296270;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.Register_username, "field 'mRegisterUsername' and method 'onClick'");
    target.mRegisterUsername = Utils.castView(view, R.id.Register_username, "field 'mRegisterUsername'", EditText.class);
    view2131296271 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.Register_userpassword, "field 'mRegisterUserpassword' and method 'onClick'");
    target.mRegisterUserpassword = Utils.castView(view, R.id.Register_userpassword, "field 'mRegisterUserpassword'", EditText.class);
    view2131296272 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.Register_buttonup, "field 'mRegisterButtonup' and method 'onClick'");
    target.mRegisterButtonup = Utils.castView(view, R.id.Register_buttonup, "field 'mRegisterButtonup'", Button.class);
    view2131296270 = view;
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
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRegisterUsername = null;
    target.mRegisterUserpassword = null;
    target.mRegisterButtonup = null;

    view2131296271.setOnClickListener(null);
    view2131296271 = null;
    view2131296272.setOnClickListener(null);
    view2131296272 = null;
    view2131296270.setOnClickListener(null);
    view2131296270 = null;
  }
}
