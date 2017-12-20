package text.bwie.mrc.jdcom.ViewActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import text.bwie.mrc.jdcom.Api.Api;
import text.bwie.mrc.jdcom.Bean.LoginBean.RigstBean;
import text.bwie.mrc.jdcom.MainActivity;
import text.bwie.mrc.jdcom.Net.LoginHttpclient;
import text.bwie.mrc.jdcom.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.Register_username)
    EditText mRegisterUsername;
    @BindView(R.id.Register_userpassword)
    EditText mRegisterUserpassword;
    @BindView(R.id.Register_buttonup)
    Button mRegisterButtonup;
    /**
     * 返回
     */
    private TextView mTextReturn;
    /**
     * 注册
     */
    private TextView mTextTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        ButterKnife.bind(this);


    }

    @OnClick({R.id.Register_username, R.id.Register_userpassword, R.id.Register_buttonup})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.Register_buttonup:
                //获取输入内容
                String name=mRegisterUsername.getText().toString().trim();
                String pwd=mRegisterUserpassword.getText().toString().trim();
                Map<String,String> map=new HashMap<>();
                map.put("mobile",name);
                map.put("password",pwd);
                LoginHttpclient.getHttpClient().doPost(map, Api.RIGST, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        final RigstBean rigstBean=new Gson().fromJson(response.body().string(),RigstBean.class);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,rigstBean.getMsg(),Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });
                break;
        }
    }

    private void initView() {
        mRegisterUsername = (EditText) findViewById(R.id.Register_username);
        mRegisterUserpassword = (EditText) findViewById(R.id.Register_userpassword);
        mRegisterButtonup = (Button) findViewById(R.id.Register_buttonup);
        mRegisterButtonup.setOnClickListener(this);
    }


}
