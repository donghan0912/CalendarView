package com.haibin.calendarviewproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarviewproject.base.activity.BaseActivity;

import java.util.List;

import androidx.appcompat.app.AlertDialog;

/**
 * 测试界面
 * Created by huanghaibin on 2018/8/7.
 */

public class TestActivity extends BaseActivity implements View.OnClickListener {

    private CalendarView mCalendarView;
    public static void show(Context context) {
        context.startActivity(new Intent(context, TestActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        setStatusBarDarkMode();
        findViewById(R.id.iv_next).setOnClickListener(this);
        findViewById(R.id.iv_pre).setOnClickListener(this);
        mCalendarView =  findViewById(R.id.calendar_view);
        findViewById(R.id.test).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_next:
                mCalendarView.scrollToNext(false);
                break;
            case R.id.iv_pre:
                mCalendarView.scrollToPre(false);
                break;
            case R.id.test:
                test();
                break;
        }
    }

    private AlertDialog mFuncDialog;
    private void test() {
        final DialogInterface.OnClickListener listener =
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            mCalendarView.setWeekStarWithSun();
                            break;
                        case 1:
                            mCalendarView.setWeekStarWithMon();
                            break;
                        case 2:
                            mCalendarView.setWeekStarWithTue();
                            break;
                        case 3:
                            mCalendarView.setWeekStarWithWed();
                            break;
                        case 4:
                            mCalendarView.setWeekStarWithThu();
                            break;
                        case 5:
                            mCalendarView.setWeekStarWithFri();
                            break;
                        case 6:
                            mCalendarView.setWeekStarWithSat();
                            break;

                    }
                }
            };

        if (mFuncDialog == null) {
            mFuncDialog = new AlertDialog.Builder(TestActivity.this)
                .setTitle(R.string.func_dialog_title)
                .setItems(R.array.test_dialog_item, listener)
                .create();
        }
        mFuncDialog.show();
    }
}
