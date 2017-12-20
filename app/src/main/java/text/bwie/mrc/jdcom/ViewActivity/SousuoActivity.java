package text.bwie.mrc.jdcom.ViewActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import text.bwie.mrc.jdcom.R;

public class SousuoActivity extends AppCompatActivity {

    private Button btn;
    private EditText ss;
    private String page;
    private String sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        initViwe();
        initData();
    }

    private void initData() {

    }

    private void initViwe() {
        btn = (Button) findViewById(R.id.search);
        ss = (EditText) findViewById(R.id.xinss);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = ss.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    Toast.makeText(SousuoActivity.this, "搜索内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(SousuoActivity.this, GoodInfoActivity.class);
                intent.putExtra("mingzi", s);
                startActivity(intent);
                finish();

            }
        });
    }
}