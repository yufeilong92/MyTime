package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTime;
    private MyTimeOneUitl timeOneUitl;
    private Button mBtnResteat;
    private Button mPause;
    private Button mCancle;
    private Button mContile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        timeOneUitl.start(mTvTime);
    }

    private void initView() {
        mTvTime = (TextView) findViewById(R.id.tv_time);
        timeOneUitl = MyTimeOneUitl.getInstance(this);
        mBtnResteat = (Button) findViewById(R.id.btn_resteat);
        mBtnResteat.setOnClickListener(this);
        mPause = (Button) findViewById(R.id.pause);
        mPause.setOnClickListener(this);
        mCancle = (Button) findViewById(R.id.cancle);
        mCancle.setOnClickListener(this);
        mContile = (Button) findViewById(R.id.contile);
        mContile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_resteat:

                break;
            case R.id.pause:

                break;
            case R.id.cancle:

                break;
            case R.id.contile:

                break;
        }
    }
}
