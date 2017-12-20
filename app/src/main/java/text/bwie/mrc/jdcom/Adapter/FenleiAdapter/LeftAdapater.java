package text.bwie.mrc.jdcom.Adapter.FenleiAdapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import text.bwie.mrc.jdcom.Bean.FenleiBean.Catagory;
import text.bwie.mrc.jdcom.R;

/**
 * Created by Mr.c on 2017/12/8.
 */

public class LeftAdapater extends BaseAdapter {
    private Context context;
    private List<Catagory.DataBean> list;


    public LeftAdapater(Context context, List<Catagory.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.left_fragment_item,null);
            holder.tv = view.findViewById(R.id.tv);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        Catagory.DataBean dataBean = list.get(position);
        holder.tv.setText(dataBean.getName());
        if(dataBean.isChecked()){
            holder.tv.setBackgroundColor(Color.parseColor("#EEEEEE"));
            holder.tv.setTextColor(Color.parseColor("#FF0000"));

        }else {
            holder.tv.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.tv.setTextColor(Color.parseColor("#FF262426"));
        }
        return view;
    }
    class ViewHolder{
        TextView tv;
    }

    public  void press(int position){
        for (int i = 0;i <list.size();i++){
            Catagory.DataBean dataBean = list.get(i);
            dataBean.setChecked(false);
        }
        Catagory.DataBean dataBean = list.get(position);
        dataBean.setChecked(true);
        notifyDataSetChanged();
    }
}
