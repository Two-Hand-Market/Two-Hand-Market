package com.demo.secondmarket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import sql.Topic;

/**
 * Created by Administrator on 2015/12/12.
 */
public class ActivityGoodsDetails extends Activity implements View.OnClickListener{

    private TextView t1,t2,t3,t4,t5;
    private ImageButton mBackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_details);

        initview();
        initevent();
    }

    private void initevent() {
        mBackImageButton.setOnClickListener(this);
    }

    private void initview() {
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        Topic topic = (Topic) bundle.getSerializable("topic");

        t1= (TextView) findViewById(R.id.goods_title);
        t2= (TextView) findViewById(R.id.goods_price);
        t3= (TextView) findViewById(R.id.goods_old_price);
        t4= (TextView) findViewById(R.id.goods_contact_person);
        t5= (TextView) findViewById(R.id.goods_describe);
        mBackImageButton = (ImageButton) findViewById(R.id.back_to_goodlist_ib);

        t1.setText(topic.getTitle());
        t2.setText(topic.getPrice());
        t3.setText(topic.getOld_price());
        t4.setText(topic.getContact_name());
        t5.setText(topic.getDescribe());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_to_goodlist_ib :
                Intent intent = new Intent();
                intent.setClass(this,MainActivity.class);
                this.startActivity(intent);
                break;
        }
    }
}
