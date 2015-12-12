package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.secondmarket.R;

import java.util.List;

import beans.Goods;

/**
 * Created by Administrator on 2015/11/17.
 */
public class ListGoodAdapter extends BaseAdapter{

    private List<Goods> goodsList;
    private LayoutInflater inflater;

    private ImageView imageView;
    private TextView title;
    private TextView content;
    private TextView price;
    
//    public ListGoodAdapter(List<Goods> data){
//        goodsList=data;
//    }

    @Override
    public int getCount() {
        return goodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return goodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.listview_item,null);

        imageView= (ImageView) convertView.findViewById(R.id.goodpic);
        title= (TextView) convertView.findViewById(R.id.goodtitle);
        content= (TextView) convertView.findViewById(R.id.goodcontent);
        price= (TextView) convertView.findViewById(R.id.goodprice);

        imageView.setImageResource(R.mipmap.ic_launcher);
        title.setText("Title");
        content.setText("Content");
        price.setText("Price");

        return convertView;
    }
}
