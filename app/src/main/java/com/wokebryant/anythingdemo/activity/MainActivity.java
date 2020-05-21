package com.wokebryant.anythingdemo.activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wokebryant.anythingdemo.Constant;
import com.wokebryant.anythingdemo.Demo.MulitTypeRV.adapter.MulitAdpter;
import com.wokebryant.anythingdemo.Demo.MulitTypeRV.bean.BannerBean;
import com.wokebryant.anythingdemo.Demo.MulitTypeRV.bean.ContentBean;
import com.wokebryant.anythingdemo.Demo.MulitTypeRV.decorate.Visitable;
import com.wokebryant.anythingdemo.R;
import com.wokebryant.anythingdemo.dialog.VoiceLiveChiefPanel;
import com.wokebryant.anythingdemo.dialog.VoiceLiveCommonDialog;
import com.wokebryant.anythingdemo.dialog.VoiceLiveFinishDialog;
import com.wokebryant.anythingdemo.dialog.VoiceLivePlacardDialog;
import com.wokebryant.anythingdemo.mapper.TestData;
import com.wokebryant.anythingdemo.util.UIUtil;
import com.wokebryant.anythingdemo.view.ProgressSendView;
import com.wokebryant.anythingdemo.view.WaveProgressView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int UPDATE_PROGRESS = 1;
    private static final int MAX_PROGRESS = 100;
    private int mCurrentProgress = 0;
    private WaveProgressView mWaveProgressView;
    private Button mButton,mButton2;

    private VoiceLiveChiefPanel mChiefPanel;
    private VoiceLiveCommonDialog mCommonDialog;
    private VoiceLivePlacardDialog mPlacardDialog;
    private VoiceLiveFinishDialog mLiveFinishDialog;

    private ProgressSendView mProgressView;
    private RecyclerView mRecycleView;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_PROGRESS:
                    if (mCurrentProgress != MAX_PROGRESS) {
                        mCurrentProgress += 1;
                        mWaveProgressView.setProgress(mCurrentProgress);
                        sendEmptyMessageDelayed(UPDATE_PROGRESS,100);
                    } else {
                        mCurrentProgress = 0;
                        mWaveProgressView.setProgress(0);
                        mWaveProgressView.resetProgress();
                        sendEmptyMessageDelayed(UPDATE_PROGRESS,100);
                        //mWaveProgressView.release();
                    }
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        initData();
    }

    private void initView() {
        mWaveProgressView = findViewById(R.id.waveProgressView);
        mProgressView = findViewById(R.id.testProgress);
        mRecycleView = findViewById(R.id.recycleView);
        mButton = findViewById(R.id.testBtn);
        mButton2 = findViewById(R.id.testBtn2);
        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);

        setLayoutParams();
    }

    private void initData() {
        mockRecycleViewData();
    }

    private void setLayoutParams() {
        if (mProgressView != null) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mProgressView.getLayoutParams();
            params.width = params.height = UIUtil.vp2px(this, 64);
            mProgressView.setLayoutParams(params);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.testBtn:
                //mHandler.sendEmptyMessageDelayed(UPDATE_PROGRESS,100);
                mWaveProgressView.startWaveProgress(true);
                mWaveProgressView.setProgress(50);
//                showChiefPanel();
//                showFinishDialog();

                break;
            case R.id.testBtn2:
                showCommonDialog();
//                showPlacardDialog();
//                showProgressRing();
            default:
        }
    }

    private void showChiefPanel() {
        if (this != null && !this.isFinishing()) {
            try{
                if (mChiefPanel == null) {
                    mChiefPanel = VoiceLiveChiefPanel.newInstance();
                }
                mChiefPanel.setChiefInfo("1747105","","勒布朗","1802",true);
                mChiefPanel.setIsChief(true);
                mChiefPanel.setListData(TestData.getManagerData(),TestData.getHostData());
                if (!mChiefPanel.isAdded()) {
                    FragmentManager manager = getSupportFragmentManager();
                    mChiefPanel.show(manager,"VoiceLiveChiefPanel");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showCommonDialog() {
        VoiceLiveCommonDialog commonDialog = new VoiceLiveCommonDialog(this, "湖人总冠军", "勒布朗", "詹姆斯", new VoiceLiveCommonDialog.OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(getBaseContext(),"确定按钮点击",Toast.LENGTH_SHORT).show();
            }
        });
//        commonDialog.show();

        VoiceLiveCommonDialog commonDialog2 = new VoiceLiveCommonDialog(this, Constant.lakersChampion, "勒布朗", "詹姆斯", new VoiceLiveCommonDialog.OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(getBaseContext(), "确定按钮点击", Toast.LENGTH_SHORT).show();
            }
        }, new VoiceLiveCommonDialog.OnCancelListener() {
            @Override
            public void onCancel() {
                Toast.makeText(getBaseContext(), "取消按钮点击", Toast.LENGTH_SHORT).show();
            }
        });
        commonDialog2.show();
        commonDialog2.setCancelBtnVisible(View.GONE);
    }

    private void showFinishDialog() {
        VoiceLiveFinishDialog finishDialog = new VoiceLiveFinishDialog(this);
        finishDialog.showPopWindow();
        finishDialog.showAtTime(3000);
    }

    private void showPlacardDialog() {
        VoiceLivePlacardDialog placardDialog = new VoiceLivePlacardDialog(this);
        placardDialog.setIsThief(false);
        placardDialog.setPlacardContent("勒布朗", Constant.lakersChampion, Constant.lakersChampion);
        placardDialog.show();
    }

    private void showProgressRing() {
        if (mProgressView != null) {
            mProgressView.resetAndStartProgress("0");
        }
    }

    private void mockRecycleViewData() {
        //  模拟本地数据
        List<Visitable> beans = new ArrayList<>();
        beans.add(new BannerBean(
                "www.baidu.com"));
        beans.add(new ContentBean());
        beans.add(new BannerBean(
                "www.jd.com"));
        beans.add(new BannerBean(
                "www.baidu.com"));
        beans.add(new ContentBean());
        beans.add(new BannerBean(
                "www.qq.com"));
        beans.add(new ContentBean());
        beans.add(new BannerBean(
                "www.sina.com"));
        beans.add(new ContentBean());
        beans.add(new BannerBean(
                "www.taobao.com"));
        beans.add(new ContentBean());
        MulitAdpter multiRecyclerAdapter = new MulitAdpter(beans);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycleView.setLayoutManager(linearLayoutManager);
        mRecycleView.setAdapter(multiRecyclerAdapter);
    }

}
