package com.demo.secondmarket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2015/12/12.
 */
public class ActivityGoodsDetails extends Activity implements View.OnClickListener{

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
        mBackImageButton = (ImageButton) findViewById(R.id.back_to_goodlist_ib);
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
