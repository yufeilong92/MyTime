package com.example.myapplication;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;


/**
 * @version V 1.0 xxxxxxxx
 * @Title: xcedu
 * @Package com.xuechuan.xcedu.utils
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/5/11 14:22
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class MyTimeUitl {
    private Context context;
    private long curTime = 0;
    private static int number = 0;
    private boolean isPause = false;
    private TextView mTimeView;
    private static long MAX_TIME = 0;
    private static MyTimeUitl timeUitl;

    public MyTimeUitl(Context context) {
        this.context = context;
    }

    public static MyTimeUitl getInstance(Context context) {
        if (timeUitl == null)
            timeUitl = new MyTimeUitl(context);
        return timeUitl;
    }

    /**
     * 开始
     *
     * @param tv
     * @param hour
     * @param min
     * @param ss
     */
    public void start(TextView tv, long hour, long min, long ss) {
        this.mTimeView = tv;
        number = 0;
        MAX_TIME = getTime(hour, min, ss);
        restart();
    }

    public static long getNubmer() {
        if (number * 1000 >= MAX_TIME)
            return MAX_TIME;
        return number * 1000;
    }

    /**
     * 重新开始
     */
    public void restart() {
        curTime = MAX_TIME;
        number = 0;
        mHandler.removeCallbacks(runnable);
        mHandler.postDelayed(runnable, 1000);
    }

    public long getTime(long hour, long min, long ss) {
        if (hour == 0 && min == 0 && ss == 0)
            return 0;
        return hour * 60 * 60 * 1000 + min * 60 * 1000 + ss * 1000;
    }


    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            curTime -= 1000;

            number += 1;
            mTimeView.setText(TimeTools.getCountTimeByLong(curTime));
            if (curTime > 0) {
                mHandler.postDelayed(this, 1000);
            }
        }
    };

    /**
     * 取消
     */
    public void cancel() {
        number = 0;
        mTimeView.setText("00:00:00");
        mHandler.removeCallbacks(runnable);
    }

    /**
     * 暂停
     */
    public void pause() {
        if (!isPause) {
            mHandler.removeCallbacks(runnable);
        }
    }

    /**
     * 继续
     */
    public void resume() {
        mHandler.removeCallbacks(runnable);
        mHandler.postDelayed(runnable, 1000);
    }
}
