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

import text.bwie.mrc.jdcom.Bean.ShouyeBean.ProductInfo;
import text.bwie.mrc.jdcom.R;


/**
 * Created by C on 2017/10/12.
 */

public class GridetAdapter extends RecyclerView.Adapter<GridetAdapter.myViewHolder> {
    private List<ProductInfo.DataBean> list;
    private Context context;

    public GridetAdapter(List<ProductInfo.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.gridepro, parent, false);
        myViewHolder holder = new myViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.price.setText(list.get(position).price + "");
        holder.title.setText(list.get(position).title);
        String images = list.get(position).images;
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final TextView price;

        public myViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.proimg1);
            title = itemView.findViewById(R.id.protitle);
            price = itemView.findViewById(R.id.proprice);

        }
    }
}
