package com.demo.secondmarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2015/11/16.
 */
public class NewsFragment extends Fragment {

    private Button bt3;
    private View MyView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);

        bt3 = (Button) view.findViewById(R.id.jump_button);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(getActivity(),Activity_topicDetail.class);
                getActivity().startActivity(it);
            }
        });

        return view;

    }






}
