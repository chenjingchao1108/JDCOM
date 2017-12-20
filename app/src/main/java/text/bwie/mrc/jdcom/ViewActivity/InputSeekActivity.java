package text.bwie.mrc.jdcom.ViewActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import text.bwie.mrc.jdcom.MainActivity;
import text.bwie.mrc.jdcom.R;

/**
 * 输入内容搜索的页面
 */
public class InputSeekActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView seek_recyclerView;

    private TextView seekCK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_seek);
        InitView();
    }

    private void InitView() {
        ImageView goback = (ImageView) findViewById(R.id.seek_goback);
        //切换布局
        seekCK = (TextView) findViewById(R.id.seek_textview);

        goback.setOnClickListener(this);
        seekCK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.seek_goback://返回按钮
                finish();
                break;
            case R.id.seek_textview:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}