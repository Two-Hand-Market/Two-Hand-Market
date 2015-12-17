package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.secondmarket.R;

import java.util.List;

import sql.Topic;

/**
 * Created by Administrator on 2015/11/17.
 */
public class ListTopicAdapter extends BaseAdapter{

    private List<Topic> topicList;
    private LayoutInflater inflater;

    
    public ListTopicAdapter(Context context,List<Topic> data){
        inflater=LayoutInflater.from(context);
        topicList=data;
    }

    @Override
    public int getCount() {
        return topicList.size();
    }

    @Override
    public Object getItem(int position) {
        return topicList.get(position);
    }

    public Topic getItemData(int position)
    {
        Topic topic = new Topic();
        topic = topicList.get(position-1);
        return topic;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.listview_item,null);
        TextView tvGoodTitle = (TextView) convertView.findViewById(R.id.goodtitle);
        TextView tvGoodContent = (TextView) convertView.findViewById(R.id.goodcontent);
        TextView tvGoodPrice = (TextView) convertView.findViewById(R.id.goodprice);
        Topic topic = topicList.get(position);
        tvGoodTitle.setText(topic.getTitle());
        tvGoodContent.setText(topic.getDescribe());
        tvGoodPrice.setText(topic.getPrice());
        return convertView;
    }
}
