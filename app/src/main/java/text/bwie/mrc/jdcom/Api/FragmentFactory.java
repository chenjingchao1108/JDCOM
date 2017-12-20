package text.bwie.mrc.jdcom.Api;

import android.support.v4.app.Fragment;

import text.bwie.mrc.jdcom.Fragment.Shouyefragment.AFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.BFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.CFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.DFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.EFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.FFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.GFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.HFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.IFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.JFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.KFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.LFragment;
import text.bwie.mrc.jdcom.Fragment.Shouyefragment.MFragment;


/**
 * Created by shan_yao on 2016/6/17.
 */
public class FragmentFactory {
    public static Fragment createForExpand(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AFragment();
                break;
            case 1:
                fragment = new BFragment();
                break;
            case 2:
                fragment = new CFragment();
                break;
            case 3:
                fragment = new DFragment();
                break;
            case 4:
                fragment = new EFragment();
                break;
            case 5:
                fragment = new FFragment();
                break;
            case 6:
                fragment = new GFragment();
                break;
            case 7:
                fragment = new HFragment();
                break;
            case 8:
                fragment = new IFragment();
                break;
            case 9:
                fragment = new JFragment();
                break;
            case 10:
                fragment = new KFragment();
                break;
            case 11:
                fragment = new LFragment();
                break;
            case 12:
                fragment = new MFragment();
                break;
        }
        return fragment;
    }
}
