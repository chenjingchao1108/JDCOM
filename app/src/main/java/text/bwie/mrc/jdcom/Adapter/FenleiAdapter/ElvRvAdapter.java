package text.bwie.mrc.jdcom.Adapter.FenleiAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import text.bwie.mrc.jdcom.Bean.FenleiBean.ProductCatagoryBean;
import text.bwie.mrc.jdcom.R;

/**
 * Created by Mr.c on 2017/12/8.
 */

public class ElvRvAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ProductCatagoryBean.DataBean.ListBean> listBeen;
    //2、定义一个属性
    private ItemOnclick itemOnclick;

    //1、接口回调第一步，先定义一个接口
    public interface ItemOnclick {
       public void onItemClick(View v, int pcid);
    }

    //3、定义一个方法
    public void setOnItemClickListener(ItemOnclick onItemClickListener) {
        this.itemOnclick = onItemClickListener;
    }

    public ElvRvAdapter(Context context, List<ProductCatagoryBean.DataBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_fragment_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ProductCatagoryBean.DataBean.ListBean listBean = listBeen.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(listBean.getName());
        myViewHolder.iv.setImageURI(listBean.getIcon());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnclick.onItemClick(v,listBeen.get(position).getPscid());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView iv;
        private TextView tv;
        private LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.reight_tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
