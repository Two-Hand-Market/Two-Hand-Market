package com.demo.secondmarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import imageadd.ImageUtils;
import utils.MessageInteface;

public class MainActivity extends FragmentActivity implements View.OnClickListener, MessageInteface {

    private LinearLayout mMainView;
    private LinearLayout mSort;
//    private LinearLayout mAdd;
    private LinearLayout mFind;
    private LinearLayout mMe;

    private ImageButton mMainView_img;
    private ImageButton mSort_img;
    private ImageButton mAdd_img;
    private ImageButton mFind_img;
    private ImageButton mMe_img;

    private Fragment mMainViewFragment;
    private Fragment mSortFragment;
    private Fragment mAddFragment;
    private Fragment mFindFragment;
    private Fragment mMeFragment;

    private TextView titleText;
    private TextView mMainView_tv;
    private TextView mSort_tv;
    private TextView mFind_tv;
    private TextView mMe_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_main);

        //初始化
        initview();
        //初始化监听事件
        initevent();
        //初始调用主页的Fragement
        setSelect(0);
    }

    private void initevent() {
        mMainView.setOnClickListener(this);
        mSort.setOnClickListener(this);
//        mAdd.setOnClickListener(this);
        mFind.setOnClickListener(this);
        mMe.setOnClickListener(this);

        mMainView_img.setOnClickListener(this);
        mSort_img.setOnClickListener(this);
        mAdd_img.setOnClickListener(this);
        mFind_img.setOnClickListener(this);
        mMe_img.setOnClickListener(this);

    }

    private void initview() {
        mMainView = (LinearLayout) findViewById(R.id.mainview);
        mSort = (LinearLayout) findViewById(R.id.sort);
//        mAdd = (LinearLayout) findViewById(R.id.add);
        mFind = (LinearLayout) findViewById(R.id.find);
        mMe = (LinearLayout) findViewById(R.id.me);

        mMainView_img = (ImageButton) findViewById(R.id.mainview_img);
        mSort_img = (ImageButton) findViewById(R.id.sort_img);
        mAdd_img = (ImageButton) findViewById(R.id.add_img);
        mFind_img = (ImageButton) findViewById(R.id.find_img);
        mMe_img = (ImageButton) findViewById(R.id.me_img);

        mMainView_tv= (TextView) findViewById(R.id.mainview_tv);
        mSort_tv= (TextView) findViewById(R.id.sort_tv);
        mFind_tv= (TextView) findViewById(R.id.find_tv);
        mMe_tv= (TextView) findViewById(R.id.me_tv);

        titleText = (TextView) findViewById(R.id.titleText);
    }

    @Override
    public void onClick(View v) {
        //重置图片颜色
        resetImgs();

        switch(v.getId()){
            case R.id.mainview:
            case R.id.mainview_img:
                setSelect(0);
                break;
            case R.id.sort:
            case R.id.sort_img:
                setSelect(1);
                break;
            case R.id.add_img:
                setSelect(2);
                break;
            case R.id.find:
            case R.id.find_img:
                setSelect(3);
                break;
            case R.id.me:
            case R.id.me_img:
                setSelect(4);
                break;

        }
    }

    private void setSelect(int i) {
        //将图片设置为亮色，并且切换Fragment

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //隐藏Fragment
        hideFragment(transaction);

        switch (i){
            case 0:
                if(mMainViewFragment == null){
                    mMainViewFragment = new MainViewFragment();
                    transaction.add(R.id.framecontent,mMainViewFragment);
                }else{
                    transaction.show(mMainViewFragment);
                }
                mMainView_img.setImageResource(R.drawable.icon_1_d);
                mMainView_tv.setTextColor(getResources().getColor(R.color.blue_light));
                titleText.setText("主页");
                break;

            case 1:
                if(mSortFragment == null){
                    mSortFragment = new NewsFragment();
                    transaction.add(R.id.framecontent,mSortFragment);
                }else{
                    transaction.show(mSortFragment);
                }
                mSort_img.setImageResource(R.drawable.icon_2_d);
                mSort_tv.setTextColor(getResources().getColor(R.color.blue_light));
                titleText.setText("消息");
                break;

            case 2:
                if(mAddFragment == null){
                    mAddFragment = new AddFragment();
                    transaction.add(R.id.framecontent,mAddFragment);
                }else{
                    transaction.show(mAddFragment);
                }
                mAdd_img.setImageResource(R.drawable.icon_add);
                titleText.setText("添加");
                break;

            case 3:
                if(mFindFragment == null){
                    mFindFragment = new FindFragment();
                    transaction.add(R.id.framecontent,mFindFragment);
                }else{
                    transaction.show(mFindFragment);
                }
                mFind_img.setImageResource(R.drawable.icon_4_d);
                mFind_tv.setTextColor(getResources().getColor(R.color.blue_light));
                titleText.setText("查找");
                break;

            case 4:
                if(mMeFragment == null){
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.framecontent,mMeFragment);
                }else{
                    transaction.show(mMeFragment);
                }
                mMe_img.setImageResource(R.drawable.icon_3_d);
                mMe_tv.setTextColor(getResources().getColor(R.color.blue_light));
                titleText.setText("个人中心");
                break;

            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if(mMainViewFragment!=null){
            transaction.hide(mMainViewFragment);
        }
        if(mSortFragment!=null){
            transaction.hide(mSortFragment);
        }
        if(mAddFragment!=null){
            transaction.hide(mAddFragment);
        }
        if(mFindFragment!=null){
            transaction.hide(mFindFragment);
        }
        if(mMeFragment!=null){
            transaction.hide(mMeFragment);
        }
    }

    private void resetImgs() {
        mMainView_img.setImageResource(R.drawable.icon_1_n);
        mSort_img.setImageResource(R.drawable.icon_2_n);
        mAdd_img.setImageResource(R.drawable.icon_add);
        mFind_img.setImageResource(R.drawable.icon_4_n);
        mMe_img.setImageResource(R.drawable.icon_3_n);

        mMainView_tv.setTextColor(getResources().getColor(R.color.textcolor));
        mSort_tv.setTextColor(getResources().getColor(R.color.textcolor));
        mFind_tv.setTextColor(getResources().getColor(R.color.textcolor));
        mMe_tv.setTextColor(getResources().getColor(R.color.textcolor));
    }

    @Override
    public void showMessage(String msg) {
        if(msg.equals("0")){    // 拍照


        }
        else
            if(msg.equals("1")){ // 图库选择

            }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == getActivity().RESULT_CANCELED) {
//            return;
//        }

        switch (requestCode) {
            // 拍照获取图片
            case ImageUtils.GET_IMAGE_BY_CAMERA:
                // uri传入与否影响图片获取方式,以下二选一
                // 方式一,自定义Uri(ImageUtils.imageUriFromCamera),用于保存拍照后图片地址
                if(ImageUtils.imageUriFromCamera != null) {
                    // 可以直接显示图片,或者进行其他处理(如压缩或裁剪等)
//                    mImageShow.setImageURI(ImageUtils.imageUriFromCamera);
                    // 对图片进行裁剪
//                    ImageUtils.cropImage(getActivity(), ImageUtils.imageUriFromCamera);
                    break;
                }

                break;
            // 手机相册获取图片
            case ImageUtils.GET_IMAGE_FROM_PHONE:
//                if(data != null && data.getData() != null) {
//                    // 可以直接显示图片,或者进行其他处理(如压缩或裁剪等)
//                    mImageShow.setImageURI(data.getData());
//
//                    // 对图片进行裁剪
////                    ImageUtils.cropImage(getActivity(), data.getData());
//                }
                break;
            // 裁剪图片后结果
            case ImageUtils.CROP_IMAGE:
                if(ImageUtils.cropImageUri != null) {
                    // 可以直接显示图片,或者进行其他处理(如压缩等)
//                    mImageShow.setImageURI(ImageUtils.cropImageUri);
                }
                break;
            default:
                break;

        }
    }

}
