package text.bwie.mrc.jdcom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwie.mrc.jdcom.Fragment.FaxianFragment;
import text.bwie.mrc.jdcom.Fragment.FenleiFragment;
import text.bwie.mrc.jdcom.Fragment.GouwuFragment;
import text.bwie.mrc.jdcom.Fragment.MedeFragment;
import text.bwie.mrc.jdcom.Fragment.ShouyeFragment;
import text.bwie.mrc.jdcom.ViewActivity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar mBottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        WindowManager wm = this.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        int a=width/7,b=height/15;
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(a, b)
                .setFontSize(0)
                .setTabPadding(2, 5, 5)
                .setChangeColor(Color.DKGRAY, Color.RED)
                .addTabItem(null, R.mipmap.shou2, R.mipmap.shou1, ShouyeFragment.class)
                .addTabItem(null, R.mipmap.fen2, R.mipmap.fen1, FenleiFragment.class)
                .addTabItem(null, R.mipmap.fa2, R.mipmap.fa1, FaxianFragment.class)
                .addTabItem(null, R.mipmap.che2, R.mipmap.che1, GouwuFragment.class)
                .addTabItem(null, R.mipmap.wo2, R.mipmap.wo1, MedeFragment.class)
                .setTabBarBackgroundColor(Color.WHITE)
                .isShowDivider(false);
    }


    public void goThirdPartyLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
