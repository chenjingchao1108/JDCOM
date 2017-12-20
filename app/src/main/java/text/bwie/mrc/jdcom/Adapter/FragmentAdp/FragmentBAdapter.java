package text.bwie.mrc.jdcom.Adapter.FragmentAdp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import text.bwie.mrc.jdcom.Bean.ShouyeBean.shouyeFenlei;
import text.bwie.mrc.jdcom.R;

/**
 * Created by Mr.c on 2017/12/16.
 */

public class FragmentBAdapter extends RecyclerView.Adapter<FragmentBAdapter.ViewHolder> {
        Context context;
        List<shouyeFenlei.ChildrenBean> list;
private ViewHolder holder;

public FragmentBAdapter(Context context, List<shouyeFenlei.ChildrenBean> list) {
        this.context = context;
        this.list = list;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newitem, parent, false);
        holder = new ViewHolder(view);
        return holder;
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImage_url()).into(holder.image);
        holder.text.setText(list.get(position).getOpt_name());


        }

@Override
public int getItemCount() {
        return list.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    public View rootView;
    public ImageView image;
    public TextView text;

    public ViewHolder(View rootView) {
        super(rootView);
        this.rootView = rootView;
        this.image = (ImageView) rootView.findViewById(R.id.item_image);
        this.text = (TextView) rootView.findViewById(R.id.item_text);
    }

}
}