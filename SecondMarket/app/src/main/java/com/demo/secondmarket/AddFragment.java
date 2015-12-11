package com.demo.secondmarket;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import sql.Service;
import sql.Topic;

/**
 * Created by Administrator on 2015/11/19.
 */
public class AddFragment extends Fragment implements View.OnClickListener{

    private Context context;

    private EditText mTitleEt;
    private EditText mPriceEt;
    private EditText mOldPriceEt;
    private EditText mDescribeEt;
    private EditText mPeopleNameEt;
    private EditText mTelEt;

    private Button mCommitBt;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = this.getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_add,container,false);
        initview(retView);
        initevent();
        return retView;
    }

    private void initevent() {
        mCommitBt.setOnClickListener(this);
    }

    private void initview(View v) {
        mTitleEt= (EditText) v.findViewById(R.id.add_title_et);
        mPriceEt= (EditText) v.findViewById(R.id.add_price_et);
        mOldPriceEt= (EditText) v.findViewById(R.id.add_oldprice_et);
        mDescribeEt= (EditText) v.findViewById(R.id.add_content_et);
        mPeopleNameEt= (EditText) v.findViewById(R.id.add_master_et);
        mTelEt= (EditText) v.findViewById(R.id.add_phone_et);

        mTitleEt.setText("测试标题");
        mPriceEt.setText("110");
        mOldPriceEt.setText("100");
        mDescribeEt.setText("描述");
        mPeopleNameEt.setText("测试联系人");
        mTelEt.setText("18888888");

        mCommitBt= (Button) v.findViewById(R.id.add_commit);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_commit:
                Service service = new Service(getActivity().getApplicationContext());
                service.addData(getTopic());
                break;
        }
    }

    public Topic getTopic() {
        Topic topic = new Topic();
        topic.setTitle(mTitleEt.getText().toString());
        topic.setPrice(mPriceEt.getText().toString());
        topic.setOld_price(mOldPriceEt.getText().toString());
        topic.setDescribe(mDescribeEt.getText().toString());
        topic.setContact_name(mPeopleNameEt.getText().toString());
        topic.setTellPhone(mTelEt.getText().toString());
        return topic;
    }
}
