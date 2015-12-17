package com.demo.secondmarket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.markmao.pulltorefresh.widget.XListView;

import adapter.ListTopicAdapter;
import sql.Service;
import sql.Topic;

/**
 * Created by Administrator on 2015/11/16.
 */
public class MainViewFragment extends Fragment implements XListView.IXListViewListener {


    private Context context;
    private XListView listTopic;
    private ListTopicAdapter topicData;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = this.getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_mainview,container,false);
        FindView(retView);

        Service service=new Service(getActivity());
        topicData = new ListTopicAdapter(getActivity(),service.getData(0,10));
        listTopic.setAdapter(topicData);
        listTopic.setXListViewListener(this);

        listTopic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Topic topic = new Topic();
                topic = topicData.getItemData(position);

                Intent intent =new Intent();
                intent.setClass(getActivity(),ActivityGoodsDetails.class);
                Bundle bundle=new Bundle();

                bundle.putSerializable("topic", topic);
                intent.putExtras(bundle);


                getActivity().startActivity(intent);
            }
        });



        return retView;
    }





    private void FindView(View view){

        listTopic = (XListView)view.findViewById(R.id.listView);
    }


    @Override
    public void onRefresh() {
        Service service = new Service(getActivity());
        topicData = new ListTopicAdapter(getActivity(), service.getData(0, 10));
        listTopic.setAdapter(topicData);
        listTopic.stopRefresh();
        Toast.makeText(context,"刷新成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore() {
        Toast.makeText(context,"加载成功",Toast.LENGTH_SHORT).show();
        listTopic.stopLoadMore();
    }
}
