package com.bwei.myplayer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
public class MainActivity extends Activity {
    @BindView(R.id.but_01)
    Button but01;
    @BindView(R.id.but_02)
    Button but02;
    @BindView(R.id.js)
    JCVideoPlayerStandard js;
    String s1 = "http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //  getSupportActionBar().setTitle("jiecaovideoplayer的使用");
        js.setUp(s1, js.SCREEN_LAYOUT_NORMAL, "视频标题");
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @OnClick({R.id.but_01, R.id.but_02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_01:
                Toast.makeText(this, "加入成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.but_02:
                break;
        }
    }
}
