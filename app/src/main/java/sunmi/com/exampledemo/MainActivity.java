package sunmi.com.exampledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.maning.librarycrashmonitor.MCrashMonitor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_example;
    private Button btn_example_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_example = (Button) findViewById(R.id.btn_example);
        btn_example_log = (Button) findViewById(R.id.btn_example_log);

        btn_example.setOnClickListener(this);
        btn_example_log.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_example:
                //手动造成一个Crash
             //   throw new NullPointerException("自定义异常抛出");

                Object obj = null;
                obj.toString();
                break;
            case R.id.btn_example_log:
                //打开日志列表
                MCrashMonitor.startCrashListPage(this);
                break;
             default:
                 break;
        }
    }
}
